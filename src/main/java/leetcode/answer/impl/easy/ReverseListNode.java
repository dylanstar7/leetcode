package leetcode.answer.impl.easy;

import leetcode.answer.model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/04/20 22:14
 */
public class ReverseListNode {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack();
        int count = 0;
        while (head != null) {
            stack.push(head.getVal());
            head = head.getNext();
            count++;
        }
        int[] number = new int[1];
        int i = 0;
        while (!stack.isEmpty()) {
            number[i] = stack.pop();
            i++;
        }
        return number;
    }


    public static void main(String[] args) {
        ReverseListNode reverseListNode = new ReverseListNode();
    }


    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        int number = 1;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            number++;
        }
        return number;
    }


    // 空格替换
    public String replaceSpace(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }
        StringBuffer s1 = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                s1.append("%20");
            } else {
                s1.append(s.charAt(i));
            }
        }

        return String.valueOf(s1);
    }

    //字符重排
    public boolean CheckPermutation(String s1, String s2) {
        int i = s1.length();
        int j = s2.length();
        if (i != j) {
            return false;
        }
        int[] count = new int[26];
        for(int m = 0; m<i;m++){
            count[s1.charAt(m) -'a']++;
        }
        for(int n=0;n<j;n++){
            count[s2.charAt(n) -'a']--;
        }
        for(int x =0; x< 26;x++){
            if(count[x] != 0){
                return false;
            }
        }
        return true;

    }

    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            //方法1
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }






}
