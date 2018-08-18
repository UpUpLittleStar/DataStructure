package paixu;

public class TestSort {
	public static void insertSort(int[] a){
		int n=a.length;
		int data;
		for(int i=1;i<n;i++){
			data=a[i];
			int j=i;
			if(a[j-1]>data){
				while(j>=1&&a[j-1]>data){
					a[j]=a[j-1];
					j--;
				}
			}
			a[j]=data;
		}
	}
	public static void insertSort2(int[] a){
		int n=a.length;
		int data,j;
		for(int i=1;i<n;i++){
			data=a[i];j=i;
			if(a[i-1]<data)//如果直接大于前一个数，则不做处理
			{	
				continue;
			}
			while(j>=1&&a[j-1]>data){//注意j>=1，所以对于插入到第一个位置的点在比较过程中已经跳出循环
					a[j]=a[j-1];
					j--;				
			}
			a[j]=data;//注意a[0]=data的特殊情况
		}
	}
	public static void main(String args[]){
		int a[]={7,8,2,4,1};
		insertSort2(a);
		for(int i=0;i<5;i++){
			System.out.println(a[i]);
		}
	}
}
