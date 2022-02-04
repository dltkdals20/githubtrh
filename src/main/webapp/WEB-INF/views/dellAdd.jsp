<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form"%>	
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
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp" id="del">거래</a>
				<li><a href="bbs.jsp">고객</a>
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
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						
						<th style="background-color: #eeeeee; text-align: center;">거래일</th>
						<th style="background-color: #eeeeee; text-align: center;">고객명</th>
						<th style="background-color: #eeeeee; text-align: center;">거래내역</th>
						<th style="background-color: #eeeeee; text-align: center;">금액</th>
						<th style="background-color: #eeeeee; text-align: center;">수량</th>
						<th style="background-color: #eeeeee; text-align: center;">구매장소</th>
						<th style="background-color: #eeeeee; text-align: center;">거래메모</th>
						<th style="background-color: #eeeeee; text-align: center;">최초 유입경로</th>
						<th style="background-color: #eeeeee; text-align: center;">총거래 횟수</th>
					</tr>
					<tr>
					
					</tr>
				</thead>
				<tbody>
			   								
				</tr>	
				</tbody>
			</table>
						
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>