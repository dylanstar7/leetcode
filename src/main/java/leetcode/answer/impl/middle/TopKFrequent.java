package leetcode.answer.impl.middle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/09/07 20:06
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> resultMap = new HashMap();
        int[] result = new int[k];

        for (int num : nums) {
            Integer number = resultMap.getOrDefault(num, 0) +1;
            resultMap.put(num,number);

        }

        List<Integer> integers = resultMap.values().stream().map(e -> Integer.valueOf(e)).collect(Collectors.toList());
        int[] integerArray = new int[integers.size()];
        for(int i = 0;i< integers.size();i++){
            integerArray[i] = integers.get(i);
        }

        Arrays.sort(integerArray);
        int rsu = integerArray[integers.size()-k];


        int i = 0;
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            if(entry.getValue() > rsu){
                result[i] = entry.getKey();
            }
        }

        return  result;
    }


}


