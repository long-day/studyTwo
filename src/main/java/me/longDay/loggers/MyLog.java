package me.longDay.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2022/12/23
 */
public class MyLog {
    private static final Logger log = LoggerFactory.getLogger(MyLog.class);

    public static void main(String[] args) {
        log.debug("Hello world 测试debug日志");
        log.info("Hello world 测试info日志");
        log.warn("Hello world 测试warn日志");
        log.error("Hello world 测试error日志");
    }
}
