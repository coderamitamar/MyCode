package DynamicProg;

class MatrixChainMult
{
	private long multTable[][];
	private int MOTable[][];//multiplication order table
	private int dim[];
	private String multOrder="";
	MatrixChainMult(int dimension[])
	{
		dim=dimension;
	}
	public long getMultVal()
	{
		int i,j,k,l,n=dim.length;
		long q;
		multTable=new long[n][n];
		MOTable=new int[n][n];
		for(i=0;i<n;i++)
			multTable[i][i]=0;
		for(l=2;l<n;l++)
			for(i=1;i<n-l+1;i++)
			{
				j=i+l-1;
				multTable[i][j]=9999999999999l;
				for(k=i;k<=j-1;k++)
				{
					q=multTable[i][k]+multTable[k+1][j]+dim[i-1]*dim[k]*dim[j];
					if(q<multTable[i][j])
					{
						multTable[i][j]=q;
						MOTable[i][j]=k;
					}
				}
			}
		return multTable[1][n-1];
	}
	public String getMultOrder()
	{
		createMultOrder(1,dim.length-1);
		return multOrder;
	}
	public void createMultOrder(int i,int j)
	{
		char ch=64;
		if(i==j)
		{
			ch+=i;
			multOrder+=ch;
		}
		else
		{
			multOrder+="(";
			createMultOrder(i,MOTable[i][j]);
			createMultOrder(MOTable[i][j]+1,j);
			multOrder+=")";
		}
	}
}
public class MatrixChainMultDemo
{
	public static void main(String[] args)
	{
		int arr[]={4,3,4,2,1,8};
		MatrixChainMult m=new MatrixChainMult(arr);
		System.out.println(m.getMultVal());
		System.out.println(m.getMultOrder());
	}
}
