<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>新規グループ作成</title>

<!-- Bootstrap core CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	rel="stylesheet"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<meta name="theme-color" content="#563d7c">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anthor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media( min-width : 768px){
	.bd-placeholder-img-lg{
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="/GuiWork/css/dashboard.css" rel="stylesheet">
</head>
<body>
	<nav  class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
	<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">ActionLogger</a>
	</nav>
	<div class="row">
		<div class="col"></div>
		<div class="col-8">
			<form class="form-group" action="/ActionLogger/GroupRgst" method="post">
			<h4 h3 mb-3 font-weight-normal>新規グループ</h4>
			<div class = "mb-3">
				<label for="group_name">グループ名</label>
				<input type="text" class="form-control" id="group_name"
					placeholder="グループ名" require>
			</div>
			<div class="mb-3">
				<label date>日付</label>
				<input type="text" class="form-control" id="date"
					placeholder="日付">
			</div>
			<div class="mb-3">
				<label time>時刻</label>
				<input type="text" class="form-control" id="time"
					placeholder="時刻">
			</div>
			<div class="mb-3">
				<label place>場所</label>
					<input type="text" class="form-control" id="place"
						placceholder="場所">
			</div>
			<div class="mb-3">
				<label reason>理由</label>
				<input type="text" class="form-control" id="reason"
					placedholder="理由">
			</div>
			<div class="mb-3">
				<label remarks>備考</label>
				<input type="text" class="form=control" id="remarks"
					placeholder="備考">
			</div>
			<input type="submit" class="btn btn-secondary btn-block btn-lg"
				id="enterRoom" value="登録"></input
			</form>
		</div>
		<div class="col"></div>
	</div>
</div>