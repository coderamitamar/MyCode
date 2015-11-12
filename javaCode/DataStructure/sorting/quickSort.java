package sorting;
public class quickSort
{
	public int partition(int A[],int beg,int end)
	{
		int loc=beg,i=beg,j=end,temp;
		boolean flag=false;
		while(flag!=true)
		{
			while(A[loc]<=A[j] && loc!=j)	j--;
			if(loc==j)	flag=true;
			else
			{
				temp=A[loc];
				A[loc]=A[j];
				A[j]=temp;
				loc=j;
			}
			if(flag!=true)
			{
				while(A[loc]>=A[i] && loc!=i)	i++;
				if(loc==i)	flag=true;
				else
				{
					temp=A[loc];
					A[loc]=A[i];
					A[i]=temp;
					loc=i;
				}
			}
		}
		return loc;
	}
	public void qckSort(int A[],int p,int r)
	{
		int pivot;
		if(p<r)
		{
			pivot=partition(A,p,r);
			qckSort(A,p,pivot-1);
			qckSort(A,pivot+1,r);
		}
	}
}
