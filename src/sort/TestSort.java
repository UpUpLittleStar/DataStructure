package sort;

public class TestSort {
	/*
	 * ѡ�����򣺸���һ���¼���ҵ���Сֵ�����һ��λ��ֵ������
	 * Ȼ��Բ�������һ��λ�õļ�¼����ͬ���Ĳ�����ֱ��������
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
	 * �������򣺳�ʼʱ�����һ����¼�Գ�һ���������У������¼Ϊ�������У�
	 * ��ô����������Ǵ������������ν����ݲ���ǰ�����������
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
	 * ð�����򣺺�ѡ��������������Ƚϵ�ʱ���ִ���˽���
	 */
	public static void bubbleSort(int[] a) {
		int i,j,tmp;
		int n=a.length;
		for(i=0;i<n-1;i++)
			for(j=0;j<n-1-i;j++)//for(j=i;j<n-1;j++)�Ǵ�ģ���Ϊ��С�Ļ����˺�����ѽ������j�ķ�ΧҪ���[0,j-1-i]
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
	 * �鲢���򣺹��ʾ�ݹ飬�ݹ齫�����۰�ɵ������飻����ʾ�ѷֿ�����������С����ϲ���һ��������ȥ
	 * ���������ְ��ӱ�ͺϲ����ӱ�
	   ��������������һ����MergeSort���𻮷����飬һ����Merge�����������������������������ĺϲ�
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
	 * �������򣺶�һ������ļ�¼������һ�������Ժ󣬽����з�Ϊ�������֣�����ǰһ���ֵ����м�¼���Ⱥ�һ����С��
	 * ���� ��1���ֽ⣺�����ǿ������� 2���ݹ���ÿ��Ŷ������������ڲ���������  3���ϲ�
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
	 * ϣ��������С�������򣬽������������ֳɶ�������У�
	 * ��ÿ�������зֱ����ֱ�Ӳ�������
	 * �������������л��������Ժ�
	 * �������ٽ���һ��ֱ�Ӳ�������
	 * 1��ѡ����������t1,t2,..,tk,k=length/2,tk=1
	 * 2)����k,�����н���k������
	 * 3��ÿ�������ǶԸ��ݲ���ti���ֵ������н���ֱ�Ӳ�������
	 * ֱ�Ӳ�������ÿ����һ��������ļ�¼����ؼ��ֵĴ�С�嵽ǰ���Ѿ�����������е��ʵ�λ�ã�
	 * ֱ��ȫ����¼�������Ϊֹ��
	 */
	public static void shellSort(int a[]) {
		int n=a.length;
		int i,j,d,tmp;
		for(d=n/2;d>0;d=d/2) {//dΪ����
			for(i=d;i<n;i++) {
				tmp=a[i];
				for(j=i-d;j>=0;j=j-d) {//���ﱣ֤��ǰ������
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
	 * �����򣺳�ʼʱ����Щ��¼����һ��˳��洢�Ķ�������Ȼ�������Ϊһ���󶥶ѣ�Ȼ�󽫶ѵ�
	 * ���һ��Ԫ����Ѷ�Ԫ�ؽ������ѵ����һ��Ԫ�ؼ�Ϊ���ļ�¼�����Ž�ǰ��n-1����Ԫ�����µ���Ϊ�󶥶ѣ��ظ��������̡�
	 * �󶥶ѣ�r(i)>=r(2*i)��r(i)>=r(2*i+1)
	 * С���ѣ�r(i)<=r(2*i)��r(i)<=r(2*1+1)
	 */
	public static void adjustMinHeap(int[] a,int parent,int len) {//����С����
		int tmp,child;
		tmp=a[parent];
		while(2*parent+1<len){
			child=2*parent+1;
			if(child<len-1&&a[child]>a[child+1])//�ҵ����Һ�������С�ĵ�
				child++;
			if(tmp>a[child])//���ڵ�С�ں��ӽڵ㣬���ҵ����ʵ�λ��
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
		for(i=len-1;i>1;i--) {//������β
			int tmp=a[0];
			a[0]=a[i];
			a[i]=tmp;
			adjustMinHeap(a,0,i-1);//��ȡ��Сֵ��Ȼ���ʣ�µ����ݵ�����������С����
		}
	}
	public static void adjustMaxHeap(int[] a,int parent,int len) {//����С����
		int tmp,child;
		tmp=a[parent];
		while(2*parent+1<len){
			child=2*parent+1;
			if(child<len-1&&a[child]<a[child+1])//�ҵ����Һ��������ĵ�
				child++;
			if(tmp<a[child])//���ڵ���ں��ӽڵ㣬���ҵ����ʵ�λ��
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
		for(i=len-1;i>1;i--) {//������β,ע������i>1,��Ϊ��i=2ʱ���Ѿ�ִ����a[0]��a[1]�ĵ���
			int tmp=a[0];
			a[0]=a[i];
			a[i]=tmp;
			adjustMaxHeap(a,0,i-1);//��ȡ���ֵ��Ȼ���ʣ�µ����ݵ�����������С����
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
