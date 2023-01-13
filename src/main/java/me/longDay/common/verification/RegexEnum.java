package me.longDay.common.verification;

/**
 * @author 君
 * @version 1.0
 * @desc 正则表达式的常量枚举
 * @since 2023/1/13
 */
public class RegexEnum {
    /**
     * 验证手机号的正则规则
     */
    public static final String PHONE_NUMBER_REGEX = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
}
