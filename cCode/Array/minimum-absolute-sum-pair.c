/*
	NAME:- Finding the pair having minimum absolute sum
	AUTHOR:- Amit Kumar Amar
	DATE:- 02-10-2014
	LOC:- 134
	COMPLEXITY:-
	    FIRST FUNCTION:- O(n*n)
		SECOND FUNCTION:- O(nlogn)
*/
#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#define MAX_SIZE size/2+1
int minAbsSumPair1(int [],int [][2],int);
int minAbsSumPair2(int [],int [][2],int);
void quickSort(int [],int,int);
int partition(int [],int,int);
void swap(int *,int *);
int main()
{
	int i,size=0,index;
	printf("Enter the size of the array: ");
	scanf("%d",&size);
	int res[MAX_SIZE][2],arr[size];
	printf("Start entering the data\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr+i);
	//Demonstration by first function
	printf("By minAbsSumPair1():\n");
	index=minAbsSumPair1(arr,res,size);
	printf("\tMinimum Sum= %d\n",res[index][0]);
	printf("\t\tAND\n\tElements corresponding to this sum are:\n");
	for(i=0;i<index;i++)
		printf("\t\t(%d,%d)\n",arr[res[i][0]],arr[res[i][1]]);
	//Demonstration by first function
	printf("By minAbsSumPair2():\n");
	index=minAbsSumPair2(arr,res,size);
	printf("\tMinimum Sum= %d\n",res[index][0]);
	printf("\t\tAND\n\tElements corresponding to this sum are:\n");
	for(i=0;i<index;i++)
		printf("\t\t(%d,%d)\n",arr[res[i][0]],arr[res[i][1]]);
	getch();
	return 0;
}
int minAbsSumPair1(int arr[],int res[][2],int size)
{
	int i,j,index=0,sum,min_sum=abs(arr[0]+arr[1]);
	res[index][0]=0;
	res[index][1]=1;
	for(i=0;i<size-1;i++)//Selecting an element
	    for(j=i+1;j<size;j++)//checking every element for the picked one
	        if(min_sum>(sum=abs(arr[i]+arr[j])))//condition for finding min_sum pair
	        {
				res[index][0]=i;
				res[index][1]=j;
				min_sum=sum;
	        }
	index=1;
	for(i=0;i<size-1;i++)//Selecting an element
	    for(j=i+1;j<size;j++)//checking every element for the picked one
	        if(min_sum==abs(arr[i]+arr[j]))//condition for min_sum pairs
				if(res[0][0]!=i||res[0][1]!=j)
				{
					res[index][0]=i;
					res[index++][1]=j;
				}
	res[index][0]=min_sum;
	return index;
}
int minAbsSumPair2(int arr[],int res[][2],int size)
{
	int i=0,j=size-1,index=0,sum,min_sum=abs(arr[0]+arr[size-1]);
	res[index][0]=i;
	res[index][1]=j;
	quickSort(arr,0,size-1);
	while(i!=j)
	{
        sum=abs(arr[i]+arr[j]);
		if(min_sum>sum)//condition for finding min_sum pair
	    {
			res[index][0]=i;
			res[index][1]=j;
			min_sum=sum;
	    }
	    if(sum<0)
	    	i++;
		else
		    j--;
	}
	i=0;
	j=size-1;
	index=1;
    while(i!=j)
	{
        sum=arr[i]+arr[j];
		if(min_sum==abs(sum))//condition for finding min_sum pair
	    {
			if(res[0][0]!=i||res[0][1]!=j)
			{
				res[index][0]=i;
				res[index++][1]=j;
			}
	    }
	    if(sum>0)
	    	j--;
		else
		    i++;
	}
	res[index][0]=min_sum;
	return index;
}
void quickSort(int arr[],int si,int ei)//si=start index, ei=end index
{
	int pi;
	if(si<ei)
	{
		pi=partition(arr,si,ei);
		quickSort(arr,si,pi-1);
		quickSort(arr,pi+1,ei);
	}
}
int partition(int arr[],int si,int ei)
{
	int i=si-1,j,x=arr[ei];
	for(j=si;j<=ei-1;j++)
		if(arr[j]<=x)
			swap(arr+(++i),arr+j);
	swap(arr+i+1,arr+ei);
	return (i+1);
}
void swap(int *a, int *b)
{
  int temp;
  temp=*a;
  *a=*b;
  *b=temp;
}
