package leetcode.answer.impl.middle;

import java.util.*;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/09/09 11:10
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        int begin = 0;

        dfs(candidates, target, begin, path, result);
        return result;

    }


    private void dfs(int[] candidates, int target, int begin, Deque<Integer> path, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }


        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, result);
            path.removeLast();
        }

    }
}
