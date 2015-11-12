/*
	NAME:- Checking for the majority of an element in the given sorted array
	AUTHOR:- Amit Kumar Amar
	DATE:- 02-10-2014
	LOC:- 109
	COMPLEXITY:-
	    FIRST FUNCTION:-  O(n)
	    SECOND FUNCTION:- O(logn)
*/
#include<stdio.h>
#include<conio.h>
int isMajority1(int [],int,int);
int isMajority2(int [],int,int);
int main()
{
	int i,signal=0,item=0,size=0;
	printf("Enter the size of the array: ");
	scanf("%d",&size);
	if(size<=0)
	{
		printf("MESSAGE:-\n\tNo processing can be done for zero size array\n");
		getch();
		return 0;
	}
	int arr[size];
	printf("Start entering the data of array\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr+i);
	printf("Enter the item whoose majority is to be checked: ");
	scanf("%d",&item);
	//By isMajority1
	printf("By isMajority1():\n");
	signal=isMajority1(arr,size,item);
	if(signal==1)
	    printf("\tYes, %d is in majority in the given array\n",item);
	if(signal==-1)
	    printf("\tNo, %d is not in majority in the given array\n",item);
	//By isMajority2
	printf("By isMajority2():\n");
	signal=0;
	signal=isMajority2(arr,size,item);
	if(signal==1)
	    printf("\tYes, %d is in majority in the given array\n",item);
	if(signal==-1)
	    printf("\tNo, %d is not in majority in the given array\n",item);
	getch();
	return 0;
}
int isMajority1(int arr[],int size,int item)
{
	int i;
	if(size<=0)
	{
		printf("ERROR:-\n\tArray is empty\n");
		return -2;
	}
	for(i=0;i<size;i++)
	    if(arr[i]==item)
	        break;
	if(i==size)
	{
		printf("MESSAGE:-\n\tElement not found\n");
		return -2;
	}
	if((i+size/2)<size)
		if(arr[i+size/2]==item)
	    	return 1;
		else
	    	return -1;
	else
	    return -1;
}
int isMajority2(int arr[],int size,int item)
{
	int index;
	if(size<=0)
	{
		printf("ERROR:-\n\tArray is empty\n");
		return -2;
	}
	index=binarySearch(arr,0,size-1,item);
	if(index==-1)
	{
		printf("MESSAGE:-\n\tElement not found\n");
		return -2;
	}
	if((index+size/2)<size)
		if(arr[index+size/2]==item)
	    	return 1;
		else
	    	return -1;
	else
	    return -1;
}
int binarySearch(int arr[],int low,int high,int x)
{
	if(low<=high)
	{
        int mid=(low+high)/2;
        if((mid==0||arr[mid-1]<x)&&arr[mid]==x)
            return mid;
		else if(x>arr[mid])
		    return binarySearch(arr,mid+1,high,x);
		else
		    return binarySearch(arr,low,mid-1,x);
	}
	else
	    return -1;
}
