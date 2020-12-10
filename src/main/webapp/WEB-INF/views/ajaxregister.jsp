<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX 회원가입 테스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.css"/>
<link rel="stylesheet" href="resources/css/custom.css"/>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<div class="container">
	<form action="./UserRegister" method="post">
		<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="3">
						<h4>회원 등록 양식</h4>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 110px;">
						<h5>아이디</h5>
					</td>
					<td>
						<input id="userID" class="form-control" type="text" name="id" placeholder="아이디를 입력해주세요."/>
					</td>
					<td style="width: 110px;">
						<button class="btn btn-primary" type="button" onclick="registerCheckFunction()">중복체크</button>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>비밀번호</h5>
					</td>
					<td colspan="2">
						<input id="password" class="form-control" type="password" name="password" onkeyup="passwordCheckFunction()" 
							placeholder="비밀번호를 입력해주세요."/>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>비밀번호 확인</h5>
					</td>
					<td colspan="2">
						<input id="password_chk" class="form-control" type="password" name="password_chk" onkeyup="passwordCheckFunction()" 
							placeholder="비밀번호를 다시 한 번 입력해주세요."/>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>이름</h5>
					</td>
					<td colspan="2">
						<input id="name" class="form-control" type="text" name="name" placeholder="이름을 입력해 입력해주세요."/>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>나이</h5>
					</td>
					<td colspan="2">
						<input id="age" class="form-control" type="text" name="age" placeholder="나이를 입력해 입력해주세요."/>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>성별</h5>
					</td>
					<td colspan="2">
						
						<div class="form-group" style="text-align: center; margin: 0 auto">
							<!-- data-toggle 속성이 사용된 div 태그로 묶어주면 체크 상자 대신 버튼으로 표시된다. -->
							<div class="bth-group" data-toggle="buttons">
								<label class="btn btn-primary active">
									<!-- autocomplete="off" => 자동완성 기능 해제 -->
									<input type="radio" name="userGender" autocomplete="off" value="남자" checked="checked"/>남자
								</label>
								<label class="btn btn-primary">
									<input type="radio" name="userGender" autocomplete="off" value="여자"/>여자
								</label>
							</div>						
						</div>
						
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>이메일</h5>
					</td>
					<td colspan="2">
						<input id="userEmail" class="form-control" type="email" name="userEmail" placeholder="이메일을 입력해 입력해주세요."/>
					</td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: center;">
						<!-- 비밀번호 일치 검사 결과 메시지가 출력될 영역 -->
						<h5 id="passwordCheckMessage" style="color: red;"></h5>
						<h5 id="idCheckMessage" style="color: red;"></h5>
						<input class="btn btn-primary" type="submit" value="회원가입"/>
						<input class="btn btn-primary" type="reset" value="다시쓰기"/>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>관심분야</h5>
					</td>
					<td>
						<input type="checkbox" name="interests_list" value="사회"/>사회
						<input type="checkbox" name="interests_list" value="연예"/>연예
						<input type="checkbox" name="interests_list" value="스포츠"/>스포츠<br>
						<input type="checkbox" name="interests_list" value="IT"/>IT
						<input type="checkbox" name="interests_list" value="게임"/>게임
						<input type="checkbox" name="interests_list" value="쇼핑"/>쇼핑<br>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

</body>
</html>