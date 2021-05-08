package leetcode.answer.impl.easy;

/**
 * 除数博弈
 * <p>
 * <p>
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divisor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 *
 * @author lijiakun
 * @date 2020/07/24 17:35
 */
public class DivisorGame {

    public boolean divisorGame(int N) {
        Boolean[] dp = new Boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        int i = 3;
        while (i <= N) {
            //判断可整除i的分子是否为false，如果存在一个false，则i为true;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && dp[i-j] == false) {
                    dp[i] = true;
                    break;
                }
                dp[i] = false;
            }
            i++;
        }

        return dp[N];
    }


    public static void main(String[] args) {
        DivisorGame divisorGame = new DivisorGame();
        System.out.println(divisorGame.divisorGame(2));
        System.out.println(divisorGame.divisorGame(3));
        System.out.println(divisorGame.divisorGame(4));
        System.out.println(divisorGame.divisorGame(1000));

    }
}
