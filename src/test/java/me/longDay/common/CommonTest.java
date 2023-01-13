package me.longDay.common;

import cn.hutool.core.util.ReUtil;
import lombok.extern.slf4j.Slf4j;
import me.longDay.common.verification.RegexEnum;
import org.junit.jupiter.api.Test;

/**
 * @author 君
 * @version 1.0
 * @desc 普通测试类
 * @since 2023/1/13
 */
@Slf4j
public class CommonTest {
    @Test
    void phone_number_regex_test(){
        String reallyPhoneNumber = "18738035303";
        String lessThan11 = "1873803530";
        String moreThan11 = "187380353031";
        String notAllNumber = "187380a5303";
        //这里只验证中国手机号

        // 正确手机号
        log.info("正确手机号验证结果 返回值={}", ReUtil.isMatch(RegexEnum.PHONE_NUMBER_REGEX,reallyPhoneNumber));
        // 错误手机号  少于11位
        log.info("错误手机号  少于11位 返回值={}", ReUtil.isMatch(RegexEnum.PHONE_NUMBER_REGEX,lessThan11));
        // 错误手机号  多余11位
        log.info("错误手机号  多余11位 返回值={}", ReUtil.isMatch(RegexEnum.PHONE_NUMBER_REGEX,moreThan11));
        // 错误手机号  含有非数字
        log.info("错误手机号  含有非数字 返回值={}", ReUtil.isMatch(RegexEnum.PHONE_NUMBER_REGEX,notAllNumber));


    }
}
