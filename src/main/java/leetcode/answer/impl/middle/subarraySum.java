package leetcode.answer.impl.middle;

import leetcode.answer.model.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 解题思路：hash表存储前缀和为sum的次数
 *
 * @author lijiakun
 * @date 2020/05/15 00:07
 */
public class subarraySum {

    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        if (length < 1) {
            return 0;
        }
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return  count;
    }


    public static void main(String[] args) {
        subarraySum subarraySum = new subarraySum();
//        TreeNode node = new TreeNode();
//        TreeNode l1 = new TreeNode();
//        TreeNode l2 = new TreeNode();
//        l2.setVal(5);
//        l1.setLeft(l2);
//        l1.setVal(4);
//        node.setLeft(l1);
//        node.setVal(3);
//        [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
        List<List<String>> s1 = new ArrayList<>();
        List<String> a1 = new ArrayList<>();
        a1.add("leetcode");
        a1.add("google");
        a1.add("facebook");
        s1.add(a1);
        List<String> a2 = new ArrayList<>();
        a2.add("google");
        a2.add("microsoft");
        s1.add(a2);
        List<String> a3 = new ArrayList<>();
        a3.add("google");
        a3.add("facebook");
        s1.add(a3);
        List<String> a4 = new ArrayList<>();
        a4.add("google");
        s1.add(a4);
        List<String> a5 = new ArrayList<>();
        a5.add("amazon");
        s1.add(a5);
        System.out.println(subarraySum.peopleIndexes(s1));
    }
    public int maxPower(String s) {
        int length = s.length();
        int count = 1;
        int num = 1;
        char c = s.charAt(0);
        for(int i = 0; i< length; i++){
            if(s.charAt(i) == c){
                num++;
            }else {
                count = Math.max(count,num);
                num = 1;
                c = s.charAt(i);
            }
        }
        return count;
    }


    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        //判断两个数的最大公约数是1
        for(int i = 1; i<n;i++){
            for(int j = i+1;j<=n;j++){
                if(gcd(i,j) == 1){
                    result.add(i+"/"+j);
                }
            }
        }
        return result;
    }


    public int gcd(int a,int b)
    {
        int r;
        while(b>0)
        {
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }


    public int goodNodes(TreeNode root) {
        int number = 0;
        int max = Integer.MIN_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        count(root,number,max,res);
        return res.size();
    }

    void count(TreeNode root, int num, int max, List<List<Integer>> res){
        List<Integer> list = new ArrayList<>();
        if(root!= null && root.getVal() > max){
            list.add(root.getVal());
            res.add(new ArrayList<>(list));
            max = root.getVal();
        }
        if(root.getLeft()!= null){
            count(root.getLeft(),num,max, res);
        }
        if(root.getRight()!= null){
            count(root.getRight(),num,max,res);
        }
    }




    public String arrangeWords(String text) {
        List<String> word = Arrays.asList(text.split(" "));
        int length = word.size();
        List<List<String>> words = new ArrayList<>();

        int max = 0;
        for(String wo: word){
            if(wo.length() > max){
                max = wo.length();
            }
        }

        for(int x = 0;  x <= max; x++){
            words.add(new ArrayList<>());
        }

        for(int i =0;i<length;i++){
            String s = word.get(i).toLowerCase();
            int size = s.length();
            words.get(size).add(s);
        }

        int number = 0;
        StringBuffer sb = new StringBuffer();
        for(List<String> list : words){
            for(String s: list){
                if(number == 0){
                    // 首字母大写
                    s = s.substring(0, 1).toUpperCase() + s.substring(1);
                    sb.append(s).append(" ");
                }else {
                    sb.append(s);
                    if(number < length-1){
                        sb.append(" ");
                    }
                }
                number++;
            }
        }

        return sb.toString();

    }


    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int length = favoriteCompanies.size();
        List<Integer> res = new ArrayList<>();

        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int m = 0; m<length;m++){
            map.put(m, true);
        }
        for(int i = 0; i<length-1;i++){
            for(int j = i+1;j<length;j++){
               List<String> s1 = favoriteCompanies.get(i);
               List<String> s2 = favoriteCompanies.get(j);
               List<String> t1 = new ArrayList<>(s1);
               List<String> t2 = new ArrayList<>(s2);
               List<String> t3 = new ArrayList<>(s1);
               List<String> t4 = new ArrayList<>(s2);
               t1.removeAll(t2);
               t4.removeAll(t3);
               if(t1.size() == 0){
                   map.put(i,false);
                   break;
               }
               if(t4.size() == 0){
                   map.put(j,false);
               }
            }
        }

        for(int n = 0; n<length;n++){
            if(map.get(n)){
                res.add(n);
            }
        }

        return res;
    }

}
