package leetcode.answer.impl.easy;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/07/08 20:08
 */
public class DivingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0){
            return  new int[k];
        }

        int[] res = new int[k+1];
        if(shorter < longer){
            for(int i = 0; i<=k;i++){
                int length = shorter * (k-i) + longer * k;
                res[i] = length;
            }
            return res;
        }

        res[0] = k*shorter;
        return res;

    }
}
