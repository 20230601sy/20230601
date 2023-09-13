package util;

public class Paging {
	
//	JSP는 페이징을 지원하지 않아서 직접 구현해야 한다심... Spring하면 직접 할 일은 없다심
//	■. 페이징 구현 전
//	1. 클라이언트가 서블릿으로 요청 보냄
//	2. 서블릿이 DB에 연결 전체 레코드를 구함
//	3. DB에서 조회한 전체 레코드를 서블릿에서 받아옴
//	4. 전체 레코드를 클라이언트한테 응답
//	■. 페이징 구현 후
//	1. 클라이언트가 서블릿으로 xx 페이지 좀 보여주세요 요청
//	2. 서블릿이 xx페이지에 필요한 정보를 정리
//	3. 서블릿이 정리한 정보를 DB로 보냄
//	4. DB에서 xx페이지에 표시할 레코드만 뽑아옴
//	5. 뽑아온 레코드를 서블릿으로 보냄
//	6. 서블릿은 클라이언트한테 뽑아온 레코드를 응답
	
	private int page = 1;	// 현재 페이지를 나타내는 멤버변수
	private int totalPage;	// 전체 페이지
	private int total;		// 전체 레코드 수
	private int start = 1;		// 페이지 별 표시할 게시물의 시작 번호
	private int end = 10;		// 페이지 별 표시할 게시물의 끝 번호
	private int showRow = 10;	// 페이지당 표시할 개수, 원하는 값 초기 세팅
	private int showNum = 3;	// 블럭당 개수 (보고있는 페이지에 따라 달라짐)
	
	public void pageCalc(int total, int page) {
		this.total = total; // 어딘가에서 전체 레코드 수를 구해서 매개변수로 넣어줌
		totalPage = (int) Math.ceil((double)total/showRow);
		
		if(page >= 1 && page <= totalPage)
			this.page = page;
		
		start = (this.page-1)*showRow + 1;
		end = start + showRow -1;
	}
	
	public void pageCalc(int total) {
		this.total = total; // 어딘가에서 전체 레코드 수를 구해서 매개변수로 넣어줌
		totalPage = (int) Math.ceil((double)total/showRow);
//		totalPage = (int) ( ( this.total + showRow - 1 ) / showRow );
		
		start = (page-1)*showRow + 1;
		end = start + showRow -1;
	}
	
	public void setPage(int page) {
		if(page >= 1 && page <= totalPage)
			this.page = page;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getShowNum() {
		return showNum;
	}
}
