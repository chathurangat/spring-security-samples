package com.chathurangaonline.samples;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @ResponseBody
    @RequestMapping(value = {"/","home"})
    private String allUsersHome(){

        return "this section will be displayed for all users";
    }

    @ResponseBody
    @RequestMapping(value = {"/user"})
    private String userHome(){
        return "this section will be displayed for users with role USER";
    }

    @ResponseBody
    @RequestMapping(value = {"/admin"})
    private String adminUserHome(){
        return "this section will be displayed for users with role ADMIN ";
    }

    @ResponseBody
    @RequestMapping(value = {"/super-user"})
    private String superUserHome(){
        return "this section will be displayed for users with roles USER + ADMIN";
    }

    @ResponseBody
    @RequestMapping(value = {"/access_denied"})
    private ModelAndView accessDeniedPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("access_denied_page");
        return modelAndView;
    }
}

