package leetcode.answer.impl.hard;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/12/24 20:33
 */
public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
//        int[] ratings = new int[]{1, 2, 3, 3, 2, 1};
//        int[] ratings = new int[]{1, 2, 3, 3, 2, 2,3};
        int[] ratings = new int[]{1, 2, 3, 2, 1,3};



        Candy candy = new Candy();
        int candy1 = candy.candy(ratings);
        System.out.println(candy1);
    }
}
