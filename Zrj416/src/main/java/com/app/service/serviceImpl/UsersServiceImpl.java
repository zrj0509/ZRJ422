package com.app.service.serviceImpl;

import com.app.dao.UsersDao;
import com.app.dao.daoImpl.UsersDaoImpl;
import com.app.pojo.Users;
import com.app.service.UsersService;
import com.app.util.PageInfo;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    UsersDao usersDao= new UsersDaoImpl();
    @Override
    public List<Users> all(String uname) {
        return usersDao.all(uname);
    }

    @Override
    public Users findById(int userid) {
        return usersDao.findById(userid);
    }

    @Override
    public int add(Users users) {
        return usersDao.add(users);
    }

    @Override
    public int update(Users users) {
        return usersDao.update(users);
    }

    @Override
    public int delete(int userid) {
        return usersDao.delete(userid);
    }

    @Override
    public int updatepsw(Users users) {
        return usersDao.updatepsw(users);
    }

    @Override
    public int getCount() {
        return usersDao.getCount();
    }

    @Override
    public List<Users> getPageInfo(PageInfo pageInfo) {
        return usersDao.getPageInfo(pageInfo);
    }
}
