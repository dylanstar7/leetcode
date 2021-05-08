package leetcode.answer.impl.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2021/03/31 11:18
 */
public class SubsetsWithDup {

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return res;
    }

    public void dfs(boolean flag, Integer index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(t));
            return;
        }

        dfs(false, index + 1, nums);
        if (!flag && index > 0 && nums[index] == nums[index - 1]) {
            //与前元素相同
            return;
        }
        t.add(nums[index]);

        dfs(true, index + 1, nums);
        t.remove(t.size() - 1);
    }


}
