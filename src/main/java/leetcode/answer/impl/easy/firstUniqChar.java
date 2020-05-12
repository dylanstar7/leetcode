package leetcode.answer.impl.easy;

import java.util.*;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/05/12 22:23
 */
public class firstUniqChar {

    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc){
            dic.put(c, !dic.containsKey(c));
        }

        for(char c : sc){
            if(dic.get(c)){
                return c;
            }
        }

        return ' ';

    }
}
