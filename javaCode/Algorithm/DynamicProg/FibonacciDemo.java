package DynamicProg;

class Fibonacci
{
	final int MAX=5000;
	long lookup[]=new long[MAX];
	
	//method section
	public long getFibByMemoization(int n)
	{
		if(lookup[n]==0)
		{
			if(n<=1)
				lookup[n]=n;
			else
				lookup[n]=getFibByMemoization(n-1)+getFibByMemoization(n-2);
		}
		return lookup[n];
	}
}
public class FibonacciDemo
{
	public static void main(String[] args)
	{
		Fibonacci f=new Fibonacci();
		System.out.println(f.getFibByMemoization(59));
		System.out.println(f.getFibByMemoization(60));
		//f.show();
	}
}
