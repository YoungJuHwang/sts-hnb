<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<LINK REL="stylesheet" type="text/css" href="${css}/board.css"/>	
<c:set var="PAGESIZE" value="5"/>
<c:set var="GROUPSIZE" value="3"/>
<c:choose>
	<c:when test="${count%PAGESIZE eq 0}">
		<c:set var="totPage" value="${count/PAGESIZE}"></c:set>
	</c:when>
	<c:otherwise>
		<c:set var="totPage" value="${count/PAGESIZE+1}"></c:set>
	</c:otherwise>
</c:choose>
<c:set var="startPage" value="${pageNo - ((pageNo-1)%GROUPSIZE) }"></c:set>
<c:choose>
	<c:when test="${startPage+PAGESIZE-1 le totPage }">
		<c:set var="lastPage" value="${startPage+GROUPSIZE-1}"></c:set>
	</c:when>
	<c:otherwise>
		<c:set var="lastPage" value="${totPage}"></c:set>
	</c:otherwise>
</c:choose>

<div id="boardList">

<TABLE>
	<TR BGCOLOR=#A0A0A0>
		<TD ALIGN=CENTER><FONT SIZE=4><B>게시판 ( 리스트 )</B></FONT></TD>
	</TR>
</TABLE>

<TABLE id="tab_boarderList">
	<tr>
		<td style="text-align: right">${count}</td>
	</tr>
	<TR ALIGN=CENTER>
		<TD WIDTH=10%><B>번호</B></TD>
		<TD WIDTH=20%><B>아이디</B></TD>
		<TD WIDTH=20%><B>회원명</B></TD>
		<TD WIDTH=30%><B>이메일</B></TD>
		<TD WIDTH=18%><B>가입일</B></TD>
	</TR>
	<c:forEach var="member" items="${memberList}" varStatus="status">	
	<TR>
		<TD WIDTH=10% ALIGN=CENTER>${status.index+1}</TD>
		<TD WIDTH=20% ALIGN=CENTER>${member.id}</TD>
		<TD WIDTH=20% ALIGN=CENTER><A HREF="BoardContent.jsp">${member.name}</A></TD>
		<TD WIDTH=30% ALIGN=LEFT>${member.email}</TD>
		<TD WIDTH=18% ALIGN=CENTER>${member.regdate}</TD>
	</TR>
	</c:forEach>
</TABLE>

<TABLE id="pagenation">

	<TR>
		<TD ALIGN=LEFT WIDTH=100>
			<IMG SRC="${images}/btn_new.gif" onClick="javascript:location.replace('BoardWrite.jsp')"; STYLE=CURSOR:HAND>
		</TD>
		<TD WIDTH=320 ALIGN=CENTER>
			<%-- <IMG SRC="${images}/btn_bf_block.gif">&nbsp; : 맨 앞으로 가란 버튼(<<)--%>
			    
			<c:if test="${startPage ne 1}">   <!-- 이전 : ${startPage - GROUPSIZE gt 0} -->
				<a href="${context}/event/boardList/1}"> <%-- 이전 : ${context}/event/boardList/${startPage-GROUPSIZE} --%>
					<IMG SRC="${images}/btn_bf_page.gif">&nbsp;
				</a>
			</c:if>
			<c:forEach begin="${startPage}" end="${lastPage}" step="1" varStatus="status">
				<c:choose>
					<c:when test="${status.index == pageNo }">
						<font style="color: red; font-size: 20px">${status.index}</font>
					</c:when>
					<c:otherwise>
						<a href="${context}/event/boardList/${status.index}">
							<font>${status.index}</font>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>	
			<c:if test="${startPage + GROUPSIZE le totPage}">
				<a href="${context}/event/boardList/${startPage+GROUPSIZE}">
					<IMG SRC="${images}/btn_nxt_page.gif">&nbsp;
				</a>
			</c:if>
			
			<%-- <IMG SRC="${images}/btn_nxt_block.gif"> --%>    	    		     
		</TD>
		<TD WIDTH=200 ALIGN=RIGHT>
			<FORM NAME="memberSearch" action="${context}/event/memberSearch/1">
				<SELECT NAME="column" SIZE=1>
					<OPTION VALUE="" SELECTED>선택</OPTION>
					<OPTION VALUE="id">ID</OPTION>
					<OPTION VALUE="name">이름</OPTION>
					<OPTION VALUE="gender">성별</OPTION>
				</SELECT> 
				<INPUT TYPE=TEXT NAME="keyword" SIZE=10 MAXLENGTH=20>
				<input type="submit" value="검 색" /> 
				<%-- <IMG SRC="${images}/btn_search.gif" ALIGN=absmiddle STYLE=CURSOR:HAND> --%>
			</FORM>
		</TD>    
	</TR>
</TABLE>
</div>
<!-- 
	전체 레코드 수 - ((현재 페이지 번호-1) * 한 페이지당 레코드 수 + 현재 게시물 출력 순서)
	count - ((nowPage - 1) * rowPerPage + status.index)
 -->
<script type="text/javascript">

</script>





