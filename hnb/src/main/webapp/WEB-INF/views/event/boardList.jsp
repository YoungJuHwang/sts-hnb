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
			
			/* +'<c:forEach var="member" items="${memberList}" varStatus="status"><TR><TD WIDTH=10% ALIGN=CENTER>${status.index+1}</TD>'
			+'<TD WIDTH=20% ALIGN=CENTER>${member.id}</TD><TD WIDTH=20% ALIGN=CENTER><A HREF="BoardContent.jsp">${member.name}</A></TD>'
			+'<TD WIDTH=30% ALIGN=LEFT>${member.email}</TD><TD WIDTH=18% ALIGN=CENTER>${member.regdate}</TD></TR></c:forEach>'
			 */
			/* var pagination = '<TABLE id="pagination">'
				+'<TR>'
				+'<TD ALIGN=LEFT WIDTH=100>'
					+'<IMG SRC="${images}/btn_new.gif" onClick="javascript:location.replace('BoardWrite.jsp')"; STYLE=CURSOR:HAND>'
				+'</TD>'
				+'<TD WIDTH=320 ALIGN=CENTER>'
					+'<c:if test="${startPage ne 1}">'
						+'<a href="${context}/event/boardList/1}">'
							+'<IMG SRC="${images}/btn_bf_page.gif">&nbsp;'
						+'</a>'
					+'</c:if>'
					+'<c:forEach begin="${startPage}" end="${lastPage}" step="1" varStatus="status">'
						+'<c:choose>'
							+'<c:when test="${status.index == pageNo }">'
								+'<font style="color: red; font-size: 20px">${status.index}</font>'
							+'</c:when>'
							+'<c:otherwise>'
								+'<a href="${context}/event/boardList/${status.index}">'
									+'<font>${status.index}</font>'
								+'</a>'
							+'</c:otherwise>'
						+'</c:choose>'
					+'</c:forEach>'	
					+'<c:if test="${startPage + GROUPSIZE le totPage}">'
						+'<a href="${context}/event/boardList/${startPage+GROUPSIZE}">'
							+'<IMG SRC="${images}/btn_nxt_page.gif">&nbsp;'
						+'</a>'
					+'</c:if>'    		     
				+'</TD>'
				+'<TD WIDTH=200 ALIGN=RIGHT>'
					+'<FORM NAME="memberSearch" action="${context}/event/memberSearch/1">'
						+'<SELECT NAME="column" SIZE=1>'
							+'<OPTION VALUE="" SELECTED>선택</OPTION>'
							+'<OPTION VALUE="id">ID</OPTION>'
							+'<OPTION VALUE="name">이름</OPTION>'
							+'<OPTION VALUE="gender">성별</OPTION>'
						+'</SELECT>'
						+'<INPUT TYPE=TEXT NAME="keyword" SIZE=10 MAXLENGTH=20>'
						+'<input type="submit" value="검 색" />'
					+'</FORM>'
				+'</TD>'   
			+'</TR>';
			table += pagination; */
			$('.mainView').html(table);
			});
		}
		
	};
</script>




