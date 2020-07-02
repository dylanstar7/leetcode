package leetcode.answer.impl.easy;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lijiakun
 * @date 2020/05/14 10:39
 */
public class singleNumber {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Integer[] nums = new Integer[10000000];

        for(int i = 0; i<10000000;i++){
            nums[i] = i;
        }

        List<Integer> num = new ArrayList<Integer>(Arrays.asList(nums));
        Stream<Integer> stream = num.stream();
        if(true){
            stream = stream.filter(e -> e != 1 );
        }
        if(true){
            stream = stream.filter(e -> e %2 != 0 );
        }


        List<Integer> collect = stream.collect(Collectors.toList());

//        List<Integer> list = new ArrayList<>();
//        for(Integer n:num){
//            if(true && n != 1){
//                list.add(n);
//            }
//
//            if(true && n %2 !=0 ){
//                list.add(n);
//            }
//        }

        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());

//        System.out.println(collect);

    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
