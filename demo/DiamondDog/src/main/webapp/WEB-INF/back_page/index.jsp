<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	padding-top: 70px;
}
</style>
  <%@ include file="../common/include-head.jsp"%>
<%-- <jsp:include page=""></jsp:include> --%>
</head>
<body>
 
	<header id="header" class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<span class="navbar-brand" data-i18n="title">jQuery Bootgrid</span>
		</div>
		<nav id="menu" class="navbar-collapse collapse" role="navigation">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">Basic Demo</a></li>
		</ul>
		</nav>
	</div>
	</header>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3 visible-md visible-lg">
				<div class="affix">Sub Nav</div>
			</div>
			<div class="col-md-9">
				<button id="send" type="button" class="btn btn-default">Send</button>
				<table id="grid"
					class="table table-condensed table-hover table-striped">
					<thead>
						<tr>
							<th data-column-id="id" data-identifier="true"
								data-type="numeric">Article ID</th>
							<th data-column-id="sender" data-order="asc">Article Name</th>
							<th data-column-id="quantity" data-formatter="quantity">Quantity</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Article 1</td>
							<td>0</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Article 2</td>
							<td>0</td>
						</tr>
						<tr>
							<td>3</td>
							<td>Article 3</td>
							<td>0</td>
						</tr>
						<tr>
							<td>4</td>
							<td>Article 4</td>
							<td>0</td>
						</tr>
						<tr>
							<td>5</td>
							<td>Article 5</td>
							<td>0</td>
						</tr>
						<tr>
							<td>6</td>
							<td>Article 6</td>
							<td>0</td>
						</tr>
						<tr>
							<td>7</td>
							<td>Article 7</td>
							<td>0</td>
						</tr>
						<tr>
							<td>8</td>
							<td>Article 8</td>
							<td>0</td>
						</tr>
						<tr>
							<td>9</td>
							<td>Article 9</td>
							<td>0</td>
						</tr>
						<tr>
							<td>10</td>
							<td>Article 10</td>
							<td>0</td>
						</tr>
						<tr>
							<td>11</td>
							<td>Article 11</td>
							<td>0</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<footer id="footer"> © Copyright 2014-2015, Rafael Staib </footer>

<script
		src="<%=basePath%>res/back/codegenerator_list.js"></script>
</body>
</html>