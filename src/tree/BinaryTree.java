package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;
	private int maxLen;
	public BinaryTree() {
		root=null;
	}
	//插入生成二叉排序树
	public void insert(int data) {
		Node newNode=new Node(data);
		if(root==null)
			root=newNode;
		else {
			Node current=root;
			Node parent;
			while(true) {
				parent=current;
				if(parent.data>data) {
					current=parent.left;
					if(current==null) {
						parent.left=newNode;
						return;
					}
				}
				else {
					current=parent.right;
					if(current==null) {
						parent.right=newNode;
						return;
					}
				}
			}
		}	
	}
	//创建树
	public void buildTree(int[] data) {
		for(int i=0;i<data.length;i++)
			insert(data[i]);
	}
	//中序
	public void inOrder(Node localRoot) {
		if(localRoot!=null) {
			inOrder(localRoot.left);
			System.out.print(localRoot.data);
			inOrder(localRoot.right);
		}
	}
	public void inOrder() {
		this.inOrder(root);
	}
	//先序
	public void preOrder(Node localRoot) {
		if(localRoot!=null) {
			System.out.print(localRoot.data);
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	public void preOrder() {
		this.preOrder(root);
	}
	// 后序
	public void postOrder(Node localRoot) {
		if(localRoot!=null) {
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data);
		}
	}
	public void postOrder() {
		this.postOrder(root);
	}
	
	//层次遍历
	public void layerOrder() {
		if(this.root==null)
			return;
		Queue <Node> q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node n=q.poll();
			System.out.print(n.data+" ");
			if(n.left!=null)
				q.add(n.left);
			if(n.right!=null)
				q.add(n.right);
		}
	}
	
	//利用先序和中序遍历创建树，并求后序遍历
	public void initTree(int[] preOrder,int[] inOrder) {
		this.root=this.initTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
	}
	public Node initTree(int[] preOrder,int start1,int end1,int[] inOrder,int start2,int end2) {
		if(start1>end1||start2>end2)
			return null;
		int rootdata=preOrder[start1];
		Node head=new Node(rootdata);
		int rootIndex=this.findIndexInArray(inOrder, rootdata, start2, end2);
		int offSet=rootIndex-start2-1;
		Node left=this.initTree(preOrder, start1+1, start1+1+offSet, inOrder, start2, rootIndex-1);
		Node right=this.initTree(preOrder, start1+1+offSet+1, end1, inOrder, rootIndex+1, end2);
		head.left=left;
		head.right=right;
		return head;
	}
	public int findIndexInArray(int[] a,int data,int start,int end) {
		for(int i=start;i<=end;i++)
			if(a[i]==data)
				return i;
		return -1;
	}
   //求二叉树中节点最大距离，在节点定义的时候添加了leftMax和rightMax
	private int max(int a,int b) {
		return a>b?a:b;
	}
	public void findMaxDistance(Node root) {
		if(root==null)
			return;
		if(root.left==null)
			root.leftMax=0;
		if(root.right==null)
			root.rightMax=0;
		if(root.left!=null)
			this.findMaxDistance(root.left);
		if(root.right!=null)
			this.findMaxDistance(root.right);
		if(root.left!=null)
			root.leftMax=max(root.left.leftMax,root.left.rightMax)+1;
		if(root.right!=null)
			root.rightMax=max(root.right.leftMax,root.right.rightMax)+1;
		if(root.leftMax+root.rightMax>maxLen)
			maxLen=root.leftMax+root.rightMax;
	}
	public static void main(String args[]) {
		BinaryTree biTree=new BinaryTree();
		int []data= {2,8,7,4,9,3,1,6,7,5};
		biTree.buildTree(data);
		System.out.print("中序遍历：");
		biTree.inOrder();
		System.out.println();
		System.out.print("先序遍历：");
		biTree.preOrder();
		System.out.println();
		System.out.print("后序遍历：");
		biTree.postOrder();
		System.out.println();
		System.out.print("层次遍历：");
		biTree.layerOrder();
		/*int preOrder[]= {1,2,4,8,9,5,10,3,6,7};
		int inOrder[]= {8,4,9,2,10,5,1,6,3,7};
		biTree.initTree(preOrder, inOrder);
		System.out.print("先序中序生成的后序遍历是：");
		biTree.postOrder();*/
		biTree.findMaxDistance(biTree.root);
		System.out.println();
		System.out.print(biTree.maxLen);
	}
}
