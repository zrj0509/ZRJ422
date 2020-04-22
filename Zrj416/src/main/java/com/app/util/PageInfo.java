package com.app.util;



//import pojo.Userinfo;

import com.app.pojo.Users;

import java.util.List;

/**
 * @ClassName PageInfo
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/27
 * @Version V1.0
 **/
public class PageInfo {
    private int count;//总条数  ---------18 数据库(查询)
    private int totalPage;//总页数    ----------4 算出来的 (计算)
    private int rows=5;//每页显示行数 -------------5 自定义
    private int currentPage=1;//当前页码    ---------1 前端
    private List<Users> list; // 内容---------数据库(查询)

    //默认的构造方法
    public PageInfo() {
    }

    /**
     *
     * @param count  总个数
     * @param rows  每页显示的个数
     * @param currentPage 当前页
     * @param list  当前页数据
     */
    public PageInfo(int count, int rows, int currentPage, List<Users> list) {
        this.count = count;
        this.rows = rows;
        this.currentPage = currentPage;
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    /**
     * 计算总页数 =总个数/每页显示的个数
     * @return
     */
    public void setCount(int count) {
        this.count = count;
        //计算
        this.totalPage =(int)(Math.ceil(count/(double)rows));
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Users> getList() {
        return list;
    }

    public void setList(List<Users> list) {
        this.list = list;
    }


//    public static void main(String[] args) {
//        System.out.println((int)Math.ceil(18/5.0));
//    }
}
