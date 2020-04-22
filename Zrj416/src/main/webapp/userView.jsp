<%@ page import="com.app.pojo.Users" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/4/17
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
<%Users usersall= (Users) session.getAttribute("users");%>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> <%=usersall.getUname()%></span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="billList.html">账单管理</a></li>
                <li ><a href="providerList.html">供应商管理</a></li>
                <li id="active"><a href="userList.action">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <%Users users= (Users) request.getAttribute("userV");%>
        <div class="providerView">
            <p><strong>用户编号：</strong><span><%=users.getUserid()%></span></p>
            <p><strong>用户名称：</strong><span><%=users.getUname()%></span></p>
            <p><strong>用户性别：</strong><span><%=users.getUsex()%></span></p>
            <p><strong>出生日期：</strong><span><%=users.getUbirth()%></span></p>
            <p><strong>用户电话：</strong><span><%=users.getUtel()%></span></p>
            <p><strong>用户地址：</strong><span><%=users.getUadd()%></span></p>
            <%int utype=users.getUtype();
            String type="";
            switch (utype){
                    case 1:
                        type="管理员";
                        break;
                    case 2:
                        type="经理";
                        break;
                    case 3:
                        type="普通用户";
                        break;
                    default:
                        return;
            }%>
            <p><strong>用户类别：</strong><span><%=type%></span></p>

            <a href="userList.action">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="js/time.js"></script>

</body>
</html>
