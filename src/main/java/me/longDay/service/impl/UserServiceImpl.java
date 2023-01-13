package me.longDay.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import lombok.extern.slf4j.Slf4j;
import me.longDay.common.axios.CommonResult;
import me.longDay.common.enums.RedisEnums;
import me.longDay.common.exception.enums.LoginErrorCodeConstants;
import me.longDay.common.verification.RegexEnum;
import me.longDay.pojo.UserInfo;
import me.longDay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 君
 * @version 1.0
 * @desc 用户service层
 * @since 2023/1/13
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public CommonResult<Object> sendPhoneVerificationCode(UserInfo loginUser) {
        // 校验手机号
        if (!ReUtil.isMatch(RegexEnum.PHONE_NUMBER_REGEX,loginUser.getPhoneNumber())){
            return CommonResult.error(LoginErrorCodeConstants.PHONE_NUMBER_ERROR);
        }

        //生成手机验证码
        String phoneVerificationCode = RandomUtil.randomNumbers(6);

        //保存到redis
        stringRedisTemplate.opsForValue()
                .set(RedisEnums.KEY_PREFIX_PHONE_VERIFICATION_CODE+loginUser.getPhoneNumber(),
                        phoneVerificationCode,
                        RedisEnums.PHONE_VERIFICATION_CODE_AVAILABLE_TIME);

        //模拟发送
        log.warn("手机号 = {} 的验证码 = {}",loginUser.getPhoneNumber(),phoneVerificationCode);
        return CommonResult.success(phoneVerificationCode);
    }
}
