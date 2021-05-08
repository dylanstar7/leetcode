package leetcode.answer.impl.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2021/02/02 19:48
 */
public class ShortestToChar {
    public int[] shortestToChar(String S, char C) {
        int length = S.length();
        int[] res = new int[length];
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == C) {
                l1.add(i);
            }
        }


        int tmp = 0;

        int first = l1.get(0);
        int tmp1 = first;
        for (int i = 1; i < l1.size(); i++) {
            //求中值
            int second = l1.get(i);
            int middle = (second + first) / 2;
            for(;tmp<=first;tmp++){
                res[tmp] = tmp1;
                tmp1--;
            }
            tmp1++;
            for(;tmp>first &&tmp <=middle;tmp++){
                tmp1++;
                res[tmp] = tmp1;

            }
            first = second;
        }

        for(;tmp<length;tmp++){
            tmp1++;
            res[tmp] = tmp1;

        }

        return res;

    }

    public static void main(String[] args) {
        ShortestToChar shortestToChar = new ShortestToChar();
        System.out.println(shortestToChar.shortestToChar("loveleetcode",'e'));

    }
}
