<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width:650px;
}
h1{
    text-align: center;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Include</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../../main/main.do">Home</a></li>
      <li><a href="main/seoul/location/list.do">명소</a></li>
      <li><a href="main/seoul/nature/list.do">자연/관광</a></li>
      <li><a href="main/seoul/hotel/list.do">호텔</a></li>
      <%-- XML파싱(naver, 이미지) --%>
      <li><a href="/main/etc/new/list.do">뉴스</a></li>
      <%-- 영화 진흥원(VueJS) --%>      
      <li><a href="#">영화</a></li>
    </ul>
  </div>
  <div class="container-fluid">
  <c:if test="${sessionScope.id==null }">
    <div class="text-right">
      <form method="post" action="../main/login.do">
       <span style="color: white;">ID :</span><input type="text" name="id" size="15" class="input-sm">
        &nbsp;
        <span style="color: white;">Password :</span><input type="password" name="pwd" size="15" class="input-sm">
        <input type="submit" value="로그인" class="btn btn-sm btn-success">
      </form>
    </div>
  </c:if>
  <c:if test="${sessionScope.id!=null }">
    <div class="text-right">
      <form method="post" action="../main/logout.do">
        <span style="color: white;">${seesionScope.name }님이 로그인 되었습니다</span> &nbsp;
        <input type="submit" value="로그아웃" class="btn btn-sm btn-success">
      </form>
    </div>
  </c:if>  
  </div>
</nav>
</body>
</html>