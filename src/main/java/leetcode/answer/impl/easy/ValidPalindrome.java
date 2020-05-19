package leetcode.answer.impl.easy;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * @author lijiakun
 * @date 2020/05/19 10:41
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public boolean validPalindrome(String s) {
        int length = s.length();
        int i = 0;
        int j = length - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                Boolean flag1 = true, flag2 = true;
                for (int low = i + 1, high = j; low < high; low++, high--) {
                    if (s.charAt(low) != s.charAt(high)) {
                        flag1 = false;
                        break;
                    }
                }

                for (int low = i, high = j - 1; low < high; low++, high--) {
                    if (s.charAt(low) != s.charAt(high)) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }

        return true;
    }
}
