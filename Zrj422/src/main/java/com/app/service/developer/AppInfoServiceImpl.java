package com.app.service.developer;

import com.app.dao.AppInfoDao;
import com.app.pojo.AppInfo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class AppInfoServiceImpl implements AppInfoService {
    @Resource
    private AppInfoDao appInfoDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    public List<AppInfo> all() {
        return appInfoDao.all();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int add(Appinfo appinfo) {
        return appInfoDao.add(appinfo);
    }
}
