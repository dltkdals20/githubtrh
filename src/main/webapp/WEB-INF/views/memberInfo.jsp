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
<style>
.inner {
	width: 1100px;
	margin: 0 auto;
	height: 800px;
	background-color: #e5e5e5;
	position: relative;
	box-sizing: border-box;
	border-radius: 20px;
}

.tb1 {
	position: absolute;
	margin-left: 30px;
	margin-right: 30px;
}

.tb1 caption {
	text-align: center;
}

.tb1 thead th {
	width: 1100px;
}

.tb1 th, .tb1 td {
	padding: 10px 0;
	border: 1px solid #999;
	text-align: center;
}

.tb1 td {
	text-align: center;
	padding: 17px 0;
}

.tb1 .name {
	width: 200px;
	height: 5px;
}

}
.tb1 .age {
	width: 200px;
}

.tb1 th {
	background-color: red;
}

.inner .memberInfo {
	position: absolute;
	margin-left: 30px;
	margin-right: 30px;
	top: 300px;
}

.tb2 {
	
}

.tb2 caption {
	text-align: center;
	display: block;
}

.tb2 th {
	width: 1000px;
	border: 1px solid #999;
	text-align: center;
	padding: 17px 0;
}

.tb2 td {
	padding: 10px 0;
	border: 1px solid #999;
	text-align: center;
	padding: 20px 0;
}

.tb2 .className {
	width: 500px;
}

.tb2 .classDate {
	width: 500px;
}

.tb2 .classRound {
	width: 200px;
}

.tb2 .classCost {
	width: 400px;
}

.tb2 .classInflow{
	width: 300px;
}
.tb2 .classContetn {
	
}
a.btn.btn-primary.pull-right.a {
	margin-top: 230px;
	margin-right: 30px;
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
	<section>
		<div class="inner">
			<table class="tb1">
				<caption>
					<
					<최신사용자>> 
				</caption>
				<thead>
					<tr>
						<th colspan="4">고객관리 세부사항</th>


					</tr>
				</thead>
				<tbody>

					<tr>
						<td class="name">이름</td>
						<td>${list.name}</td>
						<td class="age">나이</td>
						<td>${list.age}</td>
					</tr>

					<tr>
						<td>구매횟수</td>
						<td>${round}번</td>
						<td>총금액</td>
						<td>${cost}원</td>
					</tr>

					<tr>
						<th colspan="2">구매날짜-현재</th>
						<th colspan="2">${day}</th>
					</tr>
					<a href="/view/delete" class="btn btn-primary pull-right a">전체삭제</a>
				</tbody>
			</table>
			<div class="memberInfo">
				<table class="tb2">
					<div class="title">고객세부사항</div>
					<thead>
						<tr>
							<th class="className">수업이름</th>
							<th class="classDate">수업날짜</th>
							<th class="classRound">수업횟수</th>
							<th class="classCost">금액</th>
							<th class="classInflow">유입경로</th>
							<th class="classCentent">내용</th>


						</tr>
					</thead>
					<tbody>
						<tr>
						
							<c:if test="${not empty total}">
								<c:forEach var="Info" items="${total}">
									<tr>
										<td><a href="/update/updating?bbsID=${Info.id}">${Info.className}</a></td>
										<td>${Info.classDate}</td>
										<td>${Info.classRound}</td>
										<td><fmt:formatNumber value="${Info.cost}" /></td>
										<td>${Info.inflow}</td>
										<td>${Info.classContent}</td>
									</tr>
								</c:forEach>
							</c:if>
						</tr>
					</tbody>
				</table>
				<a href="/write/dellWrite" class="btn btn-primary pull-right">거래등록</a>
			</div>
		</div>
	</section>



	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
	<script>
	document.getElementById('#cost').innerText.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	</script>
</body>
</html>