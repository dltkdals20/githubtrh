<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device" ,initial-scale="1">
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="/resource/css/main.css">
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
				
			</ul>


			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropddown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/paths/join">회원가입</a></li>
						<li><a href="/mapping/login">로그인</a></li>
					</ul></li>
			</ul>

		</div>
	</nav>
 <section>
      <table class="tb1">
        <caption><<최신사용자>></caption>
        <thead>
          <tr>
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th>4</th>
          </tr>
        </thead>
        <tbody>
           <tr>
            <th>1교시</th>
            <td>영어</td>
            <td>국어</td>
            <td>사회</td>
          </tr>
           <tr>
            <th>1교시</th>
            <td>영어</td>
            <td>국어</td>
            <td>사회</td>
          </tr>
        </tbody>
      </table>
       <table class="tb2">
        <caption><<최신사용자>></caption>
        <thead>
          <tr>
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th>4</th>
          </tr>
        </thead>
        <tbody>
           <tr>
            <th>1교시</th>
            <td>영어</td>
            <td>국어</td>
            <td>사회</td>
          </tr>
           <tr>
            <th>1교시</th>
            <td>영어</td>
            <td>국어</td>
            <td>사회</td>
          </tr>
        </tbody>
      </table>
    </section>


	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>