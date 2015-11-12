package DynamicProg;

class MinCostPath
{
	private int costMtr[][];
	int res[][];
	int k,l;
	char path[][]=null;
	MinCostPath(int A[][])
	{
		costMtr=A;
	}
	public int getMinCost(int r,int s)
	{
		res=new int[r+1][s+1];
		path=new char[r+1][s+1];
		k=r;
		l=s;
		int min;
		boolean chk;
		for(int i=r;i>=0;i--)
		{
			chk=true;
			min=999999999;
			for(int j=s;j>=0;j--)
			{
				if(j+1<=s)
				{
					chk=false;
					min=res[i][j+1]+costMtr[i][j];
					path[i][j]='r';
					if(i+1<=r && (res[i+1][j+1]+costMtr[i][j])<min)
					{
						min=res[i+1][j+1]+costMtr[i][j];
						path[i][j]='d';
					}
				}
				if(i+1<=r && (res[i+1][j]+costMtr[i][j])<min)
				{
					chk=false;
					min=res[i+1][j]+costMtr[i][j];
					path[i][j]='b';
				}
				if(chk==true)
				{
					min=costMtr[i][j];
					path[i][j]='s';
				}
				res[i][j]=min;
			}
		}
		return res[0][0];
	}
	public String getMinPath()
	{
		String pathStr="Minimum path is not calculated!!!";
		if(path==null)
			return pathStr;
		else
		{
			pathStr="";
			for(int i=0;i<=k;)
			{
				for(int j=0;j<=l;)
				{
					pathStr+="("+i+","+j+")-->";
					if(path[i][j]=='r')
						j++;
					else if(path[i][j]=='d')
					{
						i++;
						j++;
					}
					else if(path[i][j]=='b')
						i++;
					else
					{
						i++;
						j++;
					}
				}
			}
			pathStr=pathStr.substring(0,pathStr.length()-3);
			return pathStr;
		}
	}
}
public class MinCostPathDemo
{
	public static void main(String[] args)
	{
		int cost[][]={ {1, 2, 3},
                	   {4, 8, 2},
                	   {1, 5, 3}
                	 };
		MinCostPath m=new MinCostPath(cost);
		System.out.println(m.getMinCost(2,2));
		System.out.println(m.getMinPath());
	}
}
