package com.techacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.User;
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

        @RequestMapping("register")
        public String register(Model model) {
                return "user/register";
        }

        @RequestMapping(path="register", params="registerRun")
        public String registerRun(@ModelAttribute User user, Model model) {
                userService.saveUser(user);
                model.addAttribute("userlist", userService.getUserList());
                return "user/list";
        }
}