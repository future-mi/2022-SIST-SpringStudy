package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.MemberVO;
/*
 * 스프링
 * @RequestMapping(GET+POST)
 * 	- @GetMapping
 * 	- @PostMapping
 * 
 * HttpServletRequest,HttpServletResponse는 보안상의 문자 
 * 접속자의 IP, 브라우저 (가급적이면 사용하지 않는다)
 *  - DispatcherServlet에서 값을 전송 (매개변수) 
 *  - 해당 JSP값을 전송 (Model)
 *  - command객체 → VO단위로 값을 받을 수 있다
 *  - 필요한 내장 객체, 사용자가 요청한 값은 매개변수로 받는다 
 */
// Model(요청처리)
//@Controller // Model클래스
public class MainController {
	// 요청 → 입력폼 제작
	@RequestMapping("main/input.do")
	public String main_input(HttpServletRequest request, HttpServletResponse response) {
		
		return "main/input";
	}
	// 사용자입력 → 전송 출력
	@RequestMapping("main/output.do")
	public String main_output(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String addr=request.getParameter("addr");
		String tel=request.getParameter("tel");
		
		MemberVO vo=new MemberVO();
		vo.setName(name);
		vo.setSex(sex);
		vo.setAddr(addr);
		vo.setTel(tel);
		
		request.setAttribute("vo", vo);
		return "main/output";
	}
}
