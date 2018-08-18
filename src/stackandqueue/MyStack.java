package stackandqueue;

import java.util.Stack;

public class MyStack {
	//用递归实现栈的逆序
	public static int getAndRemoveLast(Stack<Integer> stack) {
		int result=stack.pop();
		if(stack.empty()) {
			return result;
		}
		else
		{
			int last=getAndRemoveLast(stack);
			stack.push(result);
			return last;
		}
	}
	public static void Reverse(Stack<Integer> stack) {
		if(stack.empty()) {
			return;
		}
		int i=getAndRemoveLast(stack);
		Reverse(stack);
		stack.push(i);
	}
	public static void main(String args[]) {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		Reverse(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
