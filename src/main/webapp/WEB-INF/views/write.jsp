<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
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
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/main/main">거래</a>
				<li><a href="/main/member">고객</a>
				<li><a href="bbs.jsp">통계</a>
			</ul>


			<ul class="nav navbar-nav navbar-right">
				<li style="padding-top: 15px"><c:if test="${msg == 'success' }">
						<h8>${sessionScope.UserName}(${sessionScope.UserId })님 환영합니다.</h8>
					</c:if>
				<li class="dropdown"><a href="#" class="dropddown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul></li>
			</ul>
	</nav>
	<div class="container">
		<div class="row">
			<form method="post" action="/write/userAdd" />
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">회원정보추가</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="이름" name="name" maxlength="20" /></td>
						</tr>		
						<tr>
							<td><input type="text" class="form-control"
								placeholder="나이" name="age" maxlength="20" /></td>
						</tr>	
						
						<tr>
							<td><input type="date" class="form-control"
								name="date" /></td>
						</tr>	
						<tr>	
							<td><textarea class="form-control"
									placeholder=" 내용" name="content" maxlength="2500"
									style="height: 150px;" /></textarea></td>
						</tr>
					</tbody>

				</table>
				<input type="submit" class="btn btn-primary pull-right" value="등록">
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>