<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<script type="text/javascript"
	src="${path}/resource/ckeditor/ckeditor.js"></script>
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
			<form:form modelAttribute= "list" method="post" action="/update/infoUpdate" >
			<div class="form-group">
				<select class="form-control" name="className" path="className">
					<option value="비지니스">비지니스수업</option>
					<option value="셀프코칭">셀프코칭수업</option>
					<option value="코덕코">코덕코수업</option>
					<option value="기타">기타수업</option>
				</select>
			</div>
			<div class="form-group">
				<form:input type="date" class="form-control" placeholder=""
					id="classDate" name="classDate" path="classDate" maxlength="20" />
			</div>
			<div class="form-group">
				<form:input type="number" class="form-control" placeholder="수업회차"
					id="classRound" name="classRound" path="classRound" maxlength="20" />
			</div>
			<div class="form-group">
				<form:input type="number" class="form-control" placeholder="수업금액입력"
					id="cost" name="cost" path="cost" maxlength="20" />
			</div>
			<div class="form-group">
				<select class="form-control" name="inflow" path="inflow">
					<option value="블로그">블로그</option>
					<option value="인스타그램">인스타</option>
					<option value="페이스북">페이스북</option>
					<option value="지인추천">지인추천</option>
					<option value="기타">기타</option>
				</select>
			</div>
			<div class="form-group">
				<form:textarea id="editor4" name="classContent" path="classContent" /></textarea>
			</div>

			<input type="submit" class="btn btn-primary pull-right" value="등록">
			</form:form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script>
		CKEDITOR.replace('editor4', {
			filebrowserUploadUrl : '/mine/imageUpload.do'
		});
	</script>
</body>
</html>