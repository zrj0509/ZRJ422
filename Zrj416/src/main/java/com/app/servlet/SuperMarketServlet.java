package com.app.servlet;

import com.app.pojo.Users;
import com.app.service.UsersService;
import com.app.service.serviceImpl.UsersServiceImpl;
import com.app.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SuperMarketServlet",urlPatterns = "*.action")
public class SuperMarketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        String filename=path.substring(1,path.lastIndexOf("."));
        try {
            Method method=this.getClass().getDeclaredMethod(filename,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    protected void userList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        UsersService usersService=new UsersServiceImpl();
        String suname=request.getParameter("suname");
        List<Users> list=new ArrayList<>();
        int count=usersService.getCount();
        int pageIndex=1;
        PageInfo pageInfo =new PageInfo();
        //超链接请求的页数
        String str=request.getParameter("pageIndex");
        //判断
        pageIndex=(str==null)?(1):(Integer.parseInt(str));
        int pageSize=5;

        //3>设置总个数
        pageInfo.setCurrentPage(pageIndex);
        pageInfo.setRows(pageSize);
        pageInfo.setCount(count);
        if (suname!=null){
            list=usersService.all(suname);
        }else {
            list=usersService.getPageInfo(pageInfo);
        };
        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("userList.jsp").forward(request,response);
    }
    protected void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        UsersService usersService=new UsersServiceImpl();
        String uname=request.getParameter("username");
        String pwd=request.getParameter("password");
        List<Users> list=usersService.all(uname);
        Users users=list.get(0);
        if (list.size()!=0 && uname!=null && !uname.equals("")){
            if (pwd.equals(list.get(0).getUpwd())){
                session.setAttribute("users",users);
                response.sendRedirect("welcome.jsp");
            }else {
                response.sendRedirect("login.jsp");
            }
        }else {
            response.sendRedirect("login.jsp");
        }
    }
    protected void password(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        UsersService usersService=new UsersServiceImpl();
        String userid=request.getParameter("userid");
        Users users=usersService.findById(Integer.parseInt(userid));
        String oldPassword=request.getParameter("oldPassword");
        String newPassword=request.getParameter("newPassword");
        String reNewPassword=request.getParameter("reNewPassword");
        if (users.getUpwd().equals(oldPassword)&&newPassword.equals(reNewPassword)){
            users.setUpwd(newPassword);
            usersService.updatepsw(users);
            response.sendRedirect("login.jsp");
        }else {
            response.sendRedirect("password.jsp");
        }
    }
    protected void userAdd(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("add");
        UsersService usersService=new UsersServiceImpl();
        String userid=request.getParameter("userId");
        String uname=request.getParameter("userName");
        String upwd=request.getParameter("userpassword");
        String usex=request.getParameter("sex");
        String ubirth=request.getParameter("houseDate");
        String utel=request.getParameter("userphone");
        String uadd=request.getParameter("userAddress");
        String utype=request.getParameter("userlei");
        System.out.println(utype);
        int type=0;
        if (utype.equals("管理员")){
            type=1;
        }
        else if (utype.equals("经理")){
            type=2;
        }
        else if (utype.equals("普通用户")){
            type=3;
        }
        String repwd=request.getParameter("userRemi");
        String submit=request.getParameter("submit");
        Users users=new Users(Integer.parseInt(userid),uname,upwd,usex,ubirth,utel,uadd,type);
        if (repwd.equals(upwd) && submit.equals("保存")){
            usersService.add(users);
            response.sendRedirect("welcome.jsp");
        }else{
            response.sendRedirect("userAdd.jsp");
        }
    }
    protected void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id=request.getParameter("uid");
        UsersService usersService=new UsersServiceImpl();
        usersService.delete(Integer.parseInt(id));
        response.sendRedirect("userList.action");
    }
    protected void userView(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id=request.getParameter("uid2");
        UsersService usersService=new UsersServiceImpl();
        Users users=usersService.findById(Integer.parseInt(id));
        request.setAttribute("userV",users);
        request.getRequestDispatcher("userView.jsp").forward(request,response);
    }
    protected void userUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id=request.getParameter("uid");
        UsersService usersService=new UsersServiceImpl();
        Users users=usersService.findById(Integer.parseInt(id));
        String userName=request.getParameter("userName");
        String usex=request.getParameter("usex");
        String ubirth=request.getParameter("houseDate");
        String utel=request.getParameter("userphone");
        String uAdd=request.getParameter("userAddress");
        String type=request.getParameter("userlei");
        String submit=request.getParameter("but");
        int utype=0;
        switch (type){
            case "管理员":
                utype=1;
                break;
            case "经理":
                utype=2;
                break;
            case "普通用户":
                utype=3;
                break;
        }
        System.out.println(submit);
        System.out.println("update"+type+utype);
        Users users2=new Users(Integer.parseInt(id),userName,users.getUpwd(),usex,ubirth,utel,uAdd,utype);
        System.out.println(id+"张张");
        System.out.println(usersService.update(users2));
        if ("保存".equals(submit)) {
            response.sendRedirect("userList.action");
        }else {
            response.sendRedirect("userUpdate.jsp");
        }
    }
    protected void sendUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("sendid");
        UsersService service=new UsersServiceImpl();
        Users users=service.findById(Integer.parseInt(id));
        request.setAttribute("upUser",users);
        request.getRequestDispatcher("userUpdate.jsp").forward(request,response);
    }
}
