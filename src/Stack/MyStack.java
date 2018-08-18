package Stack;

import java.util.Arrays;
/***
 * 数组栈
 * @author eple
 *
 * @param <E>
 */
public class MyStack <E> {//<E>表示泛型
     private Object[] stack;
     private int size;
     public MyStack(){
    	 stack=new Object[2]; //初始长度为10
     }
    //判断栈是否为空
     public boolean isEmpty(){
    	 return size==0;
     }
     //栈顶元素
     @SuppressWarnings("unchecked")
	public E peek(){
    	 if(isEmpty()){
    		 return null;
    	 }
    	 return (E)stack[size-1];
     }
     //出栈
     public E pop(){
    	 E e=peek();
    	 stack[size-1]=null;//注意设为null
    	 size=size-1;
    	 return e;
     }
     //判断容量
     public void ensureCapacity(int size){
    	 int len=stack.length;//len是存储的数组的长度
    	 if(size>len){//size是当前的栈内的数量
    		 int newLen=2;//数组已满
    		 stack=Arrays.copyOf(stack, newLen+len);
    	 }
     }
     //进栈
     public E push(E item){
    	 ensureCapacity(size+1);//检查容量
    	 stack[size++]=item;
    	 return item;
     }
     public static void main(String[] args){
    	 MyStack<Integer> s=new MyStack<Integer>();
    	 s.push(1);
    	 s.push(2);
    	 s.push(3);
    	 s.push(4);
    	 System.out.println("栈中元素个数："+s.size);
    	 System.out.println("栈顶元素："+s.pop());
    	 System.out.println("栈顶元素："+s.pop());
    	 System.out.println("栈顶元素："+s.pop());
    	 System.out.println("栈顶元素："+s.pop());
     }
}
