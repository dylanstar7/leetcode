package leetcode.answer.impl.middle;

import java.util.*;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/09/10 15:42
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        dfs(candidates,target,0,path,res);
        return res;
    }

    public void dfs(int[] candidates, int target, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = begin; i < candidates.length; i++) {

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates,target-candidates[i],i+1,path,res);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2( new int[]{
                10,1,2,7,6,1,5
        }, 8));
    }
}
