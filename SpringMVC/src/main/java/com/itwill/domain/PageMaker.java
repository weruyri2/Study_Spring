package com.itwill.domain;

public class PageMaker {
	// 페이징 처리에 대한 전반적인 처리

	// 2) 게시판 하단 페이징 처리
	// 게시판 글 총 개수
	private int totalCount;
	// 페이지 처리 시작
	private int startPage;
	// 페이지 처리 끝
	private int endPage;
	// 이전
	private boolean prev;
	// 다음
	private boolean next;
	
	// 페이지 블럭(페이지를 몇개씩 출력할것인지 결정)
	private int displayPageNum=5;

	// 1) 게시판 뿌리기 -> Criteria 객체 (페이지 번호 +페이지 사이즈)
	private Criteria cri;

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		// 계산을 통해서 페이징처리 인자의 값을 구하기
		calcPage();
	}
	
	// [시작페이지,끝페이지,이전,다음] 계산하는 메서드
	public void calcPage() {
		
		endPage 
		=(int)Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum;
		
		startPage
		= (endPage - displayPageNum) + 1;
		
		int tmpEndpage 
		=(int)Math.ceil(totalCount/(double)cri.getPageSize());
		
		if(endPage > tmpEndpage) {
			endPage = tmpEndpage;
		}
		
		prev = startPage == 1? false:true;
		
		next = endPage * cri.getPageSize() >= totalCount? false:true;
		
	}

	
	// get/set 메서드
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public Criteria getCri() {
		return cri;
	}
	
	// toString()
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
}
