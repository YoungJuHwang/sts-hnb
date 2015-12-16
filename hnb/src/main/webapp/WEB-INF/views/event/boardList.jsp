<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<LINK REL="stylesheet" type="text/css" href="${css}/board.css"/>	


<!-- 
	전체 레코드 수 - ((현재 페이지 번호-1) * 한 페이지당 레코드 수 + 현재 게시물 출력 순서)
	count - ((nowPage - 1) * rowPerPage + status.index)
 -->
<script type="text/javascript">
	$(function() {
		list.boardList();
	});
	var list = {
		boardList : function() {
			$.getJSON(context+'/event/boardList/1', function(data) {
			var table = '<div id="boardList"><TABLE><TR BGCOLOR=#A0A0A0><TD ALIGN=CENTER><FONT SIZE=4><B>게시판(리스트)</B></FONT></TD></TR></TABLE>'
			+'<TABLE id="tab_boarderList"><tr><td style="text-align: right">${count}</td></tr><TR ALIGN=CENTER><TD WIDTH=10%><B>번호</B></TD><TD WIDTH=20%><B>아이디</B></TD>'
			+'<TD WIDTH=20%><B>회원명</B></TD><TD WIDTH=30%><B>이메일</B></TD><TD WIDTH=18%><B>가입일</B></TD></TR>'
			/* +'<c:forEach var="member" items="${memberList}" varStatus="status"><TR><TD WIDTH=10% ALIGN=CENTER>${status.index+1}</TD>'
			+'<TD WIDTH=20% ALIGN=CENTER>${member.id}</TD><TD WIDTH=20% ALIGN=CENTER><A HREF="BoardContent.jsp">${member.name}</A></TD>'
			+'<TD WIDTH=30% ALIGN=LEFT>${member.email}</TD><TD WIDTH=18% ALIGN=CENTER>${member.regdate}</TD></TR></c:forEach>'
			 */+'</TABLE></div>';
			$('.mainView').empty();
			$('.mainView').html(table);
			});
		}
	};
</script>




