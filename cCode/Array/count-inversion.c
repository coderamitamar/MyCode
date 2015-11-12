/*
	NAME:-Counting inversions in an array
	AUTHOR:-Amit Kumar Amar
	PURPOSE:-It counts number of inversions should take place in order to sort an array
	DATE:- 30-09-2014
	NO. OF LINES:- 72
*/
#include<stdio.h>
#include<conio.h>
int countInversion1(int [],int);
int countInversion2(int [],int);
int mergeSort(int [],int [],int,int);
int merge(int [],int [],int,int,int);
int main()
{
	int i,size=0;
	printf("Enter the size of the array: ");
	scanf("%d",&size);
	int arr[size];
	printf("Start entering the data\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr+i);
	printf("By countInversion1\n\tNo. of Inversions= %d\n",countInversion1(arr,size));
	printf("By countInversion2\n\tNo. of Inversions= %d\n",countInversion2(arr,size));
	getch();
	return 0;
}
int countInversion1(int arr[],int size)
{
	int i,j,inv_count=0;
	for(i=0;i<size-1;i++)//Selecting an element
	    for(j=i+1;j<size;j++)//Checking for the inversion for that element
			if(arr[i]>arr[j])//Condition for inversion
				inv_count++;//If inversion should take place then count it
	return inv_count;
}
int countInversion2(int arr[],int size)
{
	int temp[size];
	return mergeSort(arr,temp,0,size-1);
}
int mergeSort(int arr[],int temp[],int left,int right)
{
	int inv_count=0;
	if(right>left)
	{
		inv_count=mergeSort(arr,temp,left,(left+right)/2);
		inv_count+=mergeSort(arr,temp,(left+right)/2+1,right);
		inv_count+=merge(arr,temp,left,(left+right)/2+1,right);
	}
	return inv_count;
}
int merge(int arr[],int temp[],int low,int mid,int high)
{
	int i=low,j=mid,k=low,inv_count=0;
	while((i<=mid-1)&&(j<=high))
	{
		if(arr[i]<=arr[j])
		    temp[k++]=arr[i++];
		else
		{
			temp[k++]=arr[j++];
			inv_count+=(mid-i);
		}
	}
	while(i<=mid-1)
		temp[k++]=arr[i++];
	while(j<=high)
		temp[k++]=arr[j++];
	for(i=low;i<=high;i++)
	    arr[i]=temp[i];
	return inv_count;
}
