package BitCompute;

public class Test {
	//����λ����ʵ�ֳ˷�����
	public static int powerN(int m,int n){//2^n
		for(int i=1;i<=n;i++)
			m=m<<1;
		return m;
	}
	//����ж�һ������2��n�η�
	//O(logn)
	public static boolean isPower1(int n){
		if(n<1)
			return false;
		int i=1;
		while(i<=n){
			if(i==n)
				return true;
			i=i<<1;
		}
		return false;
	}
	//��2�������2��n�η���num��num-1�Ķ����Ƹ�ʽ�����Ϊ0
	public static boolean isPower2(int n){
		if(n<1)
			return false;
		int m=n&(n-1);
		return m==0;
	}
	//�����������1�ĸ���
	//��1���������ж����һλ�Ƿ�Ϊ1��Ȼ�����ƶ������һλ
	public static int countOne(int n){
		int count=0;
		while(n>0){
			if((n&1)==1)
				count++;
			n=n>>1;
		}
		return count;		
	}
	//��2��n&(n-1)���㣬�����ض���һ��1�����������һλ
	public static int countOne2(int n){
		int count=0;
		while(n>0){
			if(n!=0)
				n=n&(n-1);
			count++;
			
		}
		return count;		
	}
	public static void main(String args[]){
		/*System.out.println("3*8="+powerN(3,3));
		System.out.println("7*16="+powerN(7,4));*/
		//System.out.println(isPower2(255));
		System.out.println(countOne2(16));
	}
}
