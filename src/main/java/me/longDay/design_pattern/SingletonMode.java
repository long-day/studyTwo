package me.longDay.design_pattern;

/**
 * @author 君
 * @version 1.0
 * @desc 单例模式
 * @since 2022-12-17
 */
public class SingletonMode {
    /**
     * 饿汉式
     */
    private static final  SingletonMode instance = new SingletonMode();

    /**
     * 构造函数私有化 保证无法通过正常途径创建对象
     */
    private SingletonMode(){
        System.out.println("单例对象创建");
    }

    /**
     * 获取懒汉式单例对象方法接口
     * @return SingletonMode
     */
    public static SingletonMode getInstanceByHungry(){
        return instance;
    }

    static class SingleInner{
        /**
         * 也不需要示例对象
         */
        private SingleInner(){
            System.out.println("静态内部类单例获取实例已创建");
        }
        /**
         * 创建对象
         */
        public static final  SingletonMode staticInnerClassInstance = new SingletonMode();
    }
    public static SingletonMode getInstanceByStaticInnerClass(){
        return SingleInner.staticInnerClassInstance;
    }


    class CommonInnerClass{
        public static SingletonMode commonInnerClassInstance = new SingletonMode();

    }
    public static SingletonMode getSingletonInstanceByCommonInnerClass(){
        return CommonInnerClass.commonInnerClassInstance;
    }
}
