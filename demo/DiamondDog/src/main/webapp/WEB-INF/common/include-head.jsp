<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath%>res/assets/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="<%=basePath%>res/assets/bootstrap/3.3.5/css/bootstrap-theme.min.css"
	rel="stylesheet" />
<link
	href="<%=basePath%>res/assets/jquery-bootgrid-master/jquery.bootgrid.css"
	rel="stylesheet" />

<script src="<%=basePath%>res/assets/jquery/jquery-1.12.0.js"></script>
<script src="<%=basePath%>res/assets/bootstrap/3.3.5/js/bootstrap.js"></script>
<script
	src="<%=basePath%>res/assets/jquery-bootgrid-master/jquery.bootgrid.js"></script>
<script
	src="<%=basePath%>res/assets/jquery-bootgrid-master/jquery.bootgrid.fa.js"></script>

