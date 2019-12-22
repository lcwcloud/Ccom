package com.cc.controller;

import com.alibaba.fastjson.JSON;
import com.cc.model.UserT;
import com.cc.service.UserTService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private UserTService userTService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest httpServletRequest, Model model) {
        int userId = Integer.parseInt(httpServletRequest.getParameter("id"));
        UserT userT = this.userTService.getUserById(userId);
        logger.error("用户信息:" + JSON.toJSON(userT));
        model.addAttribute("user", userT);
        return "showUser";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(HttpServletRequest httpServletRequest,
                           @RequestParam(defaultValue = "", value = "name", required = true) String name,
                           @RequestParam(defaultValue = "", value = "password", required = false) String password,
                           @RequestParam(value = "age", required = true) Integer age,
                           Model model) {
        UserT userT = new UserT();
        userT.setUserName(name);
        userT.setPassword(password);
        userT.setAge(age);
        this.userTService.insertUser(userT);
        model.addAttribute("user", userT);
        return "success";
    }
}
