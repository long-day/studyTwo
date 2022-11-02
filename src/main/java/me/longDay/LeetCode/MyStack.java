package me.longDay.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2022-10-28
 */
public class MyStack {

    private final Deque<Integer> deque;

    public MyStack() {
        deque = new ArrayDeque<>();
    }

    public void push(int x) {
        deque.push(x);
    }

    public int pop() {
        return deque.remove();
    }

    public int top() {
        return deque.getFirst();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}
