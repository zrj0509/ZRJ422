package com.app.service;

import com.app.pojo.Users;
import com.app.util.PageInfo;

import java.util.List;

public interface UsersService {
    public List<Users> all(String uname);
    public Users findById(int userid);
    public int add(Users users);
    public int update(Users users);
    public int delete(int userid);
    public int updatepsw(Users users);
    int getCount();  //总个数
    List<Users> getPageInfo(PageInfo pageInfo);  //当前页的数据
}
