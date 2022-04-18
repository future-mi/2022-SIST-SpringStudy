package com.sist.dao;
import java.util.*;
import java.sql.*;
/*
 * JDBC → 자바로 데이터베이스 연결 프로그램 → 라이브러리(ORM = mybatis,hibernate,jpa)
 * 
 */
public class StudentDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	
	// 드라이버등록
	public StudentDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {}
	}
	// 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"root","happy");
		} catch (Exception ex) {}
	}
	// 해제
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception ex) {}
	}
    // ------------------------------------------------------ MyBatis의 SqlSessionFactroy
	// 전체목록읽기
	public List<StudentVO> stdListData(){
		List<StudentVO> list = new ArrayList<StudentVO>();
		try {
			getConnection();
			String sql="SELECT hakbun,name,kor,eng,math,date_format(regdate,'%y-%m-%d') "
					+"FROM student";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentVO vo= new StudentVO();
				vo.setHakbun(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setKor(rs.getInt(3));
				vo.setEng(rs.getInt(4));
				vo.setMath(rs.getInt(5));
				vo.setDbday(rs.getString(6));
				list.add(vo);
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}
}
