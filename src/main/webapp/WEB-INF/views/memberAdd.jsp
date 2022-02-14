<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<style>
  .input-group .form-control{
  	width: 200px;
  
  }
  
  span.input-group-btn {
  
  	left: -900px;
  	top:10px;
  }
  
  input.form-control {
  	top:10px;
  }
</style>
<title>회원관리프로그램</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="welcom.jsp">회원관리프로그램</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/main/main">거래</a>
				<li><a href="/main/member">고객등록</a>
				<li><a href="/main/memberlook">고객현황</a>
				<li><a href="bbs.jsp">통계</a>
			</ul>


			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropddown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul></li>
			</ul>

		</div>
	</nav>
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<form method="post"	action="/write/find">
							<div class="input-group">
								<input type="text" class="form-control" id="userName"name="body"
									placeholder="고객명을 입력해주세요."> <span
									class="input-group-btn">
									<button class="btn btn-secondary" type="submit" id="btn1">찾기</button>
								</span>
							</div>
						</form>
						<a href="/write/writing" class="btn btn-primary pull-right">고객등록</a>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">고객명</th>
						<th style="background-color: #eeeeee; text-align: center;">등록날짜</th>
						<th style="background-color: #eeeeee; text-align: center;">내용</th>
					</tr>
					<tr>

					</tr>
				</thead>
				<tbody>
					<c:if test="${empty list}">
						<p>값이 없습니다.</p>
					</c:if>

					<c:if test="${not empty list}">
						<c:forEach var="Info" items="${list}">
							<tr>
								<td>${Info.id}</td>
								<td><a href="/view/memberview?bbsID=${Info.id}">${Info.name}</a></td>
								<td>${Info.date}</td>
								<td>${Info.content}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<c:if test ="${a == null || a == 0}">
					<c:if test="${totalpage <= 3}">
						<c:forEach var = "pageNum1" begin = "1" end = "${totalpage}" >
			 				<a href = "/main/coutView?page=${pageNum1}&number=${0}" >[${pageNum1}]</a>
			       		</c:forEach>
		       		</c:if>
		       		<c:if test="${totalpage > 3}">
						<c:forEach var = "pageNum1" begin = "1" end = "3" >
			 				<a  href = "/main/view?viewpage=${pageNum1}&number=${0}" >[${pageNum1}]</a>
			       		</c:forEach>
			       		<a href = "/main/coutView?page=3">다음</a>
		       		</c:if>
	       		</c:if>
	       		<c:if test ="${a != null && a != 0}"> 
	       			<c:if test="${totalpage <= a+2}">
	       				<c:if test ="${a != 1}"> 
				       		<a href ="/main/maius?maius=${a-3}" >이전</a>
			       		</c:if>
		       			<c:forEach var = "pageNum1" begin = "${a}" end = "${totalpage}" >
				 			<a class="pages" href = "/main/view?viewpage=${pageNum1}&number=${a}" >[${pageNum1}]</a>
				       	</c:forEach>
			       	</c:if>
	       			<c:if test="${totalpage > a+2}">
	       				<c:if test ="${a != 1}"> 
				       		<a href = "/main/maius?maius=${a-3}" >이전</a>
				       	</c:if>
		       			<c:forEach var = "pageNum1" begin = "${a}" end = "${a+2}" >
				 			<a class="pages" href ="/main/view?viewpage=${pageNum1}&number=${a}" >[${pageNum1}]</a>
				       	</c:forEach>
				       	<a href = "/main/coutView?page=${a+2}">다음</a>
			       	</c:if>
				</c:if>
		</div>
	</div>
	  <script>
		
	</script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>