package stackandqueue;

import java.util.Stack;

/*
 * ����ջʵ�ֶ��У�һ��stackPush,һ��stackPop
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
		else if(stackPop.empty()) {//��stackPushȫ���ƶ���ȥ
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	public int peek() {
		if(this.stackPop.empty()&&this.stackPush.empty())
			throw new RuntimeException("Queue is empty!");
		else if(stackPop.empty()) {//��stackPushȫ���ƶ���ȥ
			while(!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
}

