package stackandqueue;

import java.util.Stack;

/*
 * 两个栈实现队列，一个stackPush,一个stackPop
 */
public class TwoStacksQueue {
	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	public TwoStacksQueue() {
		stackPush=new Stack<Integer>();
		stackPop=new Stack<Integer>();
	}
	public void add(int num) {
		this.stackPush.push(num);
	}
	public int poll() {
		if(this.stackPop.empty()&&this.stackPush.empty())
			throw new RuntimeException("Queue is empty!");
		else if(stackPop.empty()) {//将stackPush全部移动过去
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	public int peek() {
		if(this.stackPop.empty()&&this.stackPush.empty())
			throw new RuntimeException("Queue is empty!");
		else if(stackPop.empty()) {//将stackPush全部移动过去
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
}

