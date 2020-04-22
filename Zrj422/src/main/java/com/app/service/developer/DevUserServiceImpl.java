package com.app.service.developer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.DevUserDao;
import com.app.pojo.DevUser;

import javax.annotation.Resource;

@Service
@Transactional
public class DevUserServiceImpl implements DevUserService{
    @Resource
    private DevUserDao devUserDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public DevUser findByCode(String devCode) {
        return devUserDao.findByCode(devCode);
    }
}
