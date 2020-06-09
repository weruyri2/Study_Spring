package com.itwill.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 해당 클래스는 예외를 처리하는 클래스
@ControllerAdvice
public class CommonException {

	
	private static final Logger logger
	= LoggerFactory.getLogger(CommonException.class);
	
	// 해당 메서드가 괄호안에 있는 예외를 처리할 수 있도록 지정
//	@ExceptionHandler(Exception.class)
//	public String common(Exception e) {
//		
//		logger.info(e.toString());
//		
//		
//		return "error/error_common";
//	}
//	

	// * 일반 컨트롤러와 유사하게 사용되지만, Model 객체를 사용X
	// => ModelAndView객체 타입 사용
	// model 객체의 역할과 view의 역할 한번에 처리
	
	@ExceptionHandler(Exception.class)
	public ModelAndView commonModelAndView(Exception ex) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/error_common");
		mav.addObject("e", ex);
		
		return null;
	}
	
	
	
	
	
}
