package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
@RequestMapping("board/")
public class BoardController {
   @Autowired
   private BoardDAO dao;
   
   @GetMapping("list.do")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=10;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   Map map=new HashMap();
	   map.put("start",start);
	   map.put("end",end);
	   List<BoardVO> list=dao.boardListData(map);
	   int totalpage=dao.boardTotalPage();
	   
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   return "board/list";
   }
   @GetMapping("insert.do")
   public String board_insert() {
	   return "board/insert";
   }
   @PostMapping("insert_ok.do")
   public String board_insert_ok(BoardVO vo) {
	   // 회원가입, 글쓰기, 수정, 답변 → name="" vo에 있는 변수명이 동일
	   dao.boardInsert(vo);
	   return "redirect:list.do";
   }
   @GetMapping("detail.do")
   public String board_detail(int no,Model model) {
	   BoardVO vo=dao.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   return "baord/detail";
   }
   // update.do?no=${vo.no }
   @GetMapping("update.do")
   public String board_update(int no,Model model) {
	   //model → request대신 데이터 전송하는 객체 
	   BoardVO vo=dao.boardUpdateData(no);
	   model.addAttribute("vo", vo);
	   // jsp.forward(request,response)
	   return "board/update";
   }
   
   @GetMapping("delete.do")
   public String board_delete(int no,Model model) {
	   // delete.do를 요청 → delete.jsp (no값을 포함)
	   model.addAttribute("no", no);
	   return "board/delete";
   }
}