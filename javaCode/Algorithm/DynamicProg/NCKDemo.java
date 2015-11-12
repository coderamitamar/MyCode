package DynamicProg;
import java.math.BigInteger;
class CalcNCK
{
	private int N,todo=0;
	private BigInteger NCKTable[][];
	CalcNCK(int N)
	{
		this.N=N;
		NCKTable=new BigInteger[N+1][N+1];
	}
	void createNCKTable()
	{
		Integer i,j;
		NCKTable[0][0]=BigInteger.ONE;
		for(i=1;i<=N;i++)
		{
			NCKTable[i][0]=BigInteger.ONE;
			NCKTable[i][i]=BigInteger.ONE;
			NCKTable[i][1]=new BigInteger(i.toString());
			for(j=2;j<i;j++)
				NCKTable[i][j]=NCKTable[i-1][j-1].add(NCKTable[i-1][j]);
		}
	}
	public BigInteger getNCK(int k)
	{
		if(todo==0)
		{
			todo=1;
			createNCKTable();
		}
		if(k<0)
			return BigInteger.ONE.negate();
		if(k>N)
			return BigInteger.ZERO;
		return NCKTable[N][k];
	}	
	public BigInteger binCoeff(int n, int k)
	{
	    BigInteger C[]=new BigInteger[k+1];
	    int i,j,min;
	    C[0]=BigInteger.ONE;
	    for(i=1;i<=n;i++)
	    {
	    	min=(i>k)?k:i;
	    	if(C[min]==null)
	    		C[min]=BigInteger.ZERO;
	        for(j=min;j>0;j--)
	        	C[j]=C[j].add(C[j-1]);
	    }
	    return C[k];
	}
}
class NCKDemo
{
	public static void main(String[] args)
	{
		int N=3000,K=500;
		BigInteger res1,res2;
		CalcNCK nck=new CalcNCK(N);
		res1=nck.getNCK(K);
		System.out.println(res1);
		System.out.println("Length: "+res1.toString().length());
		System.out.println(nck.getNCK(K-10));
		System.out.println(nck.getNCK(K-20));
		System.out.println(nck.getNCK(K-30));
		System.out.println(nck.getNCK(K-40));
		System.out.println(nck.getNCK(K-50));
		
		res2=nck.binCoeff(N,K);
		System.out.println("\n"+res2);
		System.out.println("Length: "+res2.toString().length());
		if(res1.equals(res2))
			System.out.print("Yes");
	}
}