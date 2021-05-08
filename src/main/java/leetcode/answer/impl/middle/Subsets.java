package leetcode.answer.impl.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2021/03/31 11:55
 */
public class Subsets {

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0);
        return res;
    }

    public void dfs(int[] nums, int index){
        if(index == nums.length){
            res.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[index]);
        dfs(nums,index+1);
        t.remove(t.size()-1);
        dfs(nums,index+1);

    }
}
