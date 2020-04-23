package com.app.service.developer;

import com.app.pojo.AppInfo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;

import java.util.List;

public interface AppInfoService {
    List<AppInfo> all();
    int add(Appinfo appinfo);
}
