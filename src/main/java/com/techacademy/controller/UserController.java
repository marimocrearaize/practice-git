package com.techacademy.controller;

import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techacademy.entity.User;
import com.techacademy.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
        @Autowired
        private UserService userService;

        @Autowired
        MessageSource messageSource;

        @RequestMapping("list")
        public String list(Model model) {
                model.addAttribute("userlist", userService.getUserList());
                return "user/list";
        }

        @RequestMapping("register")
        public String register(@ModelAttribute User user,
                                                Model model) {
                return "user/register";
        }

        @RequestMapping(path="register", params="registerRun")
        public String registerRun(@ModelAttribute @Validated User user,
                                                        BindingResult res,
                                                        Model model) {
                String rtn = null;
                if (!res.hasErrors()) {
                        userService.saveUser(user);
                        model.addAttribute("userlist", userService.getUserList());
                        rtn = "user/list";
                } else {
                        model.addAttribute("errmsg", messageSource.getMessage("errmsg.form.input", null, Locale.getDefault()));
                        model.addAttribute("user", user);
                        rtn = "user/register";
                }
                return rtn;
        }

        @RequestMapping(path="list", params="toChange")
        public String toChange(@RequestParam(name="idck") Integer idck, Model model) {
                model.addAttribute("user", userService.getUser(idck));
                return "user/change";
        }

        @RequestMapping(path="change", params="changeRun")
        public String changeRun(@ModelAttribute User user, Model model) {
                userService.saveUser(user);
                model.addAttribute("userlist", userService.getUserList());
                return "user/list";
        }

        @RequestMapping(path="change", params="returnList")
        public String returnList(Model model) {
                model.addAttribute("userlist", userService.getUserList());
                return "user/list";
        }

        @RequestMapping(path="list", params="deleteRun")
        public String deleteRun(@RequestParam(name="idck") Set<Integer> idck, Model model) {
                userService.deleteUser(idck);
                return "redirect:list";
        }
}