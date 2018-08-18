package Stack;
/****
 * 
 * @author eple
 *链栈
 * @param <E>
 */
//定义结点
class Node<E>{
	Node<E> next=null;
	E data;
	public Node(E data){
		this.data=data;
	}
}
public class LinkStack<E> {//成员变量为栈顶元素
	Node<E> top=null;
	public boolean isEmpty(){
		return top==null;
	}
	public void push(E data){//相当于头插法，栈顶元素对应链表头
		Node<E> newNode=new Node<E>(data);
		newNode.next=top;
		top=newNode;
	}
	public E pop(){
		if(this.isEmpty()){
			return null;
		}
		E data=top.data;
		top=top.next;
		return data;
	}
	public E peek(){
		if(isEmpty())
			return null;
		return top.data;
	}
	public static void main(String args[]){
		LinkStack<Integer> s=new LinkStack<Integer>();
		s.push(1);
		s.push(2);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
	}
}
