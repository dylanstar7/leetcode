package leetcode.answer.impl.easy;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lijiakun
 * @date 2020/05/13 23:11
 */
public class numWays {

    public static void main(String[] args) {
        numWays numWays = new numWays();
        System.out.println(numWays.numWays(5));
    }


    public int numWays(int n) {
        // 递归---耗时长
//        if(n == 1){
//            return  1;
//        }
//
//        if(n == 2){
//            return 2;
//        }
//        return numWays(n-1) + numWays(n-2);


        // 记忆化递归
        int[] dp = new int[n+1];
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return  1;
        }

        if(n == 2){
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007 ;
        }
        return dp[n];
    }


}
