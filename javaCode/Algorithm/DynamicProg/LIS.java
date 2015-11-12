package DynamicProg;

class LISFunc
{
	private int max;
	private int lookup[];
	LISFunc(int m)
	{
		max=m;
		lookup=new int[m];
		lookup[0]=1;
	}
	public int lis(int A[],int i)
	{
		if(lookup[i]!=0)
			return lookup[i];
		else
		{
			int temp,currMax=0;
			for(int j=0;j<i;j++)
			{
				temp=lis(A,j);
				if(currMax<temp && A[j]<A[i])
					currMax=temp;
			}
			currMax+=1;
			lookup[i]=currMax;
			return currMax;
		}
	}
	public int lismain(int A[])
	{
		int res=0,len=max;
		for(int i=0;i<len;i++)
		{
			if(lookup[i]!=0 && lookup[i]>res)	res=lookup[i];
			else
			{
				int temp=lis(A,i);
				if(temp>res)	res=temp;
			}				
		}
		return res;
	}
}
class LIS
{
	public static void main(String[] args)
	{
		int A[]={10,18,9,19,21,50,41,60,80};
		LISFunc l=new LISFunc(A.length);
		System.out.println(l.lismain(A));
	}
}
