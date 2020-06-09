package com.itwill.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwill.domain.BoardVO;
import com.itwill.domain.Criteria;
import com.itwill.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO bdao;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		// 컨트롤러에 요청 받아서 DAO로 전달
		System.out.println("@@ Service 계층 글작성 동작 실행");
		bdao.create(vo);
		
		System.out.println("@@ DAO에서 글쓰기 처리 완료 !");
		;
		
		
	}

	@Override
	public List<BoardVO> BoardList() throws Exception {
		System.out.println("@@ Service 계층 글작성 동작 실행");
		
		List<BoardVO> boardList = bdao.getList();
		
		System.out.println("@@ DAO에서 글목록 처리 완료 !");
		
		return boardList;
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		System.out.println("@@ Service 계층 글 본문읽기 동작 실행");
		
		BoardVO boardVO = bdao.read(bno);
		
		System.out.println("@@ DAO에서 본문읽기 동작 실행");
		
		return boardVO;
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		System.out.println("@@ Service 계층 글 update 동작 실행");
		bdao.update(vo);

	}

	@Override
	public void delete(int bno) throws Exception {
		System.out.println("@@ Service 계층 글 delete 동작 실행");
		bdao.delete(bno);
		
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {

		System.out.println("@@@@ 서비스 : 리스트 출력 메서드 호출(페이징처리) ");
		
		return bdao.listPage(cri);
	}

	@Override
	public int bdcount(Criteria cri) throws Exception {
		System.out.println("@@@@ 서비스 : 리스트 출력 메서드 호출(페이징처리) ");
		
		return bdao.bdcount(cri);
		
	}


}
