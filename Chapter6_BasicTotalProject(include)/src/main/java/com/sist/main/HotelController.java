package com.sist.main;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class HotelController {
	@Autowired
	private HotelDAO dao;
	@GetMapping("seoul/hotel/list.do")
	public String seoul_hotel_list(HttpServletRequest request,String page,Model model) {
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page); // 현재페이지
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<HotelVO> list=dao.hotelListData(map);
		for(HotelVO vo:list) {
			String name=vo.getName();
			if(name.length()>10) {
				name=name.substring(0,10)+"...";
			}
			vo.setName(name);
		}
		// 총페이지 구하기
		int totalpage=dao.hotelTotalPage();
		// 블록별 처리
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		// JSP에서 출력하는 데이터를 전송
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("main_jsp","../seoul/hotel/list.jsp");
		
		// 쿠키출력
		Cookie[] cookies=request.getCookies();
		List<HotelVO> cList=new ArrayList<HotelVO>();
		if(cookies!=null) { //쿠키가 존재할 때
			for(int i=cookies.length-1;i>=0;i--) {	//최신등록된 데이터부터 읽기 시작
				if(cookies[i].getName().startsWith("h")) {
					String no=cookies[i].getValue();
					HotelVO vo=dao.hotelDetailData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
			model.addAttribute("cList", cList);
		}
		return "main/main";
	}
	
	// 쿠키설정
	@GetMapping("seoul/hotel/detail_before.do")
	public String seoul_hotel_detail_before(int no,RedirectAttributes ra, HttpServletRequest request, HttpServletResponse response) {
		// Cookie이용 → 내장 객체가 아니다, response로 클라이언트 전송
		// sendRedirect를 이용해서 화면 변경시 데이터 전송 → RedirectAttributes
		// 매개변수는 순서가 존재하지 않는다(원하는 데이터형으로 DispatcherServlet으로 ) 
		/*
		 * 매개변수를 이용해서 객체단위
		 * - HttpServletRequest : Cookie읽기
		 * - HttpServletResponse : Cookie전송, 다운로드시에 주로 사용
		 * - HttpSession : 로그인, 로그아웃...
		 * - 커맨드 객체 : ~VO : insert, update시에 단위를 VO단위로 받을 수 있다
		 * - 일반 데이터형 → int, double, boolean, String
		 * - RedirectAttributes : 전송객체(sendRedirect())
		 * 						  GET방식 → detail.do?no=1
		 * - Model : 전송객체(forward())
		 * 
		 * response를 이용해서 브라우저에 값을 전송(한개의 기능 메소드에서 HTML/Cookie를 동시에 전송 할 수 없다)
		 * 	- 각 JSP에서 한번만 사용이 가능
		 *  - HTML
		 *  - Cookie
		 *  
		 *  [ Cookie사용 ]
		 *  1. Cookie 생성
		 *  	Cookie cookie=new Cookie(키,값) → map 방식
		 *  	- 키는 중복이 불가능(덮어쓴다)
		 *  	- 값 : String만 저장이 가능 
		 *  2. 저장위치 설정
		 *  	- setPath("/")
		 *  3. 저장기간 설정
		 *  	- setMaxAge(초) → 60*60*24 → 0이면 삭제
		 *  4. 클라이언트로 전송
		 *  	- 쿠키는 클라이언트에 저장
		 *  	- 방문기록 / 자동로그인(저장)
		 */
		Cookie cookie=new Cookie("h"+no,String.valueOf(no));
		// 키는 중복이 있으면 안된다
		// path 설정
		cookie.setPath("/");
		// 기간설정
		cookie.setMaxAge(60*60*24);
		// 클라이언트로 전송 
		response.addCookie(cookie);
		ra.addAttribute("no", no);
		// redirect:/main/seoul/hotel/detail.do?no=1
		return "redirect:http://localhost:8080/main/seoul/hotel/detail.do";
	}
	
	@GetMapping("seoul/hotel/detail.do")
	public String seoul_hotel_detail(int no,Model model) {
		// 오라클로부터 데이터 읽기
		HotelVO vo=dao.hotelDetailData(no);
		model.addAttribute("vo",vo);
		// vo를 받아서 출력하는 JSP가 존재
		model.addAttribute("main.jsp", "../seoul/hotel/detail.jsp");
		// main에서 incude를 사용해서 화면을 조립
		return "main/main";
	}
}
