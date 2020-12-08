<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코리아IT 커뮤니티</title>
<style type="text/css">
	
	div#login{
		text-align: center;
	}
	
	div#in{
		display: inline-block;
	}
</style>
</head>
<body>

<div id="login">
	<h2>코리아IT 커뮤니티</h2>
	<form action="loginOK" method="post">
		ID : <input type="text" name="id" placeholder="ID"/><br>
		PW : <input type="text" name="id" placeholder="PASSWORD"/><br>
		<div id="in">
			<table>
				<tr>
					<td>
						<input type="submit" value="로그인"/>
						<input type="button" value="회원가입" onclick="location.href='join'"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="ID/PW 찾기"/>
						<input type="button" value="비회원"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
</body>
</html>