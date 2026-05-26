package world.dahua.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Question155 {

    /**
     * num: 155
     * <p>
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * 实现 MinStack 类:
     * <p>
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * <p>
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     * <p>
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     * <p>
     * <p>
     * 提示：
     * <p>
     * -231 <= val <= 231 - 1
     * pop、top 和 getMin 操作总是在 非空栈 上调用
     * push, pop, top, and getMin最多被调用 3 * 104 次
     */
    static void main() {
        long begin = System.currentTimeMillis();
        Question155 question = new Question155();
        question.push(2);
        question.push(0);
        question.push(3);
        question.push(0);
        question.pop();
        System.out.println(question.getMin());
        question.pop();
        System.out.println(question.getMin());
        question.pop();
        System.out.println(question.getMin());
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    private List<Integer> stack;
    private List<Integer> min;
    private int minV = Integer.MAX_VALUE;

    public Question155() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (min.isEmpty()) {
            minV = Integer.MAX_VALUE;
        }
        minV = Math.min(minV, val);
        min.add(0, minV);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        min.remove(0);
        if (!min.isEmpty()) {
            minV = min.get(0);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public Integer getMin() {
        if (min.isEmpty()) {
            return null;
        }
        return min.get(0);
    }
}
