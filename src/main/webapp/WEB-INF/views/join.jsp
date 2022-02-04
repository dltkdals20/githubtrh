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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
.id_div::after{    
	display: block;
    clear: both;
    content: '';
    }
.id_input{
	width: calc(100% - 93px);
    float: left;
	} 
.id_button{
	width: 84px;
    float: right;
}


</style>
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
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbtron" style="padding-top: 20px;">
				<form:form  modelAttribute ="joinInfo" method="post" action="/paths/join">
					<h3 style="text-align: center;">회원가입화면</h3>
					<div class="form-group id_div">
						<div class="col-auto id_input">
							<form:input type="text" class="form-control" placeholder="아이디"
								id="user" name="userID" path="userId" maxlength="20" />
							<form:errors path="userId" />
						</div>
					<div class="col-auto id_button">
							<button class="btn btn-secondary" id="duplicate_check"
								type="button" >중복체크</button>
							
					</div>
					<div class="form-group">
						<form:input type="password" class="form-control"
							id= "pass" placeholder="비밀번호" name="userPassword" path="password"
							maxlength="20" />
						<form:errors path="password" />
					</div>
					<div class="form-group">
						<form:input type="text" class="form-control" placeholder="이름"
							name="userName" path="name" maxlength="20"/><form:errors path ="name"/>
					</div>
						<div class="form-group">
						<form:input type="text" id="phone" class="form-control" placeholder="핸드폰 번호"
							name="phone" path="phone" maxlength="20"/><form:errors path ="phone"/>
					</div>																
					<input type="submit" class="btn btn-primary form-control"
						value="회원가입">
				</form:form>
			</div>
		</div>
	
	</div>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>