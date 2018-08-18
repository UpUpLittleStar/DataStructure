package BitCompute;

public class Test {
	//用移位操作实现乘法运算
	public static int powerN(int m,int n){//2^n
		for(int i=1;i<=n;i++)
			m=m<<1;
		return m;
	}
	//如何判断一个数是2的n次方
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
	//法2：如果是2的n次方，num与num-1的二进制格式相与必为0
	public static boolean isPower2(int n){
		if(n<1)
			return false;
		int m=n&(n-1);
		return m==0;
	}
	//求二进制数中1的个数
	//法1：与运算判断最后一位是否为1，然后右移丢掉最后一位
	public static int countOne(int n){
		int count=0;
		while(n>0){
			if((n&1)==1)
				count++;
			n=n>>1;
		}
		return count;		
	}
	//法2：n&(n-1)计算，其结果必定少一个1，而且是最后一位
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
