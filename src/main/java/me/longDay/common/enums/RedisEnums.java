package me.longDay.common.enums;

import java.time.Duration;

/**
 * @author 君
 * @version 1.0
 * @desc
 * @since 2023/1/13
 */
public interface RedisEnums {
    /**
     * 用于区分业务的 redis key 前缀
     * 登录手机验证码
     */
    String KEY_PREFIX_PHONE_VERIFICATION_CODE = "login:phone:code:";

    /**
     * 手机验证码过期时间: 5分钟
     */
    Duration PHONE_VERIFICATION_CODE_AVAILABLE_TIME = Duration.ofMinutes(5);
}
