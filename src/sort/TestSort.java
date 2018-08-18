package sort;

public class TestSort {
	/*
	 * 选择排序：给定一组记录，找到最小值，与第一个位置值交换，
	 * 然后对不包含第一个位置的记录进行同样的操作，直至结束。
	 */
	public static void selectSort(int[] a) {
		int tmp,i,j,k;
		int n=a.length;
		for(i=0;i<n-1;i++)
		{
			k=i;
			for(j=i+1;j<n;j++)
			{
				if(a[k]>a[j])
					k=j;
			}
			if(k!=i) {
				tmp=a[k];
				a[k]=a[i];
				a[i]=tmp;
			}
		}
	}
	/*
	 * 插入排序：初始时假设第一个记录自成一个有序序列，其余记录为无序序列，
	 * 那么插入排序就是从无序序列依次将数据插入前面的有序序列
	 */
	public static void insertSort(int[] a) {
		int tmp,i,j;
		if(a!=null)
		{
			for(i=1;i<a.length;i++) {
				j=i;
				tmp=a[i];
				while(j>=1) {
					if(tmp<a[j-1])
					{
						a[j]=a[j-1];
						j--;
					}
					else
						break;
				}
				a[j]=tmp;
			}
		}
	}
	/*
	 * 冒泡排序：和选择的区别是两两比较的时候就执行了交换
	 */
	public static void bubbleSort(int[] a) {
		int i,j,tmp;
		int n=a.length;
		for(i=0;i<n-1;i++)
			for(j=0;j<n-1-i;j++)//for(j=i;j<n-1;j++)是错的，因为最小的换到了后面了呀，所以j的范围要变成[0,j-1-i]
			{
				if(a[j]>a[j+1])
				{
					tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
				}
			}
	}
	/*
	 * 归并排序：归表示递归，递归将数组折半成单个数组；并表示把分开的数据再由小到大合并到一个数组中去
	 * 两步：划分半子表和合并半子表
	   包含两个函数，一个是MergeSort负责划分数组，一个是Merge，负责对两个有序的子数组进行有序的合并
	 */
	public static void Merge(int a[],int start,int middle,int end) {
		int i,j,k,n1,n2;
		n1=middle-start+1;
		n2=end-middle;
		int[] L=new int[n1];
		int[] R=new int[n2];
		for(i=0,k=start;i<n1;i++) {
			L[i]=a[k+i];
		}
		for(j=0,k=middle+1;j<n2;j++) {
			R[j]=a[k+j];
		}
		for(k=start,i=0,j=0;i<n1&&j<n2;k++) {
			if(L[i]<R[j]) {
				a[k]=L[i];
				i++;
			}
			else {
				a[k]=R[j];
				j++;
			}	
		}
		while(i<n1) {
			a[k]=L[i];
			i++;
			k++;
		}
		while(j<n2) {
			a[k]=R[j];
			j++;
			k++;
		}
	}
	public static void MergeSort(int a[],int start,int end) {
		if(start<end)
		{
			int middle=(start+end)/2;
			MergeSort(a,start,middle);
			MergeSort(a,middle+1,end);
			Merge(a,start,middle,end);
		}
	}
	/*
	 * 快速排序：对一组给定的记录，经过一趟排序以后，将序列分为两个部分，其中前一部分的所有记录都比后一部分小。
	 * 步骤 ：1）分解：两个非空子序列 2）递归调用快排对两个子序列内部进行排序  3）合并
	 * 
	 */
	public static void quickSort(int a[],int low,int high) {
		int i,j,index;
		if(low>=high)
			return;
		i=low;
		j=high;
		index=a[i];
		while(i<j) {
			while(i<j&&a[j]>=index)
				j--;
			if(i<j)
				a[i++]=a[j];
			while(i<j&&a[i]<=index)
				i++;
			if(i<j)
				a[j--]=a[i];
		}
		a[i]=index;
		quickSort(a,low,i-1);
		quickSort(a,i+1,high);
	}
	/*
	 * 希尔排序：缩小增量排序，将待排序的数组分成多个子序列，
	 * 对每个子序列分别进行直接插入排序，
	 * 待整个待排序列基本有序以后，
	 * 对整体再进行一次直接插入排序。
	 * 1）选定步长序列t1,t2,..,tk,k=length/2,tk=1
	 * 2)根据k,对序列进行k趟排序
	 * 3）每趟排序，是对根据步长ti划分的子序列进行直接插入排序
	 * 直接插入排序：每步将一个待排序的记录按其关键字的大小插到前面已经排序的序列中的适当位置，
	 * 直到全部记录插入完毕为止。
	 */
	public static void shellSort(int a[]) {
		int n=a.length;
		int i,j,d,tmp;
		for(d=n/2;d>0;d=d/2) {//d为增量
			for(i=d;i<n;i++) {
				tmp=a[i];
				for(j=i-d;j>=0;j=j-d) {//这里保证了前面有序
					if(tmp<a[j]) {
						a[j+d]=a[j];
					}
					else
						break;
				}
				a[j+d]=tmp;
			}
		}
	}
	/*
	 * 堆排序：初始时把这些记录看作一棵顺序存储的二叉树，然后将其调整为一个大顶堆，然后将堆的
	 * 最后一个元素与堆顶元素交换，堆的最后一个元素即为最大的记录；接着将前（n-1）个元素重新调整为大顶堆，重复上述过程。
	 * 大顶堆：r(i)>=r(2*i)且r(i)>=r(2*i+1)
	 * 小顶堆：r(i)<=r(2*i)且r(i)<=r(2*1+1)
	 */
	public static void adjustMinHeap(int[] a,int parent,int len) {//生成小顶堆
		int tmp,child;
		tmp=a[parent];
		while(2*parent+1<len){
			child=2*parent+1;
			if(child<len-1&&a[child]>a[child+1])//找到左右孩子中最小的点
				child++;
			if(tmp>a[child])//父节点小于孩子节点，则找到合适的位置
				a[parent]=a[child];
			else
				break;
			parent=child;
		}
		a[parent]=tmp;
	}
	public static void myMinHeapSort(int a[]) {
		int i;
		int len=a.length;
		for(i=len/2-1;i>=0;i--)//
			adjustMinHeap(a,i,len-1);
		for(i=len-1;i>1;i--) {//交换首尾
			int tmp=a[0];
			a[0]=a[i];
			a[i]=tmp;
			adjustMinHeap(a,0,i-1);//获取最小值，然后对剩下的数据调整重新生成小顶堆
		}
	}
	public static void adjustMaxHeap(int[] a,int parent,int len) {//生成小顶堆
		int tmp,child;
		tmp=a[parent];
		while(2*parent+1<len){
			child=2*parent+1;
			if(child<len-1&&a[child]<a[child+1])//找到左右孩子中最大的点
				child++;
			if(tmp<a[child])//父节点大于孩子节点，则找到合适的位置
				a[parent]=a[child];
			else
				break;
			parent=child;
		}
		a[parent]=tmp;
	}
	public static void myMaxHeapSort(int a[]) {
		int i;
		int len=a.length;
		for(i=len/2-1;i>=0;i--)//
			adjustMaxHeap(a,i,len-1);
		for(int j=0;j<a.length;j++)
			System.out.print(a[j]+" ");
		System.out.println("");
		for(i=len-1;i>1;i--) {//交换首尾,注意这里i>1,因为当i=2时，已经执行了a[0]和a[1]的调整
			int tmp=a[0];
			a[0]=a[i];
			a[i]=tmp;
			adjustMaxHeap(a,0,i-1);//获取最大值，然后对剩下的数据调整重新生成小顶堆
		}
	}
	public static void main(String args[]) {
		int a[]= {5,4,9,8,7,6,0,7,1,3,2};
		//selectSort(a);
		//insertSort(a);
		//bubbleSort(a);
		int n=a.length;
		//MergeSort(a,0,n-1);
		//quickSort(a,0,n-1);
		//shellSort(a);
		myMinHeapSort(a);
		//myMaxHeapSort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
