/*
	NAME:- Finding minimum and maximum with minimum comparisons
	AUTHOR:- Amit Kumar Amar
	DATE:- 02-10-2014
	LOC:- 188
	COMPLEXITY:-
	    FIRST FUNCTION:-  O(n)
	    SECOND FUNCTION:- O(n)
	    THIRD FUNCTION:-  O(n)
*/
#include<stdio.h>
#include<conio.h>
struct range
{
	int signal;
	int max;
	int min;
};
struct range findMinMax1(int [],int);
struct range findMinMax2(int [],int);
struct range findMinMax3(int [],int);
struct range tournament(int [],int,int);
int min(int,int);
int max(int,int);
int main()
{
    struct range minmax;
	int i,size=0;
	printf("Enter the size of array: ");
	scanf("%d",&size);
	if(size<0)
	    size=0;
	int arr[size];
	if(size>0)
		printf("Start entering the data of the array\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr+i);
	//By first function
	printf("By findMinMax1:\n");
	minmax=findMinMax1(arr,size);
	if(minmax.signal==1)
	    printf("\t\tMin=%d\n\t\tMax=%d\n",minmax.min,minmax.max);
	//By second function
	minmax.min=minmax.max=0;
	printf("By findMinMax2:\n");
	minmax=findMinMax2(arr,size);
	if(minmax.signal==1)
	    printf("\t\tMin=%d\n\t\tMax=%d\n",minmax.min,minmax.max);
	//By third function
	minmax.min=minmax.max=0;
	printf("By findMinMax3:\n");
	minmax=findMinMax3(arr,size);
	if(minmax.signal==1)
	    printf("\t\tMin=%d\n\t\tMax=%d\n",minmax.min,minmax.max);
	getch();
	return 0;
}
// By linear search
struct range findMinMax1(int arr[],int size)
{
	struct range minmax;
	int i;
	if(size<=0)
	{
		printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
		minmax.signal=-1;
		return minmax;
	}
	minmax.min=minmax.max=arr[0];
	for(i=1;i<size;i++)
	{
		minmax.min=min(minmax.min,arr[i]);
		minmax.max=max(minmax.max,arr[i]);
	}
	if(minmax.min==minmax.max)
	{
		minmax.signal=0;
		if(size==1)
		    printf("MESSAGE:-\n\tOnly one element is there in the array\n");
		else
		    printf("MESSAGE:-\n\tAll elements are same in the array\n");
	}
	else
	    minmax.signal=1;
	return minmax;
}
//By Tournament method
struct range findMinMax2(int arr[],int size)
{
	struct range minmax;
	if(size<=0)
	{
		printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
		minmax.signal=-1;
		return minmax;
	}
	minmax=tournament(arr,0,size-1);
	if(minmax.min==minmax.max)
	{
		minmax.signal=0;
		if(size==1)
		    printf("MESSAGE:-\n\tOnly one element is there in the array\n");
		else
		    printf("MESSAGE:-\n\tAll elements are same in the array\n");
	}
	else
	    minmax.signal=1;
	return minmax;
}
//By compairing in pairs
struct range findMinMax3(int arr[],int size)
{
	int i=0;
    struct range minmax;
	if(size<=0)
	{
		printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
		minmax.signal=-1;
		return minmax;
	}
	if(size%2==0)
	{
		minmax.min=min(arr[0],arr[1]);
		minmax.max=max(arr[0],arr[1]);
		i=2;
	}
	else
	{
		minmax.min=minmax.max=arr[0];
		i=1;
	}
	while(i<size-1)
	{
		minmax.min=min(min(arr[i],arr[i+1]),minmax.min);
		minmax.max=max(max(arr[i],arr[i+1]),minmax.max);
		i=i+2;
	}
	if(minmax.min==minmax.max)
	{
		minmax.signal=0;
		if(size==1)
		    printf("MESSAGE:-\n\tOnly one element is there in the array\n");
		else
		    printf("MESSAGE:-\n\tAll elements are same in the array\n");
	}
	else
	    minmax.signal=1;
	return minmax;
}
//tournamet function of findMinMax2()
struct range tournament(int arr[],int low,int high)
{
	struct range minmax,mml,mmr;//mml=minmax left, mmr=minmax right
	if(low==high)
	{//if only one element is there
		minmax.min=minmax.max=arr[low];
		return minmax;
	}
	else if(low+1==high)
	{//if only two elements are there
		minmax.min=min(arr[low],arr[high]);
		minmax.max=max(arr[low],arr[high]);
		return minmax;
	}
	else
	{
		mml=tournament(arr,low,(low+high)/2);//finding minmax of left part
		mmr=tournament(arr,(low+high)/2+1,high);//finding minmax of right part
		minmax.min=min(mml.min,mmr.min);//finding minimum of complete array
		minmax.max=max(mml.max,mmr.max);//finding maximum of complete array
		return minmax;
	}
}
int min(int a,int b)
{
	if(a<b)
	    return a;
	else
		return b;
}
int max(int a,int b)
{
	if(a>b)
	    return a;
	else
		return b;
}
