<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
			var table = '<div id="boardList"><TABLE><TR BGCOLOR=#A0A0A0><TD ALIGN=CENTER><FONT SIZE=4><B>자유게시판</B></FONT></TD></TR></TABLE>'
			+'<TABLE id="tab_boarderList"><TR ALIGN=CENTER><TD WIDTH=10%><B>번호</B></TD><TD WIDTH=40%><B>제목</B></TD>'
			+'<TD WIDTH=20%><B>작성자</B></TD><TD WIDTH=20%><B>작성일</B></TD><TD WIDTH=8%><B>참조</B></TD></TR>'
			+'</TABLE></div>';
			
			$('.mainView').html(table);
			});
		}
		
	};
</script>




