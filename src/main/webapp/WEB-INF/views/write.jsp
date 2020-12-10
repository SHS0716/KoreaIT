<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<script type="text/javascript">
	function seleted() {
		var category = document.getElementsByName('category')[0]
		var ref = document.getElementById("selected_ref");
		switch (category.options[category.selectedIndex].value) {
		case "사회": ref.value = 1;
			break;
		case "연예": ref.value = 2;
			break;
		case "스포츠": ref.value = 3;
			break;
		case "IT": ref.value = 4;
			break;
		case "게임": ref.value = 5;
			break;
		case "쇼핑": ref.value = 6;
			break;
		case "자유": ref.value = 7;
			break;
		}
		console.log(ref.value);
	}

</script>
</head>
<body>

<form action="writeOK" method="post">
	<table width="500" align="center" border="1" cellpadding="5" cellspacing="0">
	
		<tr><th colspan="2">답변형 게시판 입력하기</th></tr>
		<tr>
			<td>카테고리</td>
			<td><select name="category" onchange="seleted()">
					<option>사회</option>
					<option>연예</option>
					<option>스포츠</option>
					<option>IT</option>
					<option>게임</option>
					<option>쇼핑</option>
					<option>자유</option>
				</select>
				<input type="hidden" id="selected_ref" name="ref" value="1">
			</td>
		</tr>
		<tr>
			<td width="100">이름</td>
			<td width="400"><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="10" cols="50" name="content" style="resize: none;"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="저장하기"/>
				<input type="reset" value="다시쓰기"/>
				<input type="button" value="돌아가기" onclick="history.back()"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>