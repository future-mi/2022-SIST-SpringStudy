package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class FoodController {
	/*
	 * 요청 → 처리 → JSP전송(jsp파일명 지정)
	 * forward(파일명)
	 * sendRedirect (재전송 : .do)
	 * 
	 * 1. Controller(Model)
	 *  1) class위에 반드시 @Controller설정
	 *  2) 필요한 객체를 스프링으로부터 자동 설정 / @Autowired
	 *  3) 기능별 분리 : @RequestMapping, @GetMapping, @PostMapping
	 */
	// 필요한 객체 선언 → 자동주입
	@Autowired
	private FoodService sevice;
	
	@GetMapping("food/category.do")
	public String food_category(Model model) {
		// 1. dao연동
		List<CategoryVO> list=sevice.categoryAllData();
		// 2. category.jsp에 데이터를 전송
		model.addAttribute("list", list);
		return "food/category";
	}
	
	@GetMapping("food/food_list.do")
	public String food_list(int cno,Model model) {
		model.addAttribute("cno", cno);
		return "food/food_list";
	}
}
