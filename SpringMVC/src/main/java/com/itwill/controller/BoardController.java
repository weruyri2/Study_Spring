package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.domain.BoardVO;
import com.itwill.domain.Criteria;
import com.itwill.domain.PageMaker;
import com.itwill.persistence.BoardDAO;
import com.itwill.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private final static Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	// 서비스 객체 (의존 주입)
	@Inject
	private BoardService service;
	
	//글쓰기 동작
//	@RequestMapping("/regist")
//	public void registGET() throws Exception{
//		
//		logger.info("@@@ controller registGet 호출");
//		logger.info("서비스 객체: "+service);
//		
//		BoardVO vo = new BoardVO();
//		
//		vo.setTitle("22222");;
//		vo.setContent("@@@@@@@@@@@@@@@@@@222@@@@@@@@@@@@@@");
//		vo.setWriter("홍길동");
//		
//		service.regist(vo);
//		
//		System.out.println("@@@ 게시판 작성 완료 @@@");
//		
//	}

//@RequestMapping(value = "매핑 될 주소", method= 메서드 방식)
@RequestMapping(value = "/register", method= RequestMethod.GET)
public void registGET() throws Exception{
	
	logger.info("@@@ controller registerGet 호출");
	logger.info("서비스 객체: "+service);
	logger.info("./board/register.jsp 페이지 호출");
	
	
}

@RequestMapping(value = "/register", method= RequestMethod.POST)
public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
	
	// * 메서드의 전달인자에 객체를 지정시,
	// 전달받는 데이
	//터를 알아서 저장해서 가져온다 (바인딩)
	// 단, 해당객체 데이터만 가져올 수 있음
	logger.info("@@@ controller registerPOST 호출");
	logger.info("board " + board);
	
	// 서비스 객체를 사용해서 정보 저장
	
	service.regist(board);
	System.out.println("@@@ 컨트롤러 : 글 저장완료! (다음페이지로 이동)");
	
	// 글정보 저장 성공 값 저장 -> 다음페이지로 전달
	//Model 객체에 저장
	
	rttr.addFlashAttribute("result", "SUCCESS");
	
//	return "/board/success";
	//return 값 주소 이동
//	글목록 페이지 (listAll)
//	return "/board/listAll";
	return "redirect:/board/listAll";
	
}

//글쓰기 이후 처리
@RequestMapping(value = "/listAll" ,method=RequestMethod.GET)
public void listAllGET(Model model, @ModelAttribute("result") String result) throws Exception {
	logger.info("@@@ /listAllGET 호출");
	logger.info("result 값 : " + result);
	
	//게시판 디비에 있는 정보를 가져와서 출력 (뷰페이지로 전달)
	// 서비스 계층에 있는 메서드 호출
	
	List<BoardVO> boardlist = service.BoardList();
	
	logger.info("글 정보" + boardlist);
	
	model.addAttribute("boardList", boardlist);
	
	
}

//특정 글 읽기(본문보기)
@RequestMapping(value = "/read", method=RequestMethod.GET)
public void readGET(Model model, @RequestParam("bno") Integer bno) throws Exception {
	System.out.println("@@@@@ /read 주소 호출");
	System.out.println("@@@@@ /read 글 본문보기 "+bno+"동작을 처리");
	
	BoardVO boardVO = service.read(bno);
	
	logger.info("글 정보" + boardVO);
	
	model.addAttribute("boardVO", boardVO);

	//전달정보(파라미터 값)
	//@RequestParam("파라미터값")
	//=>request.getParameter()처럼 사용됨(문자열,숫자,날짜 캐스팅 가능)
	
	// DB에 있는 정보를 가져오기 (bno에 해당하는 값 가져오기)
	
}

//특정 글 수정
@RequestMapping(value = "/update", method=RequestMethod.GET)
public void updateGET(Model model, @RequestParam("bno") Integer bno) throws Exception {
	System.out.println("@@@@@ /update 주소 호출");
	System.out.println("@@@@@ /update 글 본문보기 "+bno+"동작을 처리");
	
	BoardVO boardVO = service.read(bno);
	
	logger.info("글 정보" + boardVO);
	
	model.addAttribute("boardVO", boardVO);
	
	System.out.println("@@@@ 수정 페이지 이동");

	//전달정보(파라미터 값)
	//@RequestParam("파라미터값")
	//=>request.getParameter()처럼 사용됨(문자열,숫자,날짜 캐스팅 가능)
	
	// DB에 있는 정보를 가져오기 (bno에 해당하는 값 가져오기)
	
}

//특정 글 수정
@RequestMapping(value = "/updateAction", method=RequestMethod.POST)
public String updateActionPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
	System.out.println("@@@@@ /update 주소 호출");
	System.out.println("@@@@@ /update 글 본문보기 "+board+"동작을 처리");

	logger.info("board " + board);
	
	// 서비스 객체를 사용해서 정보 저장
	
	service.update(board);
	System.out.println("@@@ 컨트롤러 : 글 수정완료! (다음페이지로 이동)");
	
	// 글정보 저장 성공 값 저장 -> 다음페이지로 전달
	//Model 객체에 저장
	
	rttr.addFlashAttribute("result", "SUCCESS");
	
//	return "/board/success";
	//return 값 주소 이동
//	글목록 페이지 (listAll)
//	return "/board/listAll";
	return "redirect:/board/listAll";

}

// 글 삭제 처리
@RequestMapping(value = "/delete" , method=RequestMethod.POST)
public String deletePOST(@RequestParam("bno") int bno) throws Exception {
	// 페이지에 전달된 정보를 저장 (삭제할 글번호)
	System.out.println("@@@@ 삭제할 글번호 :" +bno);

	service.delete(bno);
	// 글 삭제 처리후 리스트로 이동
	System.out.println("@@@@ /delete(post) 주소 실행");
	
	return "redirect:/board/listAll";
	
}

// 글목록 페이지 (페이징처리)
@RequestMapping(value = "/listCri", method = RequestMethod.GET)
public void listCriGET(Criteria cri,Model model) throws Exception {
	// 게시판 디비에 있는 정보를 가져와서 출력(뷰페이지로 전달)
	// 서비스 계층에 있는 메서드 호출
	List<BoardVO> boardList = service.listCriteria(cri);
	logger.info("DB 글정보 가져오기 성공!!!");
	logger.info("글 정보 : " + boardList);
	
	PageMaker pm = new PageMaker();

	pm.setCri(cri);
//	pm.setTotalCount(130);
	pm.setTotalCount(service.bdcount(cri));
	System.out.println("@@@@ pm = "+pm);
	
	model.addAttribute("PageMaker" , pm);
	model.addAttribute("boardList", boardList);
}
	
}
