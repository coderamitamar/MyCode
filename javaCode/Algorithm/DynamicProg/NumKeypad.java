package DynamicProg;

public class NumKeypad
{
	long T[][]=new long[30][10];
	NumKeypad()
	{
		fillTable();
	}
	public long getCount(int len)
	{
		long sum=0;
		for(int i=0;i<10;i++)
			sum+=T[len-1][i];
		return sum;
	}
	public void fillTable()
	{
		for(int i=0;i<10;i++)	T[0][i]=1;
		for(int k=1;k<30;k++)
		{
			T[k][0]=T[k-1][0]+T[k-1][8];
			T[k][1]=T[k-1][1]+T[k-1][2]+T[k-1][4];
			T[k][2]=T[k-1][1]+T[k-1][2]+T[k-1][3]+T[k-1][5];
			T[k][3]=T[k-1][2]+T[k-1][3]+T[k-1][6];
			T[k][4]=T[k-1][1]+T[k-1][4]+T[k-1][5]+T[k-1][7];
			T[k][5]=T[k-1][2]+T[k-1][4]+T[k-1][5]+T[k-1][6]+T[k-1][8];
			T[k][6]=T[k-1][3]+T[k-1][5]+T[k-1][6]+T[k-1][9];
			T[k][7]=T[k-1][4]+T[k-1][7]+T[k-1][8];
			T[k][8]=T[k-1][0]+T[k-1][5]+T[k-1][7]+T[k-1][8]+T[k-1][9];
			T[k][9]=T[k-1][6]+T[k-1][8]+T[k-1][9];
		}
	}
	public static void main(String[] args)
	{
		NumKeypad n=new NumKeypad();
		System.out.println(n.getCount(20));//getCount(startNum,len);
	}
}

/*
 * initially done by me 
 * the below code was written in the above class
int m[][]={
		{1,1,1},
		{1,1,1},
		{1,1,1},
		{0,1,0}
	  };
public void fillTable1()
{
	int i,j,r;
	for(i=0;i<10;i++)	T[0][i]=1;
	for(int k=1;k<30;k++)
	{
		i=-1;
		j=0;
		T[k][0]=T[k-1][0]+T[k-1][8];
		for(r=1;r<10;r++)
		{
			if(r%3==1)
			{
				i++;
				j=-1;
			}
			j++;
			T[k][r]=sumUp(i,j,k-1);
		}
	}
}
public long sumUp(int i,int j,int k)
{
	long sum=0;
	if((j-1)>=0)
		sum=T[k][3*i+j];
	if((j+1)<=2)
		sum+=T[k][3*i+j+2];
	if((i-1)>=0)
		sum+=T[k][3*(i-1)+j+1];
	if((i+1)<=2)
		sum+=T[k][3*(i+1)+j+1];
	sum+=T[k][3*i+j+1];
	if((3*i+j+1)==8)
		sum+=T[k][0];
	return sum;
}
*/