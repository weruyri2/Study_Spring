<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">글 목록 리스트</h3>
				</div>
				<div class="box-body">
				<h2>${result}</h2>
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">글 번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>날짜</th>
		<th style="width: 40px">조회수</th>
	</tr>

		<c:forEach items="${boardList}" var="list" >
		<tr>
			<th style="width:10px">${list.bno}</th>
			<th>
				<a href="/board/read?bno=${list.bno}">
				${list.title}
				<c:if test="${list.title eq ''}" >
				<c:out value="${list.bno}"/>
				</c:if>
				</a>
			</th>
			<th>${list.writer }</th>
			<th>
				<fmt:formatDate
				 pattern="yyyy-MM-dd HH:mm"
				  value="${list.regdate}"/></th>
			<th style="width:40px">${list.viewcnt}</th>
		</tr>
		</c:forEach>
	

</table>
	

				</div>
				<!-- /.box-body -->
				<div class="box-footer">Footer
					<div class="text-center">
						<ul class="pagination">
						
							<c:if test="${PageMaker.prev}">
							<li>	<a href='listCri?page=${PageMaker.startPage -1}'>이전</a>	 </li>
							</c:if>
							
							<c:forEach begin="${PageMaker.startPage}" end="${PageMaker.endPage}" var="idx">
							<li><a href="listCri?page=${idx}">${idx}</a></li>
						
							</c:forEach>
							
							<c:if test="${PageMaker.next && PageMaker.endPage > 0 }">
							<li>	<a href='listCri?page=${PageMaker.endPage+1 }'>다음</a> </li>
							</c:if>
						</ul>
					</div>
				</div>
				
				
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script type="text/javascript">
	//alert();
	//전달 정보가 SUCESS 일때만 "정상처리된 페이지 입니다"
	//"글 저장이 성공했습니다."

	
	var result = '${result}';

	if(result == "SUCCESS") alert("정상처리된 페이지입니다");
</script>



<%@ include file="../include/footer.jsp" %>