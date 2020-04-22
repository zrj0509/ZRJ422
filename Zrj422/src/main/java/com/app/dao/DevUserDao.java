package com.app.dao;

import com.app.pojo.DevUser;

public interface DevUserDao {
    public DevUser findByCode(String devCode);
}
