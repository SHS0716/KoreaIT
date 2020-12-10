<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	a {
		color: black;
		text-decoration: none;
	}
	a:hover {
		color: red;
		text-decoration: none;
	}

</style>

</head>
<body>

<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr><th colspan="5">사회 게시판</th></tr>
	<tr>
		<td colspan="5" align="right">
			${boardList.totalCount}(${boardList.currentPage} / ${boardList.totalPage})Page
		</td>
	</tr>
	<tr>
		<th width="80">글번호</th>
		<th width="620">제목</th>
		<th width="100">이름</th>
		<th width="120">작성일</th>
		<th width="80">조회수</th>
	</tr>
	
	<jsp:useBean id="date" class="java.util.Date"/>
	<c:set var="list" value="${boardList.list}"/>
	
	<c:if test="${list.size() == 0}">
	<tr>
		<td colspan="5">
			<marquee>테이블에 저장된 글이 없습니다.</marquee>
		</td>
	</tr>
	</c:if>
	
	<c:if test="${list.size() != 0}">	
	<c:forEach var="vo" items="${list}" varStatus="status">
	<tr>
		<td align="center">
			${boardList.totalCount - ((boardList.currentPage - 1) * boardList.pageSize + status.index)}		<!-- jstl을 이용한 페이지 글 번호 -->
			<input type="hidden" name="bidx" value="${vo.bidx}"/>
		</td>
		<td>
			<c:set var="subject" value="${fn:replace(fn:trim(vo.subject), '<', '&lt;')}"/>
			<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"/>
			
			<a href="increment?bidx=${vo.bidx}&currentPage=${boardList.currentPage}">${subject}</a>
			
			<!-- 조회수가 10번을 넘어가면 hot을 표시한다. -->
			<c:if test="${vo.hit > 10 }">
				<img src="images/hot.gif"/>
			</c:if>
		</td>
		
		<td align="center">
			<c:set var="name" value="${fn:replace(fn:trim(vo.name), '<', '&lt;')}"/>
			<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
			${name}
		</td>
		
		<td align="center">
			<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month && date.date == vo.writeDate.date}">
				<fmt:formatDate value="${vo.writeDate}" pattern="a h:mm"/>
			</c:if>
			<c:if test="${date.year != vo.writeDate.year || date.month != vo.writeDate.month || date.date != vo.writeDate.date}">
				<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
			</c:if>
		</td>
		<td align="center">${vo.hit}</td>
	</tr>
	</c:forEach>
	</c:if>
	
	<!-- 페이지 이동 버튼 -->
	<tr>
		<td colspan="5" align="center">
		
			<c:if test="${boardList.currentPage > 1}">
				<input class="button" type="button" value="맨앞" onclick="location.href='?currentPage=1'" title="첫 페이지 목록으로 이동하기"/>
			</c:if>
			<c:if test="${boardList.currentPage <= 1}">
				<input class="button" type="button" value="맨앞" disabled="disabled" title="이미 첫 번째 목록입니다."/>
			</c:if>
			
			<c:if test="${boardList.startPage > 1}">
				<input class="button" type="button" value="이전" onclick="location.href='?currentPage=${boardList.startPage - 1}'" 
					title="이전 페이지 목록으로 이동하기"/>
			</c:if>
			<c:if test="${boardList.startPage <= 1}">
				<input class="button" type="button" value="이전" disabled="disabled" title="이미 첫 번째 페이지 목록입니다."/>
			</c:if>
			
			<c:forEach var="i" begin="${boardList.startPage}" end="${boardList.endPage}" step="1">
				<c:if test="${boardList.currentPage == i}">
					<input class="button button1" type="button" value="${i}" disabled="disabled"/>
				</c:if>
				<c:if test="${boardList.currentPage != i}">
					<input class="button button2" type="button" value="${i}" onclick="location.href='?currentPage=${i}'"
						title="${i}페이지로 이동합니다."/>
				</c:if>
			</c:forEach>
			
			<c:if test="${boardList.endPage < mvcboardList.totalPage}">
				<input class="button" type="button" value="다음" onclick="location.href='?currentPage=${boardList.endPage + 1}'" 
					title="다음 페이지 목록으로 이동하기"/>
			</c:if>
			<c:if test="${boardList.endPage >= boardList.totalPage}">
				<input class="button" type="button" value="다음" disabled="disabled" title="이미 마지막 페이지 목록입니다."/>
			</c:if>
			
			<!-- 마지막으로 -->
 			<c:if test="${boardList.currentPage < boardList.totalPage}">
				<input class="button" type="button" value="맨뒤" onclick="location.href='?currentPage=${boardList.totalPage}'" 
					title="마지막 페이지 목록으로 이동하기"/>
			</c:if>
			<c:if test="${boardList.currentPage >= boardList.totalPage}">
				<input class="button" type="button" value="맨뒤" disabled="disabled" title="이미 마지막 목록입니다."/>
			</c:if>
			
		</td>
	</tr>
	
	<tr>
		<td colspan="5" align="right">
			<input type="button" value="글쓰기" onclick="location.href='write'"/>
		</td>
	</tr>
</table>
</head>
<body>

</body>
</html>