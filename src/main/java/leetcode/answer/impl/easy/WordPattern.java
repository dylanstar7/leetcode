package leetcode.answer.impl.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/12/16 20:26
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> wordMap = new HashMap();
        Map<String, Character> wordMap1 = new HashMap();
        List<String> words = Arrays.stream(s.split(" ")).collect(Collectors.toList());
        int length = pattern.length();
        for (int i = 0; i < length; i++) {
            char c = pattern.charAt(i);
            String s1 = wordMap.get(c);
            String s2 = words.get(i);
            Character s3 = wordMap1.get(s2);
            if((!Objects.isNull(s3)) && c == s3){
                return false;
            }

            if (Objects.isNull(s1) || "".equals(s1) ) {

                wordMap.put(c, s2);
                wordMap1.put(s2,c);
            } else {
                if (!s1.equals(s2)) {
                    return false;
                }
            }


        }

        return true;

    }
}
