<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ssl.dto.BoardDTO" %>
<%@ page import = "ssl.service.BoardService" %>
<%@ page import = "java.util.*" %>

<% session.setAttribute("src", "board");
String[] tags = (String[]) request.getAttribute("tags");
ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
BoardService service = new BoardService();
list = service.getBoardList(tags);
int pageno = 1;
int startSS_no = (pageno * 10) - 10 + 1;
// 페이지 번호 * 10 (=페이지의 마지막 글 번호) - 10 (페이지에 표시되는 글 갯수) + 1 (보정)
if(request.getParameter("pageno") != null)
{
	pageno = Integer.parseInt(request.getParameter("pageno"));
}
int count = 0;

%>

<!-- Page Content -->


<div class = "container top-margin-ss">
<h3>게시판
<small>필터링하면 필터링 한 대로 출력하는 게시판</small>
</h3>
	<table class="table table-hover">
		<thead class="tableheader-rounder">
			<tr>
				<th width="50%" align="center">글 제목</th>
				<th>작자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i=startSS_no-1; i<list.size(); i++) { %>
			<tr>
				<td><a href = "./FrontController?src=view&ss_no=<%=list.get(i).getSs_no() %>&pageno=<%=pageno %>">
				<%=list.get(i).getTitle() %>
				</a></td>
				<td><%=list.get(i).getUser_no() %></td>
				<td><%=list.get(i).getWriter_day() %></td>
				<td><%=list.get(i).getHit() %></td>
				<td><%=list.get(i).getRecommend() %></td>
			</tr>
			<% count++;
			if (count%10 == 0) break;
			} %>
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="4">
				<!-- 페이징 -->
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="./FrontController?src=board&pageno=0" style = "color:grey;">
					<span class = "glyphicon glyphicon-home" aria-hidden="true"></span>
					</a></li>
				<% if((pageno-1) > 0) {%>
					<li class="page-item"><a class="page-link" href="./FrontController?src=board&pageno=<%=(pageno-1)%>" style = "color:grey;">
					<span class = "glyphicon glyphicon-menu-left" aria-hidden="true"></span>
					</a></li>
				<% } %>
				<% 	count = 0;
					int j = 0; // y = 이게 몇 페이지인가
					int pagingSize = list.size()/10;
					if(list.size()%10 != 0) pagingSize++;
					for(j=pageno; j<=pagingSize; j++) { %>
					<!-- 게시판 페이지 목록 생성 -->
					<li class="page-item"><a class="page-link" href="./FrontController?src=board&pageno=<%=(j)%>"><%=(j)%></a></li>
				<% 
					count++;
					if (count%10 == 0) break;
					} %>
				<% if((pageno+1) <= pagingSize) { %>
					<li class="page-item"><a class="page-link" href="./FrontController?src=board&pageno=<%=(pageno+1)%>">
					<span class = "glyphicon glyphicon-menu-right" aria-hidden="true"></span>
					</a></li>
				<% } %>
				</ul>
				<!-- 페이징 끝 -->
				</td>
				<td align="right">
				<% if(session.getAttribute("user") != null) { %>
					<button class="btn btn-default" onclick="location.href = './FrontController?src=write'">글쓰기</button>
				<% } %>	
				</td>
			</tr>
		</tfoot>

	</table>
</div>


        