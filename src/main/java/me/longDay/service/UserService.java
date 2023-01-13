package me.longDay.service;

import me.longDay.common.axios.CommonResult;
import me.longDay.pojo.UserInfo;

/**
 * @author 君
 * @version 1.0
 * @desc 用户service业务逻辑层
 * @since 2023/1/13
 */
public interface UserService {
    CommonResult<Object> sendPhoneVerificationCode(UserInfo loginUser);
}
