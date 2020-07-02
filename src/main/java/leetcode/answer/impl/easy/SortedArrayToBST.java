package leetcode.answer.impl.easy;


import leetcode.answer.model.TreeNode;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author lijiakun
 * @date 2020/04/20 19:28
 */
public class SortedArrayToBST {


    public TreeNode sortedTree(int[] nums, int left, int right) {
        if (left > right || nums == null || nums.length == 0) {
            return null;
        }

        int middle = (left + right) / 2;
        //选取数组居中节点作为根结点--奇数长度
        TreeNode node = new TreeNode();
        node.setVal(nums[middle]);

        node.setLeft(sortedTree(nums, left, middle - 1));
        node.setRight(sortedTree(nums, middle + 1, right));
        return node;
    }


    public static void main(String[] args) {



//        System.out.println(LocalDateTime.of(2020,1,1,12,0,0).compareTo(LocalDateTime.of(2020,1,1,0,0,0)));
//        List<List<Long>> res = new ArrayList<>();
//        Map<Long, Long> numberMap = new HashMap<>();
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            List<Long> result = new ArrayList<>();
//            for (int j = 0; j < 7; j++) {
//                long nextLong = (long) random.nextInt(36) + 1;
//                Long orDefault = numberMap.getOrDefault(nextLong, 0L);
//                numberMap.put(nextLong, orDefault + 1);
//                result.add(nextLong);
//            }
//            res.add(result);
//        }
//        System.out.println(res);
//        System.out.println(numberMap);
    }
}
