package com.app.controller.developer;

import com.app.pojo.AppCategory;
import com.app.pojo.DataDictionary;
import com.app.service.developer.AppCategoryService;
import com.app.service.developer.AppSearch1Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.pojo.DevUser;
import com.app.service.developer.DevUserService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/DevUser")
public class DevController {
    @Resource
    private DevUserService devUserService;
    @Resource
    private AppSearch1Service appSearch1Service;
    @Resource
    private AppCategoryService appCategoryService;
    @RequestMapping("/login")
    public String login(ModelMap modelMap,String devCode,String devPassword){
        System.out.println("登录"+devCode);
        System.out.println("登录"+devPassword);
        DevUser devUser=devUserService.findByCode(devCode);
        System.out.println(devUser);
        if (devUser.getDevPassword().equals(devPassword)){
            modelMap.addAttribute("devUser",devUser);
            return "jsp/developer/main";
        }else {
            return "jsp/devlogin";
        }
    }
    @RequestMapping("/logout")
    public String login(ModelMap modelMap){
        DevUser devUser= (DevUser) modelMap.get("devUser");
        System.out.println(devUser);
        modelMap.remove("delUser");
        return "jsp/index";
    }
    @RequestMapping("appinfolist")
    public String appinfolist(ModelMap modelMap){
        List<DataDictionary> appstatus=appSearch1Service.appStatus();
        List<DataDictionary> appflatform=appSearch1Service.appFlatform();
        List<AppCategory> appCategories=appCategoryService.firstLevel();
        System.out.println(appstatus.size());
        System.out.println(appflatform.size());
        System.out.println(appCategories.size());
        modelMap.addAttribute("statusList",appstatus);
        modelMap.addAttribute("flatFormList",appflatform);
        modelMap.addAttribute("categoryLevel1List",appCategories);
        return "jsp/developer/appinfolist";
    }
}
