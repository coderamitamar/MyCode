package DynamicProg;

class LCS
{
	int L[][];
	int m,n;
	LCS(int m,int n)
	{
		this.m=m;
		this.n=n;
		L=new int[m+1][n+1];
	}
	public int getLCSlength(String X,String Y)
	{
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0||j==0)
					L[i][j]=0;
				else if(X.charAt(i-1)==Y.charAt(j-1))
					L[i][j]=L[i-1][j-1]+1;
				else
					L[i][j]=(L[i][j-1]>L[i-1][j])?L[i][j-1]:L[i-1][j];
			}
		}
		return L[m][n];
	}
	public String getLCS(String X,String Y)
	{
		int index=L[m][n];
		char str[]=new char[index];
		int i=m,j=n;
		while(i>0 && j>0)
		{
			if(X.charAt(i-1)==Y.charAt(j-1))
			{
				str[index-1]=X.charAt(i-1);
				i--;
				j--;
				index--;
			}
			else if(L[i][j-1]>L[i-1][j])
				j--;
			else
				i--;
		}
		return new String(str);
	}
}
public class LCSDemo
{
	public static void main(String[] args)
	{
		String X="Lalit kumar";
		String Y="Anil kumar";
		LCS l=new LCS(X.length(),Y.length());
		System.out.println(l.getLCSlength(X,Y));
		System.out.println(l.getLCS(X,Y));
	}
}
