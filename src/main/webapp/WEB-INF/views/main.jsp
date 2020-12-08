<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	.main_title{
		text-align: center;
	}
	.main_list {
	    width: 700px;
	    margin: 0 auto;
	}
	.list_start {
	    text-align: center;
	}
	.list_detail {
	    display: inline-block;
	    width: 220px;
	    height: 260px;
		border: 1px solid;
	    margin-bottom: 5px;
	}
	.paging_start{
		text-align: center;
	}
</style>
</head>
<body>

<!-- 리스트 불러오기  -->
	<div class="main_list">
		<!-- 상단 제목 -->
		<div class="main_title">
			<p>네비게이션 영역</p>
		</div>
		<!-- 리스트 -->
		<div class="list_start">
			<div class="list_detail" onclick="location.href='newestBoard'"><p>최신글 게시판</p></div>
			<div class="list_detail"><p>인기글 게시판</p></div>
			<div class="list_detail"><p>자유 게시판</p></div>
			<div class="list_detail"><p>사회</p></div>
			<div class="list_detail"><p>연예</p></div>
			<div class="list_detail"><p>스포츠</p></div>
			<div class="list_detail"><p>IT</p></div>
			<div class="list_detail"><p>게임</p></div>
			<div class="list_detail"><p>쇼핑</p></div>
		</div>
	</div>
</body>
</html>