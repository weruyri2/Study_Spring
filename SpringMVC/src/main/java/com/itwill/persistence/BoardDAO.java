package com.itwill.persistence;

import java.util.List;

import com.itwill.domain.BoardVO;
import com.itwill.domain.Criteria;

public interface BoardDAO {
	//게시판 처리 동작을 선언 (추상 메소드를 사용해서 선언)
	
	//게시 글 작성
	public void create(BoardVO vo) throws Exception;
	
	//글 목록
	public List<BoardVO> getList() throws Exception;
	
	//게시판 글 본문보기(read)
	public BoardVO read(int bno) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(int bno) throws Exception;

	public List<BoardVO> listPage(Criteria cri) throws Exception;

	public int bdcount(Criteria cri) throws Exception;

}
