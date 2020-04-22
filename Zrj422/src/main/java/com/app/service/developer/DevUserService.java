package com.app.service.developer;

import com.app.pojo.DevUser;

public interface DevUserService {
    public DevUser findByCode(String devCode);
}
