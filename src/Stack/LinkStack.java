package Stack;
/****
 * 
 * @author eple
 *��ջ
 * @param <E>
 */
//������
class Node<E>{
	Node<E> next=null;
	E data;
	public Node(E data){
		this.data=data;
	}
}
public class LinkStack<E> {//��Ա����Ϊջ��Ԫ��
	Node<E> top=null;
	public boolean isEmpty(){
		return top==null;
	}
	public void push(E data){//�൱��ͷ�巨��ջ��Ԫ�ض�Ӧ����ͷ
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
