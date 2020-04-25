package com.app.dao;

import com.app.pojo.AppInfo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;

import java.util.List;

public interface AppInfoDao {
    List<AppInfo> all();
    int add(AppInfo appInfo);
}
