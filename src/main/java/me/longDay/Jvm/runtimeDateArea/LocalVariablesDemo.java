package me.longDay.Jvm.runtimeDateArea;

import java.time.LocalDate;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2022-10-29
 */
public class LocalVariablesDemo {
    public static void main(String[] args) {
        LocalVariablesDemo demo = new LocalVariablesDemo();
        System.out.println(demo);
        int num = 2;
        System.out.println(num);
    }
    public static void testStatic(){
        int k = 2;
        double d = 3.0;
        LocalDate now = LocalDate.now();

        System.out.println(k+" "+d+" "+now);
    }

    public void comLocalAndClassVariable(){

    }
}
