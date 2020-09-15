<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewpoint" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>新規グループ作成</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<meta name="theme-color" content="#563d7c">

<link href="/GuiWork/css/dashboard.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">ActionLogger</a>
</nav>
<div class="row">
	<div class="col"></div>
	<div class="col-8">
		<form class="form-adduser" action="/ActionLogger/GroupRgst" method="post">
		
		<h4 h3 mb-3 font-weight-nomal>新規グループ</h4>
		<div class="mb-3">グループ名: ${groupToAdd.group_name }</div>
		<div class="mb-3">日付: ${groupToAdd.date }</div>
		<div class="mb-3">時刻: ${groupToAdd.time }</div>
		<div class="mb-3">場所: ${groupToAdd.place }</div>
		<div class="mb-3">理由: ${groupToAdd.reason }</div>
		<div class="mb-3">備考: ${groupToAdd.remarks }</div>
		
		<%-- フォームの正当性確認データ  --%>
		<input type="hidden" name="status" value="confirmed"></input>
		<input type="submit" class="btn btn-secondary btn-block btn-lg" id="enterRoom" value="OK"></input>
		</form>
	</div>
	<div class="col"></div>
</div>
</body>
</html>