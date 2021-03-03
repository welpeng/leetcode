package stack;

import java.util.Arrays;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * <p>
 * 示例:
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
 *  
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cwp
 */
public class MinStack_155 {
    /**
     * initialize your data structure here.
     */

    private final static int INIT_SIZE = 16;

    private int[] elements;
    private int min;
    private int size;

    public MinStack_155() {
        elements = new int[INIT_SIZE];
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        ensureCapacity();

        elements[size++] = x;
        if (x < min) {
            min = x;
        }
    }

    private void ensureCapacity() {
        if (size >= elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
    }

    public void pop() {
        int popNum = elements[--size];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            min = Math.min(min, elements[i]);
        }

    }

    public int top() {
        return elements[size - 1];
    }

    public int getMin() {
        return min;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        MinStack_155 minStack_155 = new MinStack_155();
        for (int a = 0 ; a< 18; a++){
            minStack_155.push(a);
        }
        System.out.println(minStack_155.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

