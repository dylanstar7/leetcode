package leetcode.answer.impl.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/05/08 22:37
 */
public class MergeTwoSortedNums {



    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 2};
        int[] nums2 = new int[]{1, 2};
        MergeTwoSortedNums mergeTwoSortedNums = new MergeTwoSortedNums();
//        mergeTwoSortedNums.buildArray(nums1, 5);
        mergeTwoSortedNums.myPow(2.0, 10);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0)) {
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }


        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        System.out.println(Arrays.toString(nums1));
    }


    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int tmp = String.valueOf(num).length() % 2 == 0 ? 1 : 0;
            res += tmp;
        }
        return res;
    }

    public boolean isUnique(String astr) {
        for (char ch : astr.toCharArray()) {
            if (astr.indexOf(ch) != astr.lastIndexOf(ch)) {
                return false;
            }
        }
        return true;
    }


    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int length = target.length;
        int j = 1;
        for (int i = 0; i < length; i++) {

            while (target[i] != j) {
                res.add("Push");
                res.add("Pop");
                j++;
            }
            res.add("Push");
            j++;
        }
        System.out.println(res);
        return res;
    }


    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Set<int[]> edgeList = new HashSet<>();
        Set<Integer> numer = new HashSet<>();
        int length = edges.length;
        for(int i =n;i>0;i--){
            if(hasApple.get(i) == true){
                if(i == 0){
                    //无需操作
                }else{
                    for(int j = 0; j< n; j++){
                        if(edges[j][1] == i){
                           hasApple.set(edges[j][0],true);
                           edgeList.add(edges[j]);
                        }
                    }

                }
            }
        }

        return edgeList.size()*2;
    }


//    public int countTriplets(int[] arr) {
//        int length = arr.length;
//        int i = 0, j=1,k=1;
//        while(k<length){
//            if(arr[i])
//        }
//    }


    public int lengthOfLongestSubstring(String s) {

        Set<Character> oc = new HashSet<>();
        int n = s.length();
        int rk = 0, res =0;
        for(int i = 0; i< n; i++){
            if(n != 0){
                oc.remove(s.charAt(i-1));
            }
            while(rk<n && !oc.contains(s.charAt(rk))){
                oc.add(s.charAt(rk));
                rk++;
            }
            res = Math.max(res, rk-i);
        }

        return res;
    }

    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c: S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i){
                    ans.get(i).append(c);
                }

            }
        }


        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans){
            finalans.add(sb.toString());
        }

        return finalans;
    }



     void dfs(int[] nums, Set<List<Integer>> result, List<Integer> list, int[] visited ){
        //当全部数字都用上之后退出
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0;i< nums.length;i++){
            int tmp = nums[i];
            if(visited[i] == 0){
                list.add(tmp);
                visited[i] = 1;
                dfs(nums,result,list,visited);
                visited[i] = 0;
                list.remove(list.size()-1);

            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int[] visited  = new int[nums.length];


        dfs(nums,result,list,visited);
        System.out.println(result);
        return new ArrayList<>(result);
    }

//    public void backtrack(int n,
//                          ArrayList<Integer> output,
//                          List<List<Integer>> res,
//                          int first) {
//        // 所有数都填完了
//        if (first == n)
//            res.add(new ArrayList<Integer>(output));
//        for (int i = first; i < n; i++) {
//            // 动态维护数组
//            Collections.swap(output, first, i);
//            // 继续递归填下一个数
//            backtrack(n, output, res, first + 1);
//            // 撤销操作
//            Collections.swap(output, first, i);
//        }
//    }
//
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new LinkedList();
//
//        ArrayList<Integer> output = new ArrayList<Integer>();
//        for (int num : nums)
//            output.add(num);
//
//        int n = nums.length;
//        backtrack(n, output, res, 0);
//        System.out.println(res);
//        return res;
//    }


    public double myPow(double x, int n) {
        int temp=n;
        double ans=1;
        while(n!=0){
            if((n&1)!=0){//和1与取末尾
                ans*=x;
            }
            x*=x;
            n/=2;//相当于数字右移，每次取新的位做末位
        }
        return temp>=0?ans:1/ans;
    }

}
