<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Public Coding</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<link type="text/css" rel="stylesheet" href="assets/css/test.css">
<link type="text/css" rel="stylesheet" href="assets/css/uu.css">
<link type="text/css" rel="stylesheet" href="assets/css/main.css">
<!-- <link type="text/css" rel="stylesheet" href="assets/css/main2.css"> -->
</head>
<body class="landing">


	<div id="page-wrapper">

		<header id="header">
			<h1 >
				<a href="main.do">
						PUBLIC CODING
				</a>
			</h1>
			<!-- 메뉴바 -->
			<nav id="nav">
			
				<ul>
					<li>
					<input onclick="popup_signin()" type="button" value="로그인">
					</li>
					
					<li id="pop1"><input onclick="popup_signup()" type="button"
						class="button special" value="회원가입"></li>
				</ul>
			</nav>
		
		
		
		
		</header>

		<!-- 메인페이지(페이지1) -->
		
	<!-- 	<section id="banner">
			<div class="content">				
				<span class="image">
					<img src="resources/images/main1.jpg" alt="" />
				</span>
			</div>
		
			<div class="content">
				<span class="image">
					<img src="resources/images/main2.jpg" alt="" /> 
				</span>
			</div>
				
		</section> -->
		



		<!-- src="//player.vimeo.com/external/118607115.hd.mp4?s=53f507d4e1144f6af7b8188e680c8dcb" -->
		<section class="hero viewport-height" id="hero">
			<div id="video" class="full-height">
				<div class="video-wrapper">
					<video autoplay width="100%" height="auto" preload="auto" loop>
						<source src="resources/images/main.mp4" type="video/mp4">
					</video>
				</div>
			</div>
			<div class="options" id="department-options">
				<div class="option">
					<a href="videolist.do" class="wrap">
						<h2>
							FREE <br>& Programming Study
						</h2>
						<h3>무료로 프로그래밍을 공부하세요.</h3>
							<div class="btn btn-default">프로그래밍 언어</div><br>
							
							<div class="btn btn-default" href="//www.naver.com">데이터베이스</div>
							
							<br>
							<div class="btn btn-default">WEB</div>
						<div class="details">
							
						</div>
						
					</a>
				</div>
				<div class="option">
					<a href="boardmain.do" class="wrap">
						<h2>
							Share <br>& your Knowledge
						</h2>
								<h3>프로그래밍질문질문모르는거여기다있음</h3>
							<div class="btn btn-default">Q&A 게시판</div><br>
							<div class="btn btn-default">자유게시판</div><br>
							<div class="btn btn-default">소스 공유</div>
						<div class="details">
					
						</div>
					</a>
				</div>
			</div>	 

		<!-- Footer -->
		<footer id="footer">
			<ul class="icons">
				<li><a href="#" class="icon alt fa-twitter"><span
						class="label">Twitter</span></a></li>
				<li><a href="#" class="icon alt fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon alt fa-linkedin"><span
						class="label">LinkedIn</span></a></li>
				<li><a href="#" class="icon alt fa-instagram"><span
						class="label">Instagram</span></a></li>
				<li><a href="#" class="icon alt fa-github"><span
						class="label">GitHub</span></a></li>
				<li><a href="#" class="icon alt fa-envelope"><span
						class="label">Email</span></a></li>
			</ul>
			<ul class="copyright">
				<li>&copy;Copyright by SIST-C2.</li>

	

			</ul>
			
			
		</footer>

	</div>

	<!-- Scripts -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/modal.js"></script>
	
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.onvisible.min.js"></script>
	<script src="assets/js/main2.js"></script>
	
	<!-- 회원가입/로그인 팝업창 띄우기 -->	
	<script src="assets/js/popup.js"></script>
	<!-- 메인페이지에서 동영상/이미지 겹치는 스크립트 -->
	<script type="text/javascript"	src="//cdn.jsdelivr.net/g/modernizr@2.7,respond@1.4,bootstrap@3.1,fittext@1.2"></script>

	

</body>
</html>