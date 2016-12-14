package com.sermo.ksc.web;

import com.sermo.ksc.constant.Globals;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sermo
 * @version 2016/12/14.
 */
@Controller
public class SystemSetController {

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public String view(ModelMap map){
        map.addAttribute("times", Globals.TIME_LIST);
        return "system/setting";
    }

}
