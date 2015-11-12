#include<stdio.h>
#include<conio.h>
int max_subarray_sum(int [],int);
int max(int,int);
void MSubarray(int arr[],int msarr[],int low,int high);
void MCSubarray(int arr[],int lrc[],int low,int mid,int high);
int main()
{
	int i,size,msarr[3];
	printf("Enter the array size: ");
	scanf("%d",&size);
	int arr[size];
	printf("Start entering the elements of array\n");
	for(i=0;i<size;i++)
		scanf("%d",arr+i);
	printf("Using Kadane's Algorithm (Dyanamic paradigm)\n");
	printf("Max sum is: %d\n",max_subarray_sum(arr,size));
    printf("\nUsing Dyanamic Algorithm for finding max_subarray\n");
	MSubarray(arr,msarr,0,size-1);
	printf("Maximum subarray is arr[%d,%d] \nand sum of elements is %d",msarr[0],msarr[1],msarr[2]);
	getch();
	return 0;
}
int max_subarray_sum(int arr[],int size)/*Kadane's Algorithm*/
{
	int max_so_far=arr[0],curr_max=arr[0],i;
	for(i=1;i<size;i++)
	{
		curr_max=max(arr[i],curr_max+arr[i]);
		max_so_far=max(max_so_far,curr_max);
	}
	return max_so_far;
}
int max(int a,int b)
{
	return (a>b)?a:b;
}
void MSubarray(int arr[],int msarr[],int low,int high)
{/*lrc stands for left-right-cross e.i 0th,1st elements are for left and right index*/
	int mid,lrcl[3],lrcr[3],lrcc[3];/*and 2nd element is for cross sum*/
	if(high==low)       /*If only one element is there in the array*/
	{
		msarr[0]=low;
		msarr[1]=high;
		msarr[2]=arr[low];
	}
	else
	{
		mid=(low+high)/2;
		MSubarray(arr,lrcl,low,mid);/*Check for max subarray in left part*/
		MSubarray(arr,lrcr,mid+1,high);/*Check for max subarray in right part*/
		MCSubarray(arr,lrcc,low,mid,high);/*Check for max subarray in cross part*/
		if(lrcl[2]>lrcr[2]&&lrcl[2]>lrcc[2])/*If left part contains max subarray*/
		{
			msarr[0]=lrcl[0];
			msarr[1]=lrcl[1];
			msarr[2]=lrcl[2];
		}
		else if(lrcr[2]>lrcl[2]&&lrcr[2]>lrcc[2])/*If right part contains max subarray*/
        {
			msarr[0]=lrcr[0];
			msarr[1]=lrcr[1];
			msarr[2]=lrcr[2];
		}
		else/*If cross part contains max subarray*/
		{
			msarr[0]=lrcc[0];
			msarr[1]=lrcc[1];
			msarr[2]=lrcc[2];
		}
	}
}
void MCSubarray(int arr[],int lrc[],int low,int mid,int high)
{
	int i,leftsum=-999999,rightsum=-999999,sum=0,maxleft=0,maxright=0;
	for(i=mid;i>=low;i--)/*Check for max sum in left half*/
	{
		sum+=arr[i];
		if(sum>leftsum)
		{
			leftsum=sum;
			maxleft=i;
		}
	}
	sum=0;
	for(i=mid+1;i<=high;i++)/*Check for max sum in right half*/
	{
		sum+=arr[i];
		if(sum>rightsum)
		{
			rightsum=sum;
			maxright=i;
		}
	}
	lrc[0]=maxleft;
	lrc[1]=maxright;
	lrc[2]=leftsum+rightsum;
}
