package MathematicalAlgo;

public class MagicSquare
{
	int magic[][];
	int size;
	MagicSquare(int n)
	{
		size=n;
		magic=new int[size][size];
		buildMagicTable();
	}
	public void buildMagicTable()
	{
		int i=size/2;
		int j=size-1;
		int max=size*size;
		for(int num=1;num<=max;)
		{
			if(i==-1 && j==size)
			{
				i=0;
				j=size-2;
			}
			else
			{
				if(j>=size)
					j=0;
				if(i<0)
					i=size-1;
			}
			if(magic[i][j]!=0)
			{
				j-=2;
				i++;
				continue;
			}
			else
				magic[i][j]=num++;
			i--;
			j++;
		}
	}
	public void printMagicSqr()
	{
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
				System.out.format("%5d",magic[i][j]);
			System.out.println("");
		}
	}
	public static void main(String[] args)
	{
		MagicSquare ms=new MagicSquare(5);
		ms.printMagicSqr();
	}
}