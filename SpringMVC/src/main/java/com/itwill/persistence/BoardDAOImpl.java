package com.itwill.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwill.domain.BoardVO;
import com.itwill.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwill.mapper.BoardMapper";
	@Override
	public void create(BoardVO vo) throws Exception {
		//게시글 작성
		System.out.println("@@ BoardBDAOImpl 객체 호출 -> Mapper이동 SQL실행 @@");
		sqlSession.insert(namespace+".create",vo);
		System.out.println("@@@ Mapper에서 Mysql 이동후 처리 완료 -> 호출된 곳으로 이동 @@@");
		
	}
	@Override
	public List<BoardVO> getList() throws Exception {
		System.out.println("getList bdao 호출");
		
		return 	sqlSession.selectList(namespace+".getList");
		
	}
	@Override
	public BoardVO read(int bno) throws Exception {
		System.out.println("read bdao 호출");
			
		return sqlSession.selectOne(namespace+".read",bno);
	}
	@Override
	public void update(BoardVO vo) throws Exception {
		System.out.println("modify bdao 호출");
		sqlSession.update(namespace+".update",vo);
	}
	@Override
	public void delete(int bno) throws Exception {
		System.out.println("delete bdao 호출");
		sqlSession.delete(namespace+".delete",bno);
		
	}
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		System.out.println("@@@ 페이징 처리 ( 원하는 개수 만큼 처리) ");
		return sqlSession.selectList(namespace+".listCri",cri);
	}
	@Override
	public int bdcount(Criteria cri) throws Exception {
		System.out.println("@@@ 페이징 처리 ( 원하는 개수 만큼 처리) ");
		return sqlSession.selectOne(namespace+".bdcount",cri);
	}



}
