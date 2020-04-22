package com.app.util;

import java.sql.*;

public class BaseDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    public boolean getConnection(){
        String driver=ConfigManager.getInstance().getString("mysql.driver");
        String url=ConfigManager.getInstance().getString("mysql.url");
        String username=ConfigManager.getInstance().getString("mysql.username");
        String password=ConfigManager.getInstance().getString("mysql.password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public int update(String sql,Object...params){
        int row=0;
        if (getConnection()){
            try {
                ps=con.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1,params[i]);
                }
                row=ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.closeResource();
            }
        }
        return  row;
    }
    public ResultSet search(String sql,Object...params){
        if (getConnection()){
            try {
                ps=con.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1,params[i]);
                }
                rs=ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
    public boolean closeResource() {
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
