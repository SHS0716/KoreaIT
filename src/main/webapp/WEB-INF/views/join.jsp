<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>

<form action="insert" method="post">
	<table width="700" align="center" border="0" cellpadding="5" cellspacing="0">
		<tr><th colspan="2">회원 가입</th></tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" placeholder="ID"/></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="password" placeholder="PASSWORD"/></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="password_chk" placeholder="Confirm PASSWORD"/></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" placeholder="NAME"/></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" value="true" checked="checked">남자
				<input type="radio" name="gender" value="false">여자<br>
			</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="text" name="dateofbirthday" placeholder="ex) 19930716"/></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" name="email" placeholder="E-mail"/></td>
		</tr>
		<tr>
			<th>휴대전화</th>
			<td><input type="text" name="phone" placeholder="'-' 없이 번호만 입력해주세요."/></td>
		</tr>
		<tr>
			<th>관심분야</th>
			<td>
				<input type="checkbox" name="interests_list" value="사회"/>사회
				<input type="checkbox" name="interests_list" value="연예"/>연예
				<input type="checkbox" name="interests_list" value="스포츠"/>스포츠<br>
				<input type="checkbox" name="interests_list" value="IT"/>IT
				<input type="checkbox" name="interests_list" value="게임"/>게임
				<input type="checkbox" name="interests_list" value="쇼핑"/>쇼핑<br>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="가입하기"/>
				<input type="reset" value="다시쓰기"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>