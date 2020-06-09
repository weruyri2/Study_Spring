package com.itwill.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.domain.BoardVO;
import com.itwill.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	@Test
	public void testInsertBoard() throws Exception{
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("test");;
		vo.setContent("@@@@@@@@@@@@@@@@@@test@@@@@@@@@@@@@@");
		vo.setWriter("홍길동");
		
		dao.create(vo);
		
		System.out.println("@@@ 게시판 작성 완료 @@@");
	}
	
}
