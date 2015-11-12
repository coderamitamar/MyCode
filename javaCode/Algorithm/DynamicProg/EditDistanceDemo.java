package DynamicProg;

class EditDistance
{
	private int m,n;
	private int lookup[][];
	EditDistance(int m,int n)
	{
		this.m=m;
		this.n=n;
		lookup=new int[m][n];
	}
	public int getEditDistance(String X,String Y)
	{
		int i,j,lCell,tCell,cCell;
		for(i=0;i<m;i++)
			lookup[i][0]=i;
		for(j=0;j<m;j++)
			lookup[0][j]=j;
		for(i=1;i<m;i++)
		{
			for(j=1;j<n;j++)
			{
				lCell=lookup[i][j-1]+1;
				tCell=lookup[i-1][j]+1;
				cCell=lookup[i-1][j-1]+(X.charAt(i-1)!=Y.charAt(j-1)?1:0);
				lookup[i][j]=Math.min(Math.min(lCell,tCell),cCell);
			}
		}
		return lookup[m-1][n-1];
	}
}
public class EditDistanceDemo
{
	public static void main(String[] args)
	{
		String X="sunday";
		String Y="saturday";
		EditDistance ed=new EditDistance(X.length(),Y.length());
		System.out.println(ed.getEditDistance(X,Y));
		//System.out.println(ed.getLCS(X,Y));
	}
}
