<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
  <c:when test="${result=='NOID' }">
  	alert("아이디가 존재하지 않습니다");
  	history.back();
  </c:when>  
  <c:when test="${result=='NOPWD' }">
   	alert("비민번호가 틀립니다");
  	history.back(); 
  </c:when>
  <c:otherwise>
    <c:redirect url="mian.do"/>
  </c:otherwise>  
</c:choose>
