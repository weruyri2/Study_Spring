package com.itwill.domain;

public class Criteria {
	// * 페이징 처리를 하기위한 정보를 저장하는 역활

	// 위치
	private int page;
	// 개수
	private int pageSize;

	public Criteria() {
		this.page = 1;
		this.pageSize = 10;
	}

	/*
	 * public int getPage() { return page; }
	 * 
	 * public void setPage(int page) { this.page = page; }
	 * 
	 * public int getPageSize() { return pageSize; }
	 * 
	 * public void setPageSize(int pageSize) { this.pageSize = pageSize; }
	 */
	public void setPageSize(int pageSize) {
		// 페이징처리의 범위 결정 10~100개까지
		// 0보다 적거나, 100보다 크면 기본설정 10개씩 처리
		if (pageSize <= 0 || pageSize > 100) {
			this.pageSize = 10;
			return;
		}
		this.pageSize = pageSize;
	}

	// 해당 메서드를 통해성 XML Mapper에 정보를 전달
	// #{pageSize}
	public int getPageSize() {
		return pageSize;
	}

	// 페이징 처리의 시작지점
	public void setPage(int page) {

		if (page <= 0) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public int getPage() {
		return page;
	}
	
	// SQL Mapper에서 사용되는 정보를 전달메서드
	// #{pageStart}
	//  시작 데이터번호 = (페이지번호-1) * 페이지당 출력 개수
	public int getPageStart() {
		// 전달받은 (저장된) page정보를 계산해서
		// 0, 10, 20, 30.....
		// 0, 20, 40, ....
		return (this.page - 1) * pageSize;
	}
	
	
	
	

}
