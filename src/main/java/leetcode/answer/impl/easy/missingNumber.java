package leetcode.answer.impl.easy;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/05/12 23:38
 */
public class missingNumber {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        for(int i =0;i<length;i++){
            if(nums[i] != i){
                return i;
            }
        }
        return length;
    }
}
