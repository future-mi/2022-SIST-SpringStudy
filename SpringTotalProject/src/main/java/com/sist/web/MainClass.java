package com.sist.web;
import java.util.*;
import com.sist.dao.*;

public class MainClass {
	public static void main(String[] args) {
		StudentDAO dao= new StudentDAO();
		List<StudentVO> list=dao.stdListData();
		for(StudentVO vo:list) {
			System.out.println(vo.getHakbun()+" "
							+vo.getName()+" "
							+vo.getKor()+" "
							+vo.getEng()+" "
							+vo.getMath()+" "
							+vo.getDbday());
		}
	}
}
