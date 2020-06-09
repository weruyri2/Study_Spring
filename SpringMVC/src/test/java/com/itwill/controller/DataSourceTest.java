package com.itwill.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //안 뜰 때, Maven 버전 다운 후 업
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class DataSourceTest {
	
	
	//DB연결 정보(DataSource 객체)
	//직접 생성X 스트림으로 부터 전달 (주입)
	@Inject
	private DataSource ds;
	
	//DB연결
	@Test
	public void testConn() throws Exception {
		
		try (Connection con = ds.getConnection()) {
			System.out.println("DB 연결 성공 : " + con);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패 : " + e);
		}
	}

}
