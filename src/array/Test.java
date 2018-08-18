package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {
	public static int Max=0;//static�൱��ȫ�ֱ���
	public static int Min=0;
	//static�������ܷ��ʷ�static���͵ı��������ܵ��÷�static�ķ���������ʹ��this��super�ؼ��֣�ֻ�ܷ���������ľ�̬��Ա�����ͷ���
	public static void GetMaxAndMin(int[] a){
		Max=a[0];
		Min=a[0];
		int len=a.length;
		for(int i=1;i<len;i++){
			if(a[i]<Min)
				Min=a[i];
			if(a[i]>Max)
				Max=a[i];
		}
	}
	//Ѱ�ҵڶ�С��ֵ
	public static int FindSecMin(int a[]){
		int min=a[0];
		int secMin=Integer.MAX_VALUE;
		int len=a.length;
		for(int i=0;i<len;i++){
			if(a[i]<min){
				secMin=min;
				min=a[i];
			}
			else if(a[i]>min){
				if(a[i]<secMin)
					secMin=a[i];
			}
		}
		return secMin;
	}
	//Ѱ�ҵڶ����ֵ
	public static int FindSecMax(int a[]){
		int max=a[0];
		int secMax=Integer.MIN_VALUE;
		int len=a.length;
		for(int i=0;i<len;i++){
			if(a[i]>max){
				secMax=max;
				max=a[i];
			}
			else if(a[i]<max){
				if(a[i]>secMax)
					secMax=a[i];
			}
		}
		return secMax;
	}
	//�����������֮��
	public static int getmax(int m,int n){
		return m>n?m:n;
	}
	/**
	 * ��1�������Ƿ����a[i]���ж�̬�滮��E[i]=max{E[i-1],a[i]},All[i]=max{All[i-1],E[i]};
	 * ʱ�� O(n) �ո�O(n)
	 * @param a
	 * @return
	 */
	public static int maxSubArray(int a[]){
		int n=a.length;
		int All[]=new int[n];
		int End[]=new int[n];
		End[n-1]=a[n-1];
		All[n-1]=a[n-1];
		End[0]=All[0]=a[0];
		for(int i=1;i<n;i++){
			End[i]=getmax(a[i],End[i-1]+a[i]);
			All[i]=getmax(All[i-1],End[i]);
		}
		return All[n-1];
	}
	/**
	 * �ڷ�1�Ļ����Ͻ��Ϳռ临�Ӷ�
	 * @param a
	 * @return
	 */
	public static int maxSubArray2(int a[]){
		int n=a.length;
		int nAll=a[0];
		int nEnd=a[0];
		for(int i=1;i<n;i++){
			nEnd=getmax(a[i],nEnd+a[i]);
			nAll=getmax(nAll,nEnd);
		}
		return nAll;
	}
	/**
	 * ��3��������������λ�ã�max.begin,end
	 * E[i]=max{E[i-1],a[i]}:��E[i-1]<0ʱ��E[i]=a[i],��ʱbegin=i;
	 * @param a
	 * @return
	 */
	public static int[] maxSubArray3(int a[]){
		
		int n=a.length;
		int b[]=new int[3];
		int begin=0,end=0,nSum=0,maxSum=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(nSum<0){
				nSum=a[i];
				//nStart=i;
				begin=i;
			}
			else{
				nSum+=a[i];
			}
			if(nSum>maxSum){
				maxSum=nSum;
				end=i;
			}
		}
		b[0]=maxSum;
		b[1]=begin;
		b[2]=end;
		return b;
	}
	//�ҳ��������ظ�Ԫ��������
	/**
	 * ����Map����
	 * @param a
	 * @return
	 */
	public static int findMostFrequent(int a[]){
		int result=0,max=0;
		int n=a.length;
		if(n==0)
			return Integer.MAX_VALUE;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			if(map.containsKey(a[i])){
				map.put(a[i], map.get(a[i])+1);
			}
			else
				map.put(a[i], 1);
			Iterator iter=map.entrySet().iterator();//entrySet()����set,Ϊ�˱���map
			while(iter.hasNext()){
				Map.Entry entry=(Map.Entry)iter.next();
				int key=(Integer)entry.getKey();
				int value=(Integer)entry.getValue();
				if(value>max)
				{
					max=value;
					result=key;
				}
			}
		}
		return result;
	}
	//�����������������ӵ���20�������
	/**
	 * a[begin]+a[end]>20,��end-1;a[begin]+a[end]<20,��begin+1;
	 * @param a
	 * @param sum
	 */
	public static void findSum(int[] a,int sum){
		Arrays.sort(a);//java����ֱ������
		int begin=0;
		int end=a.length-1;
		while(begin<end){
			if(a[begin]+a[end]<sum)
				begin++;
			else if(a[begin]+a[end]>sum){
				end--;
			}
			else{
				System.out.println(a[begin]+","+a[end]);
				begin++;
				end--;
			}
		}
		
	}
	//����ѭ������kλ:0����n-k-1λ���ã�n-k����n-1λ���ã�Ȼ����������
	public static void reverse(int a[],int b,int e){
		int tmp;
		for(;b<e;b++,e--){
			tmp=a[b];
			a[b]=a[e];
			a[e]=tmp;
		}
	}
	public static void shift_k(int a[],int k){
		int n=a.length;
		k=k%n; //��ֹk��n��
		reverse(a,0,n-k-1);
		reverse(a,n-k,n-1);
		reverse(a,0,n-1);
	}
	//����ҳ������е�k����С����
	/**
	 * ��һ���������
	 * ��������֦���������ڿ��ŵ�˼�룬�жϵ�ǰ�Ļ�׼����λ���Ƿ�Ϊk-1
	 * @param a
	 * @param low
	 * @param high
	 * @param k
	 * @return
	 */
	public static int quickSort(int a[],int low,int high,int k){
		int i,j;
		int index;
		if(low>high)
			return Integer.MIN_VALUE;
		i=low;
		j=high;
		index=a[i];
		while(i<j){
			while(i<j&&a[j]>index)
				j--;
			if(i<j)
				a[i++]=a[j];
			while(i<j&&a[i]<index)
				i++;
			if(i<j)
				a[j--]=a[i];
		}
		a[i]=index;
		if(i==k-1)
			return index;
		else if(i<k-1)
			return quickSort(a,i+1,high,k);
		else
			return quickSort(a,low,i-1,k);	
	}
	//���������е���������n�Σ���һ����������1�Σ��������
	public static int findOnce(int a[],int appearTimes){
		int n=a.length;
		int[] bitCount=new int[32];//intΪ32λ
		for(int i=0;i<n;i++)
			for(int j=0;j<32;j++)
			{
				bitCount[j]+=(a[i]>>j)&1;
			}
		int result=0;
		for(int j=0;j<32;j++)
		{
			if(bitCount[j]%appearTimes!=0)
				result+=1<<j;
		}
		return result;
	}
	public static void main(String args[]){
		int a[]={1,2,1,2,1,2,3};
		//GetMaxAndMin(a);
		//System.out.println(FindSecMax(a));
		//int b[]=maxSubArray3(a);
		//System.out.println(b[0]+" "+b[1]+" "+b[2]);
		//System.out.println(Max);
		//System.out.println(Min);
		//System.out.println(findMostFrequent(a));
		//findSum(a,20);
		//shift_k(a,2);
		//System.out.println(quickSort(a,0,a.length-1,3));
		/*for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}*/
		
		System.out.println(findOnce(a,3));
	}
}
