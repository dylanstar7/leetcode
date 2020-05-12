package leetcode.answer.impl.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/05/12 19:52
 */
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        Stack<Integer> stack = this.stack;
        Stack<Integer> minStack = this.minStack;
    }

    public void push(int x) {
        stack.add(x);
        if(!minStack.isEmpty()){
            if(minStack.peek() < x){
                int tmp = minStack.peek();
                minStack.push(tmp);
            }else{
                minStack.push(x);
            }
        }else {
            minStack.push(x);
        }

    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }

    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
