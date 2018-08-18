package test;
import java.util.Scanner;
class Tower{
	public int num=0;
	public int len=0;
	public Tower(int num,int len) {
		this.num=num;
		this.len=len;
	}
}
public class Test {
	public static void selectSort(Tower[] a) {
		Tower tmp;
		int i,j,k;
		int n=a.length;
		for(i=0;i<n-1;i++)
		{
			k=i;
			for(j=i+1;j<n;j++)
			{
				if(a[k].len>a[j].len)
					k=j;
			}
			if(k!=i) {
				tmp=a[k];
				a[k]=a[i];
				a[i]=tmp;
			}
		}
	}
	public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int []a=new int[n];
	        Tower []tower=new Tower[n];
	        for(int i = 0; i < n; i++){
	               tower[i] = new Tower(i,sc.nextInt());
	        }
	        selectSort(tower);
	        for(int i=0;i<n;i++) {
	        	
	        }
	    }
	}
