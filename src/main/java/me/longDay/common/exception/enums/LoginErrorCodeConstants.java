package me.longDay.common.exception.enums;

import me.longDay.common.exception.ErrorCode;

/**
 * @author 君
 * @version 1.0
 * @desc 登录相关的 http response 状态码
 * @since 2023/1/13
 */
public interface LoginErrorCodeConstants {
    ErrorCode PHONE_NUMBER_ERROR = new ErrorCode(400,"手机号不正确");
}
