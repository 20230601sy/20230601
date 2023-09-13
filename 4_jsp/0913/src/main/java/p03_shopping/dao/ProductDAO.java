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
	
	public void insertProduct(ProductVO vo) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("insert into product values(product_seq.nextval, ?, ?, ?, ?)");
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getPictureUrl());
			ps.setString(4, vo.getDescription());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps);
		}
	}
}