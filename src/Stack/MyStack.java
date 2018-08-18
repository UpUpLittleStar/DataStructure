package Stack;

import java.util.Arrays;
/***
 * ����ջ
 * @author eple
 *
 * @param <E>
 */
public class MyStack <E> {//<E>��ʾ����
     private Object[] stack;
     private int size;
     public MyStack(){
    	 stack=new Object[2]; //��ʼ����Ϊ10
     }
    //�ж�ջ�Ƿ�Ϊ��
     public boolean isEmpty(){
    	 return size==0;
     }
     //ջ��Ԫ��
     @SuppressWarnings("unchecked")
	public E peek(){
    	 if(isEmpty()){
    		 return null;
    	 }
    	 return (E)stack[size-1];
     }
     //��ջ
     public E pop(){
    	 E e=peek();
    	 stack[size-1]=null;//ע����Ϊnull
    	 size=size-1;
    	 return e;
     }
     //�ж�����
     public void ensureCapacity(int size){
    	 int len=stack.length;//len�Ǵ洢������ĳ���
    	 if(size>len){//size�ǵ�ǰ��ջ�ڵ�����
    		 int newLen=2;//��������
    		 stack=Arrays.copyOf(stack, newLen+len);
    	 }
     }
     //��ջ
     public E push(E item){
    	 ensureCapacity(size+1);//�������
    	 stack[size++]=item;
    	 return item;
     }
     public static void main(String[] args){
    	 MyStack<Integer> s=new MyStack<Integer>();
    	 s.push(1);
    	 s.push(2);
    	 s.push(3);
    	 s.push(4);
    	 System.out.println("ջ��Ԫ�ظ�����"+s.size);
    	 System.out.println("ջ��Ԫ�أ�"+s.pop());
    	 System.out.println("ջ��Ԫ�أ�"+s.pop());
    	 System.out.println("ջ��Ԫ�أ�"+s.pop());
    	 System.out.println("ջ��Ԫ�أ�"+s.pop());
     }
}
