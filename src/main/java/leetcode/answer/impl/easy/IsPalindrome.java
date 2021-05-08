package leetcode.answer.impl.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/06/19 20:47
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;

    }



        public boolean isPathCrossing(String path) {
            Map<Integer,List<Integer>> visitMap = new HashMap<>();
            List<Integer> l1 = new ArrayList<>();
            l1.add(0);
            visitMap.put(0,l1);
            Integer x = 0;
            Integer y = 0;
            int length = path.length();
            for(int i = 0 ;i<length;i++){
                switch (path.charAt(i)){
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }

                List<Integer> value = visitMap.getOrDefault(x,new ArrayList<>());
                if(value.contains(y)){
                    return true;
                }
                value.add(y);
                visitMap.put(x,value);
            }
            return false;
        }


    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPathCrossing("WNSN"));
    }

}
