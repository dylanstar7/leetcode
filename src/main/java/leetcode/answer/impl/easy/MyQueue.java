package leetcode.answer.impl.easy;

import com.sun.imageio.plugins.common.I18N;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/04/23 09:42
 */
class MyQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Integer tmp = q2.poll();
        while (! q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return tmp;
    }

    /** Get the front element. */
    public int peek() {
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Integer tmp = q2.peek();
        while (! q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return tmp;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (q1.isEmpty()){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
//        MyQueue myQueue = new  MyQueue();
//        int duplicate = myQueue.findDuplicate(new int[]{1, 3, 4, 3, 2, 7, 5, 3});
//        System.out.println(duplicate);
    }


    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;

    }


//    public int subarraysDivByK(int[] A, int K) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
