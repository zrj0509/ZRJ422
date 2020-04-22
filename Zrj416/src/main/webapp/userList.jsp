<%@ page import="java.util.List" %>
<%@ page import="com.app.pojo.Users" %>
<%@ page import="com.app.util.PageInfo" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/4/16
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>超市账单关了系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<%Users users= (Users) session.getAttribute("users");%>
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
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
                <li><a href="providerList.html">供应商管理</a></li>
                <li><a href="productList.html">商品管理</a></li>
                <li  id="active"><a href="userList.action">用户管理</a></li>

                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <div class="search">
            <span>用户名：</span>
            <input type="text" placeholder="请输入用户名" id="suname"/>
            <input type="button" value="查询" id="search" />
            <a href="userAdd.jsp">添加用户</a>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户编码</th>
                <th width="20%">用户名称</th>
                <th width="10%">性别</th>
                <th width="10%">生日</th>
                <th width="10%">电话</th>
                <th width="10%">用户类型</th>
                <th width="30%">操作</th>
            </tr>
            <% List<Users> list= (List<Users>) request.getAttribute("list");
                PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
                for (Users user:
                     list) {
                    int type=user.getUtype();
                    String utype="";
            switch (type){
                case 1:
                    utype="管理员";
                    break;
                case 2:
                    utype="经理";
                    break;
                case 3:
                    utype="普通用户";
                    break;
                    default:
                        return;
            }%>
            <tr>
                <td><%=user.getUserid()%></td>
                <td><%=user.getUname()%></td>
                <td><%=user.getUsex()%></td>
                <td><%=user.getUbirth()%></td>
                <td><%=user.getUtel()%></td>
                <td><%=utype%></td>
                <td>
                    <input id="id" value="<%=user.getUserid()%>" hidden>
                    <a href="userView.action?uid2=<%=user.getUserid()%>"><img src="img/read.png" alt="查看" title="查看"/></a>
                    <a href="sendUser.action?sendid=<%=user.getUserid()%>" onclick="userUpdate(<%=user.getUserid()%>)"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                    <a href="#" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>
                </td>
            </tr>
            <%}%>
        </table>
        <div id="pag" >
            共有<font color=red>&nbsp;<%=pageInfo.getTotalPage()%>&nbsp;</font>页,当前第<font color=red>&nbsp;<%=pageInfo.getCurrentPage()%>&nbsp;</font>页，
            <%--数字页数--%>
            <span>
               <%
                   for (int i = 1; i <=pageInfo.getTotalPage() ; i++) {
               %>
                <a href="userList.action?pageIndex=<%=i%>"><%=i%><a>
                        <%}%>
           </span>

            <% if(pageInfo.getCurrentPage()>1) {%>
            <a href="userList.action?pageIndex=1">首页</a>
            <a href="userList.action?pageIndex=<%=pageInfo.getCurrentPage()-1%>">上一页</a>
            <%}%>
            <% if(pageInfo.getCurrentPage()<pageInfo.getTotalPage()) {%>
            <a href="userList.action?pageIndex=<%=pageInfo.getCurrentPage()+1%>">下一页</a>
            <a href="userList.action?pageIndex=<%=pageInfo.getTotalPage()%>">尾页</a>
            <%}%>
        </div>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
    版权归北大青鸟
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>
