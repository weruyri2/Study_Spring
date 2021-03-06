<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">게시판 본문</h3>
				</div>
				<!-- /.box-header -->
	
<form role="form" action="" method="post">
<input type="hidden" name="bno" value="${boardVO.getBno()}" >
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">제목</label> 
			<input type="text"
				name='title' class="form-control" value="${boardVO.getTitle()}">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">내용</label>
			<textarea class="form-control" name="content" rows="3"
				>${boardVO.getContent()}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">글쓴이</label> 
			<input type="text"
				name="writer" class="form-control" value="${boardVO.getWriter()}" >
		</div>
	</div>
	<!-- /.box-body -->

	<div class="box-footer">
		<button type="submit" class="btn btn-warning">수정하기</button>
	</div>
</form>


			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@ include file="../include/footer.jsp" %>

<script>
	$(document).ready(function(){
		//alert("제이쿼리 실행");
		//폼테그를 선택해서 특정페이지로 이동
		//정보(글번호)를 가지고 이동
	
		//폼태그 접근
		var formObj = $("form[role='form']");

		//수정하기
		$(".btn-warning").on("click", function(){
			alert("수정 버튼 클릭");
			formObj.attr("action", "/board/updateAction");
			formObj.submit();
			})
						
		});



</script>