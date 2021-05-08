package leetcode.answer.impl;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

/**
 * TODO
 *  输入String[] strs, String str
 *
 * @author lijiakun
 * @date 2021/04/08 18:34
 */
public class TestClass {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        int[] nums1 = new int[]{0,1,2,3,4};
        int[] nums2 = new int[]{1,2,3,4,5};
        List<Integer> result = testClass.getResult(nums1, nums2, new ArrayList<>());
        System.out.println(result);

    }

    public List<Integer> getResult(int[] nums1, int[] nums2,List<Integer> res){
        int length1 = nums1.length;
        int length2 = nums2.length;
        int i=0;
        int j =0;
        for(; i<length1 && j<length2;){
            if(nums1[i] < nums2[j]){
                res.add(nums1[i]);
                i++;
            }else {
                res.add(nums2[j]);
                j++;
            }
        }

        while (i<length1){
            res.add(nums1[i]);
            i++;
        }
        while (j<length2){
            res.add(nums2[j]);
            j++;
        }

        return res;
    }


}
