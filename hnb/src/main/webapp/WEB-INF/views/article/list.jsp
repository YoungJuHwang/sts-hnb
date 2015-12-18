<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!-- 
	전체 레코드 수 - ((현재 페이지 번호-1) * 한 페이지당 레코드 수 + 현재 게시물 출력 순서)
	count - ((nowPage - 1) * rowPerPage + status.index)
 -->
<script type="text/javascript">
	$(function() {
		Article.list('142','1');
	});
	var Article = {
		list : function(themeNo,pageNo) {
			$.getJSON(context+'/article/list/'+themeNo+'/'+pageNo, function(data) {
				
				var table = '<div id="boardList"><TABLE><TR BGCOLOR=#A0A0A0><TD ALIGN=CENTER><FONT SIZE=4><B>자유게시판</B></FONT></TD></TR></TABLE>'
				+'<TABLE id="tab_boarderList">'
				+'<TR ALIGN=CENTER><TD WIDTH=8%><B>번호</B></TD>'
				+'<TD WIDTH=30%><B>제 목</B></TD>'
				+'<TD WIDTH=60%><B>내 용</B></TD></TR>';
				$.each(data, function(index,value) {
					table += '<TR><TD WIDTH=8% ALIGN=CENTER>'+(index+1)+'</TD>'
					+'<TD WIDTH=30% ALIGN=CENTER>'+this.usrSubject+'</TD>'
					+'<TD WIDTH=60% ALIGN=CENTER>'+this.usrContent+'</TD></TR>'
				});
				
				table +='</TABLE></div>';
				table +='<div style="width:300px;margin:auto"><h1><a href="'+context+'/article/write" id=dialog-model">글쓰기</a></h1></div>';
				$('.mainView').html(table);
					
			});
		},
		write : function() {
			alert('12/18 현재 팝업으로 할 거 구현안됬음.');
		}
		
	};
</script>




