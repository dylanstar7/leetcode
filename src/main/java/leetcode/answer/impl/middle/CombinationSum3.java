package leetcode.answer.impl.middle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/09/11 16:11
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        dfs(k,n,1,path,res,n);
        return res;
    }

    public void dfs(int k, int n, int begin, Deque<Integer> path, List<List<Integer>> res, int target) {
        if(k<0 || n<0){
            return;
        }

        if(n==0 && k==0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i =begin;i<target;i++){
            path.addLast(i);
            dfs(k-1,n-i,i+1,path,res,target);
            path.removeLast();
        }
    }
}
