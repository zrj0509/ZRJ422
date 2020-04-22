package com.app.dao.daoImpl;

import com.app.dao.UsersDao;
import com.app.pojo.Users;
import com.app.util.BaseDao;
import com.app.util.PageInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl extends BaseDao implements UsersDao {
    @Override
    public List<Users> all(String uname) {
        List<Users> list=new ArrayList<>();
        ResultSet rs=null;
        String sql="select * from users ";
        System.out.println(uname);
        if (uname==null || uname.equals(""))
        {
            rs=this.search(sql);
        }
        else {
            sql=sql+"where uname like ?";
            System.out.println(sql);
            Object[] objs={"%"+uname+"%"};
            rs=this.search(sql,objs);
        }
        Users users=null;
        try {
            while (rs.next()){
                users=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                list.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        System.out.println(list.size()+"hhh");
        return list;
    }

    @Override
    public Users findById(int userid) {
        String sql="select * from users where userid = ? ";
        Object[] objs={userid};
        ResultSet rs=this.search(sql,objs);
        Users users=null;
        try {
            while (rs.next()){
                users=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource();
        }
        return users;
    }

    @Override
    public int add(Users users) {
        String sql="insert into users (userid,uname,upwd,usex,ubirth,utel,uadd,utype) values(?,?,?,?,?,?,?,?)";
        Object[] objects={users.getUserid(),users.getUname(),users.getUpwd(),users.getUsex(),users.getUbirth(),users.getUtel(),users.getUadd(),users.getUtype()};
        return this.update(sql,objects);
    }

    @Override
    public int update(Users users) {
        String sql="update users set uname= ? ,upwd=? ,usex=? ,ubirth=?,utel=? ,uadd=?,utype= ? where userid= ?";
        Object[] objects={users.getUname(),users.getUpwd(),users.getUsex(),users.getUbirth(),users.getUtel(),users.getUadd(),users.getUtype(),users.getUserid()};
        return this.update(sql,objects);
    }

    @Override
    public int delete(int userid) {
        String sql="delete from users where userid= ?";
        Object[] objects={userid};
        return this.update(sql,objects);
    }

    @Override
    public int updatepsw(Users users) {
        String sql="update users set upwd = ? where userid= ?";
        Object[] objects={users.getUpwd(),users.getUserid()};
        return this.update(sql,objects);
    }

    @Override
    public int getCount() {
        String sql="select count(1) from users";
        ResultSet rs=this.search(sql);
        try {
            rs.next();
            return rs.getInt(1);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();  //关闭连接
        }
        return 0;
    }

    @Override
    public List<Users> getPageInfo(PageInfo pageInfo) {
        List<Users> list= new ArrayList<>();
        ResultSet rs=null;
        //sql语句
        String sql="select * from users LIMIT ?,?";
        //参数
        Object[] objs={(pageInfo.getCurrentPage()-1)*pageInfo.getRows(),pageInfo.getRows()};
        rs= this.search(sql,objs);
        Users users=null;
        try {
            while(rs.next()){
                users=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                list.add(users);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        System.out.println(list.size());
        return list;
    }
}
