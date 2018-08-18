package Stack;

import java.util.Stack;

/**
 * 
 * @author eple
 *用两个栈实现队列
 * @param <E>
 */
public class MyQueue<E> {
	private Stack<E> s1=new Stack<E>();
	private Stack<E> s2=new Stack<E>();
	public synchronized void put(E data){
		s1.push(data);
	}
	public synchronized E pop(){
		if(s2.isEmpty())
		{
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	public synchronized boolean isEmpty(){
		return s1.isEmpty()&&s2.isEmpty();
	}
	public static void main(String args[]){
		MyQueue<Integer> q=new MyQueue<Integer>();
		q.put(1);
		q.put(2);
		System.out.println(q.pop());
	}
}
