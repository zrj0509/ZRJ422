package com.app.service.developer;

import com.app.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {
    List<AppCategory> firstLevel();
    List<AppCategory> secondLevel(int parentId);
}
