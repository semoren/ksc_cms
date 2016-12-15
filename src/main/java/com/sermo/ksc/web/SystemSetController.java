package com.sermo.ksc.web;

import com.sermo.ksc.constant.Globals;
import com.sermo.ksc.doman.SystemSetting;
import com.sermo.ksc.service.SystemSettingServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author sermo
 * @version 2016/12/14.
 */
@Controller
public class SystemSetController {

    @Resource
    private SystemSettingServer server;


    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public String view(ModelMap map, String flag){
        SystemSetting setting = server.find();
        map.addAttribute("setting", setting);
        map.addAttribute("times", Globals.TIME_LIST);
        map.addAttribute("flag", flag);
        return "system/setting";
    }

    @RequestMapping(value = "/setting", method = RequestMethod.POST)
    @ResponseBody
    public String save(SystemSetting setting){
        return server.update(setting) ? "1" : "0";
    }

}
