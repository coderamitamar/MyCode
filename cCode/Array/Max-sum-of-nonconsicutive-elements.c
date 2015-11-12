/*
	Name:- Finding the max sum in array such that no elements are consicutive
	Author:- Amit Kumar Amar
	Date:- 27-09-2014
	No. of lines:- 41 lines
*/
#include<stdio.h>
#include<conio.h>
int findMaxSum(int [],int);
int max(int,int);
int main()
{
	int size,i;
	printf("Enter the size of array: ");
	scanf("%d",&size);
	int arr[size];
	printf("Start entering the elements of array\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr+i);
	printf("Max sum in the given array is: %d",findMaxSum(arr,size));
	getch();
	return 0;
}
int findMaxSum(int arr[],int size)
{
	int i,incl=arr[0],excl=0,excl_new;
	for(i=1;i<size;i++)
	{
		excl_new=max(incl,excl);
		incl=excl+arr[i];
		excl=excl_new;
	}
	return max(incl,excl);
}
int max(int a,int b)
{
	if(a>b)
		return a;
	else
	    return b;
}
