package leetcode.answer.impl;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/04/22 17:18
 */
@Slf4j
public class Main {

    public static void main(String[] args) {


        List<String> ips = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();
        ips.add("123");
        ips.add("456");
        ips.add("789");
        weights.add(1);
        weights.add(3);
        weights.add(1);
        Main main = new Main();

        for(int i = 0;i<100;i++){
            String ip = main.getIp(ips,weights);
            System.out.println(ip);
        }

    }


    public String getIp(List<String> ips, List<Integer> weights) {
        List<String> ipWeights = new ArrayList<>();
        for(int i=0;i<ips.size();i++){
            for(int j=0; j<weights.get(i);j++){
                ipWeights.add(ips.get(i));
            }
        }
        int length  = ipWeights.size();
        Random random = new Random();
        int number = random.nextInt(length);
        return ipWeights.get(number);
    }
}
