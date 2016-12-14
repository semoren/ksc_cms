package com.sermo.ksc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sermo
 * @version 2016/12/14.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/userInfo/list", method = RequestMethod.GET)
    public String view(){
        return "index";
    }
}
