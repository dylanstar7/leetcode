package leetcode.answer.impl.middle;

import leetcode.answer.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/05/13 10:41
 */
public class levelOrder {


    void dfs(TreeNode root, List<List<Integer>> result, int depth){

        //判断退出
        if(root == null){
            return;
        }

        if(result.size() < depth){
            result.add(new ArrayList<>());
        }

        result.get(depth-1).add(root.getVal());
        dfs(root.getLeft(),result,depth+1);
        dfs(root.getRight(),result,depth+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root,result,1);
        return result;

    }


}
