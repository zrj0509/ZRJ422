package com.app.service.developer;

import com.app.pojo.AppInfo;
import java.util.List;

public interface AppInfoService {
    List<AppInfo> all();
    int add(AppInfo appInfo);
}
