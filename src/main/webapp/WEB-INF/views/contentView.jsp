<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>

<form action="update" method="post">
<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr><th colspan="5">게시글 보기11</th></tr>
		<tr>
		<th width="80">글번호</th>
		<th width="320">이름</th>
		<th width="120">작성일</th>
		<th width="80">조회수</th>
		<th width="80">카테고리</th>
	</tr>
	<tr>
		<td align="center">${vo.bidx}</td>
		<td align="center">
			<c:set var="name" value="${fn:replace(fn:trim(vo.name), '<', '&lt;')}"/>
			<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
			${name}
		</td>
		<td align="center">
			<jsp:useBean id="date" class="java.util.Date"/>
			<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month && date.date == vo.writeDate.date}">
				<fmt:formatDate value="${vo.writeDate}" pattern="a h:mm"/>
			</c:if>
			<c:if test="${date.year != vo.writeDate.year || date.month != vo.writeDate.month || date.date != vo.writeDate.date}">
				<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
			</c:if>
		</td>
		<td align="center">${vo.hit}</td>
		<td align="center">${vo.category}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="4">
			<input type="text" name="subject" value="${vo.subject}" size="60"/> 
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td colspan="4">
			<textarea rows="10" cols="50" name="content" style="resize: none;">${vo.content}</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="5" align="center">
			<input type="submit" value="수정하기"/>
			<input type="button" value="삭제하기" onclick="location.href='delete?idx=${vo.bidx}&currentPage=${currentPage}'"/>
			<input type="button" value="답변달기" onclick="location.href='reply?idx=${vo.bidx}&currentPage=${currentPage}'"/>
			<input type="button" value="돌아가기" onclick="location.href='list?currentPage=${currentPage}'"/>
			<input type="hidden" name="idx" value="${vo.bidx}"/>
			<input type="hidden" name="currentPage" value="${currentPage}"/>
			
		</td>
	</tr>
</table>

</form>
</body>
</html>