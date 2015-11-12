/*
	NAME:-Finding Leaders in the Array
	AUTHOR:- Amit Kumar Amar
	DATE:- 28-09-2014
	No. of lines= 110
	COMPLEXITY::
		findLeader1:    O(n*n)
		findLeader2:    O(n)
		findLeader3:    O(n)
*/
#include<stdio.h>
#include<conio.h>
int findLeader1(int [],int [],int);
int findLeader2(int [],int [],int);
int findLeader3(int [],int [],int,int);
void print(int [],int,int);
int main()
{
	int i,size,index1;
	printf("Enter the size of the array: ");
	scanf("%d",&size);
	int arr[size],lead[size];
	printf("Start entering the elements of array\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr+i);
    printf("Leaders of the given array are\n");
    printf("By findLeader1:\n");
	index1=findLeader1(arr,lead,size);
	print(lead,0,index1-1);
	printf("\nBy findLeader2:\n");
    index1=findLeader2(arr,lead,size);
	print(lead,0,index1-1);
    printf("\nBy findLeader3:\n");
    index1=findLeader3(arr,lead,0,size-1);
	print(lead,0,index1-1);
	getch();
    return 0;
}
int findLeader1(int arr[],int lead[],int size)
{
	//Simply checks for each element whether it is a leader or not
	//In outer loop it selects one element
	//In inner loop it checks whether the selected element is leader or not
 	int i,j,index=0;
 	for(i=0;i<size-1;i++)
 	{
			for(j=i+1;j<size;j++)
			{
				if(arr[j]<arr[i])
					continue;
				else
				    break;
			}
			if(j==size)
				lead[index++]=arr[i];
 	}
 	if(index>0)
 		lead[index++]=arr[size-1];
 	return index;
}
int findLeader2(int arr[],int lead[],int size)
{
	//It traverses from right
	//It manages a variable max
	//Whenever max changes its value it marks it as leader
	int i,index=0,max=arr[size-1];
    if(size>0)
	lead[index++]=arr[size-1];
	for(i=size-2;i>=0;i--)
	{
		if(max<arr[i])
			lead[index++]=max=arr[i];
		else
			continue;
	}
	return index;
}
int findLeader3(int arr[],int lead[],int low,int high)
{
	//It is a recursive implementation
	//it takes one element and finds the leader in its right
	//Then it compares the leader with current element
	//If current element is greater than leader then it is also a leader
	int temp=0;
	static int index=0;
	if(low>high)
		return -1;
	if(low==high)
	{
		lead[index++]=arr[low];
		return index;
	}
	temp=findLeader3(arr,lead,low+1,high);
	if(arr[low]>lead[temp-1])
	    lead[index++]=arr[low];
	return index;
}
void print(int arr[],int low,int high)
{
	//It prints the given array from low to high indices
	int i;
	if(low<0||high<0)
	    printf("ERROR:\n\tlow or high must not be negative");
	else if(low>high)
	    printf("ERROR:\nlow can't be grater then high");
	else
		for(i=0;i<=high;i++)
	    	printf("%d\t",arr[i]);
	return;
}
