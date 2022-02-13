<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
div.input-group {
	dispaly: inline;
	display: flex;
	width: 300px
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
				<li><a href="#" class="nav navbar-nav" data-toggle="dropdown">
						거래검색 <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="/main/main">년도별</a></li>
						<li><a href="#">월별</a></li>
						<li><a href="#">상세설정</a></li>
					</ul></li>
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
			<form method="post" action="/dell/dellWrite" />
			<div class="input-group">
				<input type="date" class="form-control" id="startDate" name="start" />
				<input type="date" class="form-control" id="endDate" name="end" />
				<input type="submit" class="btn btn-primary pull-right" />
			</div>
			</form>


			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">고객명</th>
						<th style="background-color: #eeeeee; text-align: center;">수업제목</th>
						<th style="background-color: #eeeeee; text-align: center;">거래일</th>
						<th style="background-color: #eeeeee; text-align: center;">거래횟수</th>
						<th style="background-color: #eeeeee; text-align: center;">금액</th>
						<th style="background-color: #eeeeee; text-align: center;">유입경로</th>
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
								<td>${Info.name}</td>
								<td>${Info.class_name}</td>
								<td>${Info.class_date}</td>
								<td>${Info.class_round}</td>
								<td><fmt:formatNumber value="${Info.cost}" /></td>
								<td>${Info.inflow}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">총금액</th>
						<th style="background-color: #eeeeee; text-align: center;">거래횟수</th>
						<th style="background-color: #eeeeee; text-align: center;">블로그</th>
						<th style="background-color: #eeeeee; text-align: center;">인스타</th>
						<th style="background-color: #eeeeee; text-align: center;">페이스북</th>
						<th style="background-color: #eeeeee; text-align: center;">지인추천</th>
						<th style="background-color: #eeeeee; text-align: center;">기타</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td><fmt:formatNumber value="${cost}" /></td>
						<td>${round}</td>
						<td>${blog}</td>
						<td>${Instar}</td>
						<td>${face}</td>
						<td>${fData}</td>
						<td>${otherD}</td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>