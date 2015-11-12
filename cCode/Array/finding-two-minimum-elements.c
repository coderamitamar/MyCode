/*
	NAME:- Finding the minimum and second minimum elements in the array
	AUTHOR:- Amit Kumar Amar
	DATE:- 02-10-2014
	LOC:- 95
	COMPLEXITY:-
	    FIRST FUNCTION:- O(n)
		SECOND FUNCTION:-O(m) //where m is maximum value element in the array
*/
#include<stdio.h>
#include<conio.h>
#include<limits.h>
#define HASH_SIZE 101
int findTwoMinElements1(int [],int [],int);
int findTwoMinElements2(int [],int [],int);
int main()
{
	int i,signal,size,res[2];
	printf("Enter the size of the array: ");
	scanf("%d",&size);
	int arr[size];
	printf("Start entering the data\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr+i);
	    //By first function
	printf("By findTwoMinElements1():\n");
	signal=findTwoMinElements1(arr,res,size);
	if(signal==1)
		printf("\t\tmin=%d\n\t\tScond min=%d\n",res[0],res[1]);
	    //By second function
	printf("By findTwoMinElements2():\n");
	signal=findTwoMinElements2(arr,res,size);
	if(signal==1)
		printf("\t\tmin=%d\n\t\tScond min=%d",res[0],res[1]);
    getch();
	return 0;
}
int findTwoMinElements1(int arr[],int res[],int size)
{
	int i,min,smin;
	if(size<2)
	{
		printf("ERROR:\n\tNumber of elements is less than 2\n");
		return -1;
	}
	min=smin=INT_MAX;
	for(i=0;i<size;i++)
	{
		if(min>arr[i])
		{
			smin=min;
			min=arr[i];
		}
		else if(smin>arr[i]&&min!=arr[i])
		    smin=arr[i];
	}
	if(smin==INT_MAX)
	{
		printf("MESSAGE:-\n\tAll elements are same in the array\n");
		return 0;
	}
	else
	{
		res[0]=min;
		res[1]=smin;
		return 1;
	}
}
int findTwoMinElements2(int arr[],int res[],int size)
{
	int i,counter=0;
	int hash[HASH_SIZE]={0};
	if(size<2)
	{
		printf("ERROR:\n\tNumber of elements is less than 2\n");
		return -1;
	}
	for(i=0;i<size;i++)
		hash[arr[i]]=1;
	for(i=0;i<HASH_SIZE;i++)
	    if(hash[i]==1)
			if(counter==0)
				res[counter++]=i;
			else if(counter==1)
			    res[counter++]=i;
			else
			    break;
	if(counter==1)
	{
		printf("MESSAGE:-\n\tAll elements are same in the array\n");
		return 0;
	}
	else
	    return 1;
}
