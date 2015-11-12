package DynamicProg;
class CoinChange
{
	private int coin[];
	private int toChange;
	CoinChange(int S[],int N)
	{
		coin=S;
		toChange=N;
	}
	public int getNumOfWayToChange()
	{
		int withThis,withoutThis,m=coin.length;
		int table[][]=new int[toChange+1][m];
		for(int i=0;i<m;i++)
			table[0][i]=1;
		for(int i=1;i<=toChange;i++)
			for(int j=0;j<m;j++)
			{
				//count the solution including this coin
				withThis=(i-coin[j]>=0)?table[i-coin[j]][j]:0;
				//count the solution excluding this coin
				withoutThis=(j>=1)?table[i][j-1]:0;
				//Add them to get total solution
				table[i][j]=withThis+withoutThis;
			}
		return table[toChange][m-1];
	}
}
public class CoinChangeDemo
{
	public static void main(String[] args)
	{
		int arr[]={1,2,3,5,8,20};
		int n=4000;
		CoinChange c=new CoinChange(arr,n);
		System.out.println(c.getNumOfWayToChange());
	}
}