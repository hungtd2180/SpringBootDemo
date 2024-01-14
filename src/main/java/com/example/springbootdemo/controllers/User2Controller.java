package com.example.springbootdemo.controllers;

import com.example.springbootdemo.models.User;
import com.example.springbootdemo.servies.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class User2Controller {

    @Autowired
    private IUserService userService;

    @GetMapping("/user2")
    public String showUser1(@RequestParam("id") Long id, Model model){
        User user = userService.findById(id).get();
        model.addAttribute("data", user);
        return "index";
    }

    @GetMapping("/user2/{id}")
    public ModelAndView showUser2(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("index");
        User user = userService.findById(id).get();
        mav.addObject("data", user);
        return mav;
    }

    /*
    *ViewResolver sẽ tìm kiếm file index.html trong thư mục /resources/templates và trả về cho người dùng.
    * Nếu không tìm thấy file index.html thì sẽ trả về lỗi 404.
     */
}
