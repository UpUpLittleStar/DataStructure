package LinkNode;

import java.util.Hashtable;

public class MyLinkedList {
	Node head=null;
	/**
	 * �������дӱ�β��������
	 * @param d���������ݵ�����
	 */
	//��������
	public void addNode(int d)
	{
		Node newNode=new Node(d);
		if(head==null){
			head=newNode;
			return;
		}
		Node temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=newNode;
	}
	//ɾ��ָ��λ�õĽ��
	public Boolean deleteNode(int index){
		if(index<1||index>length()){
			return false;
		}
		if(index==1){
			head=head.next;
			return true;
		}
		int i=2;
		Node preNode=head;
		Node curNode=preNode.next;
		while(curNode!=null){
			if(i==index){
				preNode.next=curNode.next;
			}
			preNode=curNode;
			curNode=curNode.next;
			i++;
		}
		return true;
	}
	//����������
	public int length(){
		int length=0;
		Node temp=head;
		while(temp!=null){
			length++;
			temp=temp.next;
		}
		return length;
	}
	//��������
	public Node orderList(){
		Node curNode=head;
		Node nextNode=null;
		int tmp;
		while(curNode!=null){
			nextNode=curNode.next;
			while(nextNode!=null){
				if(curNode.data>nextNode.data){
					tmp=curNode.data;
					curNode.data=nextNode.data;
					nextNode.data=tmp;
				}
				nextNode=nextNode.next;
			}
			curNode=curNode.next;
		}
		return head;
	}
	//��ӡ����
	public void printList(){
		Node tmp=head;
		while(tmp!=null)
		{
			System.out.println(tmp.data);
			tmp=tmp.next;
		}
	}
	//ɾ���ظ���Ԫ��
	public void deleteDuplecate1(Node head){
		Hashtable<Integer,Integer> table=new Hashtable<Integer,Integer>();
		Node tmp=head;
		Node pre=null;
		while(tmp!=null){
			if(table.containsKey(tmp.data)){
				pre.next=tmp.next;
			}
			else{
				table.put(tmp.data,1);
				pre=tmp;
			}	
			tmp=tmp.next;
		}
	}
	public void deleteDuplecate2(Node head){
		Node p=head;
		Node preNode=null;
		while(p!=null){
			Node q=head;
			while(q!=p){
				if(q.data==p.data){
					if(q==head)
						head=head.next;
					else
					{
						preNode.next=q.next;
					}
					break;
				}
				else{
					preNode=q;
					q=q.next;
				}	
			}
			p=p.next;
		}
	}
	//Ѱ�ҵ�����k��Ԫ��
	public Node findElem(int k){
		int len=this.length();
		if(k>len||k<1)
			return null;
		Node curNode=head;
		Node preNode=head;
		int count=0;
		if(curNode!=null){//�ҵ������head�ĵ�k����
			count++;
			while(count<k){
				curNode=curNode.next;
				count++;
			}
		}
		while(curNode.next!=null){
			preNode=preNode.next;
			curNode=curNode.next;
		}
		return preNode;
		
	}
	//����ķ�ת,������ת����¼β���Ϊͷ
	public void reverse(){
		Node pre=null;
		Node cur=this.head;
		Node next=null;
		Node newhead=null;
		while(cur!=null){
			next=cur.next;
			if(next==null){
				newhead=cur;
			}
			cur.next=pre;
			pre=cur;
			cur=next;	
		}
		this.head=newhead;
	}
	//��β��ͷ����������ݹ�ʵ��
	public void printListReverse(Node pHead){
		if(pHead!=null){
			printListReverse(pHead.next);
			System.out.println(pHead.data);
		}
	}
	//���Ѱ�ҵ�������м��㣺����ָ�룬��ָ������������ָ����һ��
	public Node SearchMid(){
		Node p=head;
		Node q=head;
		while(p!=null&&p.next!=null&&p.next.next!=null){
			p=p.next.next;
			q=q.next;
		}
		return q;
	}
	//�ж������Ƿ��л�
	public boolean IsLoop(){
		Node fast=head;
		Node slow=head;
		if(fast==null)
			return false;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				return true;
		}
		return !(fast==null||fast.next==null);
	}
	//�жϻ������
	public Node FindLoopPort(){
		Node fast=head;
		Node slow=head;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				break;
		}
		if(fast==null||fast.next==null){
			return null;
		}
		slow=head;//ע������slow�ٴδ�head����
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	//�ڲ�֪��ͷָ��������ɾ��ָ�����
	public boolean deleteNode(Node n){
		if(n==null||n.next==null){//���ɾ��β��㣬���޷�ɾ��;���򽻻��ýڵ������׺����ֵ��Ȼ��ɾ����̽ڵ㡣
			return false;
		}
		int tmp=n.data;
		n.data=n.next.data;
		n.next.data=tmp;
		n.next=n.next.next;
		return true;
	}
	//�ж����������Ƿ��ཻ.��ΪѰ���Ƿ�����ͬ��β���
	public boolean isIntersect(Node h1,Node h2){
		if(h1==null&&h2==null)
			return true;
		Node tail1=h1;
		Node tail2=h2;
		while(tail1.next!=null)
			tail1=tail1.next;
		while(tail2.next!=null)
			tail2=tail2.next;
		return tail1==tail2;
		/*if(tail1==tail2)
			return true;
		return false;*/	
	}
	//Ѱ���������ཻ�ĵ�һ�����
	public Node getFirstMerge(Node h1,Node h2){
		//��һ�������ж��Ƿ��ཻ
		if(h1==null&&h2==null)
			return null;
		Node tail1=h1;
		Node tail2=h2;
		int len1=1;
		int len2=1;
		while(tail1.next!=null)
		{
			tail1=tail1.next;
			len1++;
		}
		while(tail2.next!=null)
		{
			tail2=tail2.next;
			len2++;
		}
		if(tail1!=tail2)
			return null;
		//�ڶ������Ƚ���������ĳ��ȣ��ϳ�����Ҫ���ƶ����ͽ϶�����ȳ�
		Node t1=h1;
		Node t2=h2;
		if(len1>len2){
			int d=len1-len2;
			while(d!=0){//ע����0
				t1=t1.next;
				d--;
			}
		}
		else{
			int d=len2-len1;
			while(d!=0){
				t2=t2.next;
				d--;
			}
		}
		//��������ͬʱ�ƶ���ֱ�����
		while(t1!=t2){
			t1=t1.next;
			t2=t2.next;
		}
		return t1;		
	}
	public static void main(String args[]){
		MyLinkedList list=new MyLinkedList();
		list.addNode(3);
		list.addNode(5);
		list.addNode(3);
		list.addNode(1);
		list.addNode(3);
		System.out.println(list.length());
		System.out.println("Before order:");
		list.printList();
		list.orderList();
		System.out.println("After order:");
		list.printList();
		/*System.out.println("After delete:");
		list.deleteNode(2);
		list.deleteDuplecate2(list.head);
		System.out.println("������");
		System.out.println(list.findElem(5).data);
		list.reverse();
		list.printList();
		list.printListReverse(list.head);*/
		System.out.println(list.SearchMid().data);
	}
}
