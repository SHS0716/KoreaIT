<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

	$(docuemnt).ready(function() {
		var a = $('#input1').val();
		console.log(a);
	});

</script>
</head>
<body>

<label><input type="text" id="input1" value="aa"></label>

</body>
</html>