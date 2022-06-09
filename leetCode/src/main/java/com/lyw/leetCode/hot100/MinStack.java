package com.lyw.leetCode.hot100;
//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// Implement the MinStack class: 
//
// 
// MinStack() initializes the stack object. 
// void push(int val) pushes the element val onto the stack. 
// void pop() removes the element on the top of the stack. 
// int top() gets the top element of the stack. 
// int getMin() retrieves the minimum element in the stack. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
// 
// Constraints: 
//
// 
// -231 <= val <= 231 - 1 
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks. 
// At most 3 * 104 calls will be made to push, pop, top, and getMin. 
// 
// Related Topics Stack Design 
// 👍 7599 👎 599

import java.util.Stack;

/**
  * questionId：155
  * question：Min Stack
  * date：2022-03-23 11:37:36
*/
public class MinStack {
    public static void main(String[] args) {
        //Solution solution = new MinStack().new Solution();
        System.out.println("Hello world");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStackWithTwoStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStackWithTwoStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
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


class MinStackWithOneStack {

    Stack<Integer> stack = new Stack<>();
    //min初始化为最大的int值
    int min = Integer.MAX_VALUE;

    public MinStackWithOneStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

} 
