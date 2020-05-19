package leetcode.answer.impl.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * @author lijiakun
 * @date 2020/05/18 19:25
 */
public class MaxProduct {


    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();

        System.out.println(maxProduct.maxProduct(new int[]{1, -2, 3, -4, 5, -6, 0, -7, 8, 9, 10}));
    }

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int min_temp = 1;
        int max_temp = 1;

        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                int tmp = max_temp;
                max_temp = min_temp;
                min_temp = tmp;
            }
//            if(nums[i] == 0){
//                max_temp = 1;
//                min_temp = 1;
//                max = Math.max(max , 0);
//                continue;
//            }

            min_temp = Math.min(nums[i] * min_temp, nums[i]);
            max_temp = Math.max(nums[i] * max_temp, nums[i]);
            max = Math.max(max, max_temp);
        }

        List<Integer> res = new ArrayList<>();
        res.stream().mapToInt(Integer::intValue).toArray();

        return max;

    }
}
