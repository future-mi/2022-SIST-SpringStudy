<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}
.row {
	margin: 0px auto;
	width: 600px;
}
h1 {
	text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <h1>내용보기</h1>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center warning" width=20%>번호</th>
          <td class="text-center" width=30%>${vo.no }</td>
          <th class="text-center warning" width=20%>작성일</th>
          <td class="text-center" width=30%>
           <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
          </td>
        </tr>
        <tr>
          <th class="text-center warning" width=20%>이름</th>
          <td class="text-center" width=30%>${vo.name }</td>
          <th class="text-center warning" width=20%>조회수</th>
          <td class="text-center" width=30%>${vo.hit }</td>
        </tr>
        <tr>
          <th class="text-center warning" width=20%>제목</th>
          <td colspan="3">${vo.subject }</td>
        </tr>
        <tr>
          <td class="text-left" valign="top" height="200" colspan="4">
           <pre style="white-space: pre-wrap;border:none;background-color: white">${vo.content }</pre>
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
           <a href="update.do?no=${vo.no }" class="btn btn-xs btn-danger">수정</a>
           <a href="delete.do?no=${vo.no }" class="btn btn-xs btn-primary">삭제</a>
           <a href="list.do" class="btn btn-xs btn-success">목록</a>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>