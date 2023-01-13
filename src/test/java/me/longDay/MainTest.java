package me.longDay;

import me.longDay.LeetCode.MyStack;
import me.longDay.LeetCode.Solution;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2022-10-27
 */
public class MainTest {
    public static final Logger log = LoggerFactory.getLogger(MainTest.class);
    /**
     * 力扣 13 罗马数字转整数
     */
    @Test
    public void romanToInt(){
        Solution solution = new Solution();
        int res = solution.romanToInt("MCMXCIV");
        System.out.println(res);
    }

    /**
     * 力扣
     */
    @Test
    public void removeElement(){
        int[] nums = new int[]{2};
        Solution solution = new Solution();
        int len = solution.removeElement(nums, 3);

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    /**
     * 225
     */
    @Test
    public void myStack(){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False

    }

    /**
     * 力扣 15
     */
    @Test
    public void threeSumTest(){
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }

    /**
     * 力扣 6
     */
    @Test
    public void convertTest(){
        Solution solution = new Solution();
        String convert = solution.convert("PAYPALISHIRING",3);
        System.out.println(convert);
    }
    /**
     * 剑指offer03
     */
    @Test
    public void findRepeatNumber(){
        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    /**
     * 力扣56
     */
    @Test
    public void mergeTest() {
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(nums)));
    }

    @Test
    void other(){
        String name = "hello";
        log.info("这是一个{}测试",name);
    }

}
