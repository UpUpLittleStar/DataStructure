package stackandqueue;

import java.util.Stack;

/*
 * ʵ�ַ���ջ�е���СԪ��,ʱ�临�Ӷ�O(1),�ռ临�Ӷ�O(n)
 */
public class MyStack2 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public MyStack2() {
		this.stackData=new Stack<Integer>();
		this.stackMin=new Stack<Integer>();
	}
	public void push(int newNum) {
		if(this.stackMin.isEmpty())
			this.stackMin.push(newNum);
		else if(newNum<this.getmin())
			this.stackMin.push(newNum);
		else {
			int newMin=this.stackMin.peek();
			this.stackMin.push(newMin);
		}
			this.stackData.push(newNum);
	}
	public int pop() {
		if(this.stackData.isEmpty())
			throw new RuntimeException("The stack is Empty!");
		this.stackMin.pop();
		return this.stackData.pop();
	}
	public int getmin() {
		if(this.stackMin.isEmpty())
			throw new RuntimeException("The stack is Empty!");
		return this.stackMin.peek();
	}
}
