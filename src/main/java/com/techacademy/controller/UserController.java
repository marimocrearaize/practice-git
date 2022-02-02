package com.techacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
        @Autowired
        private UserService userService;

        @RequestMapping("list")
        public String list(Model model) {
                model.addAttribute("userlist", userService.getUserList());
                return "user/list";
        }
}