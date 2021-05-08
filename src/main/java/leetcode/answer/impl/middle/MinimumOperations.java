package leetcode.answer.impl.middle;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/10/26 17:53
 */
public class MinimumOperations {
    public int minimumOperations(String leaves) {
        int number = 0;
        if (leaves.length() == 0){
            return  number;
        }


        int a = 0;
        int b = leaves.length();
        while (leaves.charAt(a) != 'y'){
           a += a;
        }

        while (leaves.charAt(b) != 'y'){
            b -= b;
        }

        for(int x = a; x<=b; x++){
            if(leaves.charAt(x) == 'y'){
                number++;
            }
        }
        return number;
    }
}
