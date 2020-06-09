package com.itwill.service;

import java.util.List;

import com.itwill.domain.BoardVO;
import com.itwill.domain.Criteria;

public interface BoardService {

	// 글쓰기 
	public void regist(BoardVO vo) throws Exception;
	
	//글목록 
	public List<BoardVO> BoardList() throws Exception;
	
	//게시판 글 본문보기(read)
	public BoardVO read(int bno) throws Exception;

	public void update(BoardVO vo) throws Exception;
	
	public void delete(int bno) throws Exception;

	List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int bdcount(Criteria cri) throws Exception;
}
