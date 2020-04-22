package com.app.service.developer;

import com.app.dao.AppCategoryDao;
import com.app.pojo.AppCategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService {
    @Resource
    private AppCategoryDao appCategoryDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
    public List<AppCategory> firstLevel() {
        return appCategoryDao.firstLevel();
    }

    @Override
    public List<AppCategory> secondLevel(int parentId) {
        return appCategoryDao.secondLevel(parentId);
    }
}
