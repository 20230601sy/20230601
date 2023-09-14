package p03_shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import p03_shopping.util.DBManager;
import p03_shopping.vo.ProductVO;

public class ProductDAO {
	private ProductDAO() {}
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
	public List<ProductVO> getProductList() {
		List<ProductVO> result = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from product order by code desc");
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCode(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setPictureUrl(rs.getString(4));
				vo.setDescription(rs.getString(5));
				result.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return result;
	}
	
	public ProductVO getProduct(Integer code) {
		ProductVO vo = null;
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from product where code=?");
			ps.setInt(1, code);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new ProductVO();
				vo.setCode(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setPictureUrl(rs.getString(4));
				vo.setDescription(rs.getString(5));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return vo;
	}
	
	public void updateSql(ProductVO vo, String sql, int[] idx) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			if(idx[0]!=0) ps.setInt(idx[0], vo.getCode());
			if(idx[1]!=0) ps.setString(idx[1], vo.getName());
			if(idx[2]!=0) ps.setInt(idx[2], vo.getPrice());
			if(idx[3]!=0) ps.setString(idx[3], vo.getPictureUrl());
			if(idx[4]!=0) ps.setString(idx[4], vo.getDescription());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps);
		}
	}
	

	public void insertProduct(ProductVO vo) {
		updateSql(vo, "insert into product values(product_seq.nextval, ?, ?, ?, ?)", new int[] {0, 1, 2, 3, 4});
	}
	public void updateProduct(ProductVO vo) {
		updateSql(vo, "update product set name=?, price=?, pictureUrl=?, description=? where code=?", new int[] {5, 1, 2, 3, 4});
	}
	public void deleteProduct(int code) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from product where code=?");
			ps.setInt(1, code);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps);
		}
	}
}