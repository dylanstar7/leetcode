package leetcode.answer.impl.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 * <p>
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lijiakun
 * @date 2021/02/22 19:36
 */
public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> lastMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer number = numberMap.getOrDefault(num, 0);
            number++;
            numberMap.put(num, number);

            if (!firstMap.keySet().contains(num)) {
                firstMap.put(num, i);
            }
            lastMap.put(num, i);
        }

        int max = 0;
        int findNumber;
        int length = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : numberMap.entrySet()) {
            if (integerIntegerEntry.getValue() == max) {
                max = integerIntegerEntry.getValue();
                findNumber = integerIntegerEntry.getKey();
                int  length1 = lastMap.get(findNumber) - firstMap.get(findNumber)+1;
                length = Math.min(length, length1);
            }else if (integerIntegerEntry.getValue() >max) {
                max = integerIntegerEntry.getValue();
                findNumber = integerIntegerEntry.getKey();
                length = lastMap.get(findNumber) - firstMap.get(findNumber)+1;
            }
        }


        return length;


    }

    public static void main(String[] args) {
        FindShortestSubArray array = new FindShortestSubArray();
        int[] nums = new int[]{1,2,2,3,1,4,2};
        System.out.println(array.findShortestSubArray(nums));
    }
}
