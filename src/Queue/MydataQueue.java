package Queue;

import java.util.LinkedList;

/**
 * 
 * @author eple
 *用数组实现队列
 * @param <E>
 */
public class MydataQueue<E> {
	private LinkedList<E> list=new LinkedList<E>();
	private int size=0;
	public synchronized void put(E data){
		list.addLast(data);
		size++;
	}
	public synchronized E pop(){
		size--;
		return list.removeFirst();
	}
	public synchronized boolean isEmpty(){
		return size==0;
	}
	public synchronized int size(){
		return size;
	}
}
