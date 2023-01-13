package me.longDay.controller;

import me.longDay.common.axios.CommonResult;
import me.longDay.pojo.UserInfo;
import me.longDay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 君
 * @version 1.0
 * @desc 用户 controller 层
 * @since 2023/1/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
     private UserService userServiceImpl;
    @PostMapping("/getCodeForPhone")
    CommonResult<Object> sendPhoneVerificationCode(@RequestBody UserInfo loginUser){
        return userServiceImpl.sendPhoneVerificationCode(loginUser);
    }
}
