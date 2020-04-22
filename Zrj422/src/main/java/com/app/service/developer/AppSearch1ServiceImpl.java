package com.app.service.developer;

import com.app.dao.AppSearch1;
import com.app.pojo.DataDictionary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AppSearch1ServiceImpl implements AppSearch1Service{
    @Resource
    private AppSearch1 appSearch1;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    public List<DataDictionary> appStatus() {
        return appSearch1.appStatus();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    public List<DataDictionary> appFlatform() {
        return appSearch1.appFlatform();
    }
}
