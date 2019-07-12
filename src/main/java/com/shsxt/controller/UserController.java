package com.shsxt.controller;


import com.shsxt.exception.BusinessException;
import com.shsxt.po.User;
import com.shsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "queryUserById", method = RequestMethod.POST)
    @ResponseBody
    public User queryUserById(Integer id) throws Exception {
        return userService.queryById(id);
    }

    @RequestMapping(value = "queryUserById2/{id}")
    @ResponseBody
    public User queryUserById2(@PathVariable Integer id) throws Exception {
       // int i = 1/0;

        if(true){
            throw new BusinessException("业务异常");
        }

        return userService.queryById(id);
    }

    // 传1，2个参数
    @RequestMapping(value = "test/{id}/{name}")
    @ResponseBody
    public String test(@PathVariable Integer id, @PathVariable String name){
        return id + " - " + name;
    }
}
