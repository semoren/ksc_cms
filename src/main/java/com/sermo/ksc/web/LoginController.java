package com.sermo.ksc.web;

import com.sermo.components.biz.util.MD5Util;
import com.sermo.ksc.constant.Globals;
import com.sermo.ksc.doman.UserInfo;
import com.sermo.ksc.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author sermo
 * @version 2016年7月12日 
 */
@Controller
public class LoginController {

	@Resource
	private UserInfoService service;

	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value={"/login","/"}, method=RequestMethod.GET)
	public String toLogin(ModelMap map) {
		return "login/login";
	}
	
	/**
	 * 登陆
	 * @param email
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(ModelMap modelMap, String email, String password, HttpSession session) {
		UserInfo userInfo = service.findByEmail(email);
		if (userInfo == null || userInfo.getState() == 0) {
			modelMap.addAttribute("errMsg", "当前用户不存在，或已被禁用，请联系管理员");
			return "login/login";
		}
		if (!userInfo.getPassword().equals(MD5Util.encrypt(password))) {
			modelMap.addAttribute("errMsg", "密码错误");
			return "login/login";
		}
		session.setAttribute(Globals.USER_SESSION, userInfo.copy());
		return "redirect:/home";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String toRegister(ModelMap map) {
		map.put("title", "注册"); // 设置页面title
		return "login/registration";
	}
	
	
	/**
	 * 注册用户
	 * @param info
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(UserInfo info, ModelMap map) {

		UserInfo userInfo = service.findByEmail(info.getEmail());
		if (userInfo != null) {
			map.addAttribute("errMsg", "此邮箱已存在");
			return "login/registration";
		}

		boolean flag = service.register(info);
		if (flag) {
			return "redirect:/login";
		}
		map.addAttribute("errMsg", "注册失败");
		return "login/registration";
	}
	
	
	/**
	 * 退出
	 * @param email
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logOut(String email, HttpSession session) {
		session.removeAttribute(Globals.USER_SESSION);
		return "redirect:/login";
	}
}
