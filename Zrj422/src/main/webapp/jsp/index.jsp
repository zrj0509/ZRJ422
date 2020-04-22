<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理系统</title>
</head>
<link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath }/statics/css/custom.min.css" rel="stylesheet">
<style type="text/css">
    a:hover {
        text-decoration: underline;
    }
</style>
<body>
<div class="main_container">
    <!-- page content -->
    <div class="col-md-12">
        <div class="col-middle">
            <div class="text-center">
                <h1 class="error-number" style="font-size: 59px;">App后台管理系统</h1>
                <a style="font-size:20px;" href="${pageContext.request.contextPath }/jsp/backendlogin.jsp">后台管理系统入口</a><br/><br/>
                <a  style="font-size:20px;" href="${pageContext.request.contextPath }/jsp/devlogin.jsp">开发者平台入口</a>
            </div>
        </div>
    </div>
    <!-- /page content -->
</div>
</body>
</html>