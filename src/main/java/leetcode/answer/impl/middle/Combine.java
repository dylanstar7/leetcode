package leetcode.answer.impl.middle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/09/08 11:37
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, result);
        return result;
    }


    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> result) {

        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }


        for(int i = begin; i <=n; i++){
            path.addLast(i);
            dfs(n,k,i+1,path,result);
            path.removeLast();
        }

    }


    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4,2));
    }
}
