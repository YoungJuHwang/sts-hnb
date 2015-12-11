<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>404에러</title>
</head>
<body>
	<div>
		<img src="${images}/404.jpg" alt="error-404" />
	</div>
</body>
</html>

<!-- 
	HTTP 프로토콜에 정의된 에러번호
	200 : 정상, success
	307 : 리다이렉트
	300 : 문법에러
	401 : 잡근불가 
	404 : URL에 따른 페이지가 존재x
	405 : 요청된 메소드는 허용불가(get/past)ㅏㅂ
	500 : JSP 문서내에서 오류발성
	503 : 서버부하

 -->