package me.longDay.LeetCode;

import java.util.*;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        int fastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[fastIndex] != val) {
                Utils.swap(nums, slowIndex, fastIndex);
                fastIndex++;
                slowIndex++;
            } else {
                fastIndex++;
            }
        }
        return slowIndex;
    }

    public int romanToInt(String s) {
        int res = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("I",1);
        hashMap.put("V", 5);
//        hashMap.put("X",10);
        hashMap.put("L", 50);
//        hashMap.put("C",100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            char nextChar;
            if (i + 1 != s.length()) {
                nextChar = s.charAt(i + 1);
            } else {
                nextChar = '0';
            }

            switch (curChar) {
                case 'I': {
                    if (nextChar == 'V') {
                        res += 4;
                        i++;
                    } else if (nextChar == 'X') {
                        res += 9;
                        i++;
                    } else {
                        res += 1;
                    }
                }
                break;
                case 'X': {
                    if (nextChar == 'L') {
                        res += 40;
                        i++;
                    } else if (nextChar == 'C') {
                        res += 90;
                        i++;
                    } else {
                        res += 10;
                    }
                }
                break;
                case 'C': {
                    if (nextChar == 'D') {
                        res += 400;
                        i++;
                    } else if (nextChar == 'M') {
                        res += 900;
                        i++;
                    } else {
                        res += 100;
                    }
                }
                break;
                default: {
                    Integer num = hashMap.get(String.valueOf(curChar));
                    res += num;
                }
            }
        }

        return res;
    }

    public int romanToInt2(String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        int sum = 0;
        int preNum = hashMap.get(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            int num = hashMap.get(String.valueOf(s.charAt(i)));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else { // sum > 0
                    R--;
                }
            }
        }
        return res;
    }

    /**
     * 力扣 6
     *
     * @return #
     */
    public String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        ArrayList<StringBuilder> bufferLists = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            bufferLists.add(new StringBuilder());
        }
        int ptrToBufferLists = 0;
        int isPositiveCycle = -1;
        for (char ch : s.toCharArray()) {
            bufferLists.get(ptrToBufferLists).append(ch);
            if (ptrToBufferLists == 0 || ptrToBufferLists == numRows - 1) {
                isPositiveCycle = -isPositiveCycle;
            }
            ptrToBufferLists += isPositiveCycle;
        }
        StringBuilder res = new StringBuilder();
        bufferLists.forEach(res::append);

        return res.toString();
    }

    /**
     * 力扣 剑指offer03
     */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        int i;
        for ( i = 0; i < nums.length; i++) {
            if(map.contains(nums[i])){
                break;
            }else {
                map.add(nums[i]);
            }
        }
        return nums[i];
    }
}