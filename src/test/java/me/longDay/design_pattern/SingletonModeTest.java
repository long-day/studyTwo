package me.longDay.design_pattern;

import org.junit.jupiter.api.Test;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2022-12-17
 */
public class SingletonModeTest {
    @Test
    void staticInnerClassTest(){
        System.out.println("---- 饿汉式 ----");
        SingletonMode instance = SingletonMode.getInstanceByHungry();
        System.out.println(instance.hashCode());

        System.out.println("---- 静态内部类式 ----");
        SingletonMode staticInnerClassSingletonInstance = SingletonMode.getInstanceByStaticInnerClass();
        System.out.println(staticInnerClassSingletonInstance.hashCode());
        System.out.println("---- 非静态内部类式 ----");
        SingletonMode singletonInstanceByCommonInnerClass = SingletonMode.getSingletonInstanceByCommonInnerClass();
        System.out.println(singletonInstanceByCommonInnerClass.hashCode());
    }
}
