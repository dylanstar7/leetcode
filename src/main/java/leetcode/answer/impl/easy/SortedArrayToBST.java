package leetcode.answer.impl.easy;


import leetcode.answer.model.TreeNode;

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


    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedTree(nums,0,nums.length);
    }



    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int tmp = arr[1]-arr[0];
        for (int i=1;i<length-1;i++){
            if(arr[i+1] - arr[i] != tmp){
                return false;
            }
        }
        return true;


    }


    Random random = new Random();



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

//        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
//        int[] arr = new int[]{3,1,5,6,7,8,2};
//        int findkth = sortedArrayToBST.findKth(arr, 4);
//        System.out.println(findkth);

        Random random = new Random();
        for(int i = 0; i< 100; i++){
            System.out.println(random.nextInt(10));
        }


    }



    public int findkth(int[] arr, int k){
        // 先选择奇数数组出来
        int[] nums = new int[arr.length];
        int number = 0;
        for(int ar: arr){
            if(ar %2 == 1){
                nums[number] = ar;
                number++;
            }
        }
        if(number < k){
            return 0;
        }
        return quickSelect(nums, 0, number,  k);
    }


    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    public int findKth(int[] arr, int k) {

        //筛选奇数数组
        int[] nums = new int[arr.length];
        int number = 0;
        for(int ar: arr){
            if(ar %2 == 1){
                nums[number] = ar;
                number++;
            }
        }
        //判断边界情况
        if(nums.length==0){
            return 0;
        }
        int max=nums[0];
        int min=nums[0];
        //初始化数组
        for (int i = 1; i < number; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[] output = new int[max-min+1];
        //统计计数 数字出现的次数
        for (int i = 0; i < number; i++) {
            output[nums[i]-min]++;
        }
        //筛选出符合条件的值
        int count = 0;
        for (int i = 0; i <= output.length-1; i++) {
            count+=output[i];
            if(count>=k) {
                return i+min;
            }
        }
        //无符合条件，默认返回0
        return 0;
    }





}
