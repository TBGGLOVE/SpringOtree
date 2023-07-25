<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/static/css/custom.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">


<style>
.right-align {
	text-align: right;
}

.padding {
	padding: 0 15px;
}
</style>


</head>
<body>
	<!-- navbar -->
	<jsp:include page="./includes/navbar.jsp" />
	<section class="container-fluid">
		<div class="row">
			<!-- sidebar -->
			<jsp:include page="./includes/sidebar.jsp" />
			<!-- main -->
			<main class="col">
				<!-- 여백 -->
				<div class="p-4"></div>
				<div class="container mt-5">
					<!-- 개요 -->
					<div class="mt-5">
						<h2>게시판</h2>
					</div>

					<div
						class="mt-4 row border-top border-bottom border-success border-2 vh-60">
						<table class="table text-center" style="table-layout: fixed">
							<thead>
								<tr>
									<th class="col-1">No</th>
									<th class="col-6">제목</th>
									<th class="col-2">작성자</th>
									<th class="col-2">날짜</th>
									<th class="col-1">조회</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="board" items="${boardList}">
									<tr class="vh-5">
										<th scope="row"><c:out value="${board.boardId}" /></th>
										<td align="center" class="col-6"><a href="/douzone/workspace/${board.workspaceId}/getBoardDetail?boardId=${board.boardId}&pageNum=${pager.pageNum}"><c:out value="${board.boardTitle}" /></a></td>
										<td>${board.name}</td>
										<td><c:out value="${board.createdAt}" /></td>
										<td><c:out value="${board.readcount}" /></td>
									</tr>
								</c:forEach>
								<!-- 테이블 높이 조절을 위한 행 -->
								<tr class="border-white">
									<th scope="row"></th>
									<td class="text-start"></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
					<table>
						<tr align="center">
							<td style="padding: 0 30px;">
								<button
									onclick="window.location.href='/douzone/workspace/${workspaceId}/createBoard/${pager.pageNum}'"
									class="btn btn-primary">글쓰기</button> <!-- Page에서 model로 넘겨준 -->
							</td>
							<td class="padding">
								<button id="button1"
									onclick="window.location.href='/douzone/workspace/${workspaceId}/board/' + document.getElementById('button1').value"
									value="1" class="btn btn-third button">[1]</button> <!-- 초기는 1이라 pager.pageNum으로 받아도 됨 -->
							</td>
							<td class="padding">
								<button id="button2"
									onclick="window.location.href='/douzone/workspace/${workspaceId}/board/' + document.getElementById('button2').value"
									value="2" class="btn btn-third button">[2]</button>
							</td>
							<td class="padding">
								<button id="button3"
									onclick="window.location.href='/douzone/workspace/${workspaceId}/board/' + document.getElementById('button3').value"
									value="3" class="btn btn-third button">[3]</button>
							</td>
							<td class="padding">
								<button id="button4"
									onclick="window.location.href='/douzone/workspace/${workspaceId}/board/' + document.getElementById('button4').value"
									value="4" class="btn btn-third button">[4]</button>
							</td>
							<td class="padding">
								<button id="button5"
									onclick="window.location.href='/douzone/workspace/${workspaceId}/board/' + document.getElementById('button5').value"
									value="5" class="btn btn-third button">[5]</button>
							</td>

						</tr>
					</table>


				</div>
			</main>
		</div>
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/navbar.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/sidebar.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/static/js/todo.js"></script>
</body>
</html>
