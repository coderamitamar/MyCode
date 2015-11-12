/*
	NAME:- Segregating all zeros and ones in the array
	AUTHOR:- Amit Kumar Amar
	DATE:- 02-10-2014
	LOC:- 90
	COMPLEXITY:-
	    FIRST FUNCTION:-  O(n)
	    SECOND FUNCTION:- O(n)
*/
#include<stdio.h>
#include<conio.h>
int segregate1(int [],int);//by counting
int segregate2(int [],int);//sorting
int main()
{
    int i,size=0;
	printf("Enter the size of array: ");
	scanf("%d",&size);
	if(size<0)
	    size=0;
	int arr[size],brr[size];
	if(size>0)
		printf("Start entering the data of the array\n");
	for(i=0;i<size;i++)
	{
		scanf("%d",arr+i);
		brr[i]=arr[i];
	}
	//By first function
	printf("By segregate1():\n");
	if(segregate1(arr,size))
	{
		printf("Segregated array is:\n");
		for(i=0;i<size;i++)
	    	printf("%d\t",arr[i]);
	}
	else
	{
		printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
	}
	//By second function
	printf("\nBy segregate2():\n");
    if(segregate2(brr,size))
	{
		printf("Segregated array is:\n");
		for(i=0;i<size;i++)
	    	printf("%d\t",brr[i]);
	}
	else
	{
		printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
	}
	getch();
	return 0;
}
int segregate1(int arr[],int size)
{
	int i,count=0;
	if(size<=0)
	    return 0;
	for(i=0;i<size;i++)//count number of zeros in the array
	    if(arr[i]==0)
	        count++;
	for(i=0;i<count;i++)//place all zeros in the leftmost part of the array
	    arr[i]=0;
	for(;i<size;i++)//place (size-count) number of one's in the rightmost part of array
	    arr[i]=1;
	return 1;
}
int segregate2(int arr[],int size)
{
	int left=0,right=size-1;
	if(size<=0)
	    return 0;
	while(left<right)//traversing the complete array once
	{
		while(arr[left]==0&&left<right)//increament left untill 1 encounters
			left++;
		while(arr[right]==1&&left<right)//decreament right untill 0 encounters
			right--;
		if(left<right)//swap values
		{
			arr[left++]=0;
			arr[right--]=1;
		}
	}
	return 1;
}
