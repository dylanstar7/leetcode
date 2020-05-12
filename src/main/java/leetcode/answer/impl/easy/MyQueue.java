package leetcode.answer.impl.easy;

import com.sun.imageio.plugins.common.I18N;

import java.util.LinkedList;
import java.util.Queue;

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
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
