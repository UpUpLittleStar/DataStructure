package Stack;

public class minStack {
	LinkStack<Integer> stack;
	LinkStack<Integer> min;
	public minStack(){
		stack=new LinkStack<Integer>();
		min=new LinkStack<Integer>();
	}
	public void push(int data){
		stack.push(data);
		if(min.isEmpty())
			min.push(data);
		else
			if(data<min.peek())
				min.push(data);
	}
	public int pop(){
		int topData=stack.pop();
		if(topData==min.peek())
			min.pop();
		return topData;
	}
	public int min(){
		if(min.isEmpty())
			return Integer.MAX_VALUE;
		return min.peek();
	}
	public static void main(String args[]){
		minStack stack=new minStack();
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(7);
		System.out.println(stack.min());
	}
}
