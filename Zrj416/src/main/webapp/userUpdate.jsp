<%@ page import="com.app.pojo.Users" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/4/19
  Time: 13:17
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
    <%Users users= (Users) session.getAttribute("users");%>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> <%=users.getUname()%></span> , 欢迎你！</p>
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
                <li ><a href="productList.html">商品管理</a></li>
                <li id="active"><a href="userList.action">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <%Users upUser= (Users) request.getAttribute("upUser");%>
            <form action="userUpdate.action?uid=<%=upUser.getUserid()%>" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->

                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" placeholder="<%=upUser.getUname()%>"/>
                    <span >*</span>
                </div>

                <div>
                    <label >用户性别：</label>

                    <input name="sex" type="radio" checked value="1">男
                    <input name="sex" type="radio" value="2">女
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <INPUT class="sang_Calender" class=test type=text name="houseDate">
                    <script type="text/javascript" src="js/datetime.js"></script>
                    <span >*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="userphone" id="userphone" placeholder="<%=upUser.getUtel()%>"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress" placeholder="<%=upUser.getUadd()%>"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="userlei" value="管理员"/>管理员
                    <input type="radio" name="userlei" checked value="经理"/>经理
                    <input type="radio" name="userlei" value="普通用户"/>普通用户

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="保存" name="but"/>
                    <input type="submit" value="返回" onclick="history.back(-1)" name="but"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="js/time.js"></script>

</body>
</html>