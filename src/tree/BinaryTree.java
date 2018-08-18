package tree;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	public int data;
	public Node left=null;
	public Node right=null;
	public Node(int data){
		this.data=data;
	}
	
}
public class BinaryTree {
	private Node root;
	public BinaryTree(){
		root=null;
	}
	//二叉排序树的构建过程
	public void insert(int data){
		Node newNode=new Node(data);
		if(this.root==null){
			root=newNode;
			return;
		}
		Node current=root;
		Node parent;
		while(true){
			parent=current;
			if(data<parent.data){
				current=parent.left;
				if(current==null){
					parent.left=newNode;
					return;
				}
			}else{
				current=parent.right;
				if(current==null){
					parent.right=newNode;
					return;
				}
			}
		}
	}
	//输入数值构建二叉树
	public void buildTree(int[] a){
		for(int i=0;i<a.length;i++)
			insert(a[i]);
	}
	//中序遍历递归实现
	public void inOrder(Node localRoot){
		if(localRoot!=null){
			inOrder(localRoot.left);
			System.out.print(localRoot.data+" ");
			inOrder(localRoot.right);
		}
	}
	public void inOrder(){
		inOrder(this.root);
	}
	//先序遍历递归实现
	public void preOrder(Node localRoot){
		if(localRoot!=null){
			System.out.print(localRoot.data+" ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	public void preOrder(){
		preOrder(this.root);
	}
	//后序遍历递归实现
	public void postOrder(Node localRoot){
		if(localRoot!=null){
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data+" ");
		}
	}
	public void postOrder(){
		postOrder(this.root);
	}
	//层次遍历
	public void levelOrder(){
		if(this.root==null)
			return;
		Queue<Node> q=new LinkedList<Node>();//注意队列的定义
		q.add(root);
		while(!q.isEmpty()){
			Node n=q.poll();
			if(n.left!=null)
				q.add(n.left);
			if(n.right!=null)
				q.add(n.right);
		}
	}
	//已知先序遍历和中序遍历，求二叉树,准备测试
	public static void main(String args[]){
		BinaryTree biTree=new BinaryTree();
		int[] data={2,8,7,4,9,3,1,6,7,5};
		biTree.buildTree(data);
		biTree.inOrder();
		System.out.println();
		biTree.preOrder();
		System.out.println();
		biTree.postOrder();
	}
}
