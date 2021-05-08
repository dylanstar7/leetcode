package leetcode.answer.impl.easy;

import leetcode.answer.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/09/14 10:46
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList();
        Map<Integer, List<Integer>> map = new HashMap();

        dfs(root, 0, map);

        List<Double> doubleList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            double sum = 0;
            for (Integer integer : value) {
                sum += integer;
            }
            doubleList.add( ((double) sum / (double)value.size()));
        }

        return doubleList;


    }

    public void dfs(TreeNode root, int begin, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }

        List<Integer> list = map.getOrDefault(begin, new ArrayList());
        list.add(root.getVal());
        map.put(begin,list);
        dfs(root.getLeft(), begin + 1, map);
        dfs(root.getRight(),begin+1,map);

    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        node.setVal(2147483647);
        node1.setVal(2147483647);
        node2.setVal(2147483647);
        node.setRight(node1);
        node.setLeft(node2);

        AverageOfLevels levels = new AverageOfLevels();
        System.out.println(levels.averageOfLevels(node));
    }
}
