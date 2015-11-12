/*
	NAME:- Finding k largest/smallest elements in the array
	AUTHOR:- Amit Kumar Amar
	DATE:- 03-10-2014
	LOC:- 422
	COMPLEXITY:-
	    FIRST FUNCTION:-  O(nk)
	    SECOND FUNCTION:- O((n-k)*k)
	    THIRD FUNCTION:-  O(nlogn)
	    FOURTH FUNCTION:- O(nlogn)
	    FIFTH FUNCTION:-  O(k+(n-k)logk)
*/
#include<stdio.h>
#include<conio.h>
int kLargest1(int [],int,int,int);
int kLargest2(int [],int,int,int);
int kLargest3(int [],int,int,int);
int kLargest4(int [],int,int,int);
int kLargest5(int [],int,int,int);
void mergeSort(int [],int,int);
void merge(int [],int,int,int);
void heapify(int [],int,int);
int cutRootMin(int [],int);
int cutRootMax(int [],int);
void swap(int *,int *);
int minOfArr(int [],int,int);
int maxOfArr(int [],int,int);
int main()
{
	int signal=0,i,size,ls,k;
	printf("Enter the size of array: ");
	scanf("%d",&size);
	if(size<=0)
	{
        printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
		getch();
		return -1;
	}
	int arr1[size],arr2[size],arr3[size],arr4[size],arr5[size];
	printf("Start entering the data of the array\n");
	for(i=0;i<size;i++)
	{
		scanf("%d",arr1+i);
		arr2[i]=arr3[i]=arr4[i]=arr5[i]=arr1[i];
	}
	printf("Enter the number of elements to be selected: ");
	scanf("%d",&k);
	printf("Enter the choice\n1>k largest\n2>k smallest\nchoice: ");
    scanf("%d",&ls);
	//By first function
	printf("By kLargest1():\n\t");
	signal=kLargest1(arr1,size,k,ls);
	if(signal==1)
		for(i=size-k;i<size;i++)
	    	printf("%d\t",arr1[i]);
    if(signal==2)
		for(i=0;i<k;i++)
	    	printf("%d\t",arr1[i]);
	//By second function
	printf("\nBy kLargest2():\n\t");
	signal=0;
	signal=kLargest2(arr2,size,k,ls);
	if(signal==1)
		for(i=size-k;i<size;i++)
	    	printf("%d\t",arr2[i]);
    if(signal==2)
		for(i=0;i<k;i++)
	    	printf("%d\t",arr2[i]);
	//By third function
	printf("\nBy kLargest3():\n\t");
	signal=0;
	signal=kLargest3(arr3,size,k,ls);
	if(signal==1)
		for(i=size-k;i<size;i++)
	    	printf("%d\t",arr3[i]);
    if(signal==2)
		for(i=0;i<k;i++)
	    	printf("%d\t",arr3[i]);
	//By fourth function
	printf("\nBy kLargest4():\n\t");
	signal=0;
	signal=kLargest4(arr4,size,k,ls);
	if(signal==1)
		for(i=size-k;i<size;i++)
	    	printf("%d\t",arr4[i]);
    if(signal==2)
		for(i=0;i<k;i++)
	    	printf("%d\t",arr4[i]);
	//By fifth function
	printf("\nBy kLargest5():\n\t");
	signal=0;
	signal=kLargest5(arr5,size,k,ls);
	if(signal==1)
		for(i=size-k;i<size;i++)
	    	printf("%d\t",arr5[i]);
    if(signal==2)
		for(i=0;i<k;i++)
	    	printf("%d\t",arr5[i]);
	getch();
	return 0;
}
//By first function
int kLargest1(int arr[],int size,int k,int ls)//ls=signal for largest or smallest
{//By k bubble method
	int i,j;
    if(size<=0)
	{
		printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
		return -1;
	}
	if(k<=0||k>size)
	{
		printf("MESSAGE:-\n\t");
		printf("k can't be negative or more than the size of array\n");
		return -1;
	}
	if(ls==1)//main body of the function
	{//Bubbling k largest elements to the rightmost part of the array
		for(i=size-2;i>=0;i--)
		    for(j=size-1;j>=size-k;j--)
		        if(arr[i]>arr[j])
		            swap(arr+i,arr+j);
		return 1;
	}
	else if(ls==2)
	{//Bubbling k smallest elements to the leftmost part of the array
		for(i=1;i<size;i++)
		    for(j=0;j<k;j++)
		        if(arr[i]<arr[j])
		            swap(arr+i,arr+j);
		return 2;
	}
	else
	{
		printf("ERROR:-\n\tWrong input for largest/smallest signal\n");
		return -1;
	}
}
//By second function
int kLargest2(int arr[],int size,int k,int ls)//ls=signal for largest or smallest
{
	int i,min_index,max_index;
    if(size<=0)
	{
		printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
		return -1;
	}
	if(k<=0||k>size)
	{
		printf("MESSAGE:-\n\t");
		printf("k can't be negative or more than the size of array\n");
		return -1;
	}
	if(ls==1)//main body of the function
	{//for each element of leftmost size-k elements
	 //It selects minimum from rightmost k elements
	 //if minimum is less than selected element then swaps it
	 // Similar case for ls=2
		for(i=0;i<size-k;i++)
		{
			min_index=minOfArr(arr,size-k,size-1);
			if(arr[i]>arr[min_index])
				swap(arr+i,arr+min_index);
		}
		return 1;
	}
	else if(ls==2)
	{
		for(i=k;i<size;i++)
		{
			max_index=maxOfArr(arr,0,k-1);
			if(arr[i]<arr[max_index])
				swap(arr+i,arr+max_index);
		}
		return 2;
	}
	else
	{
		printf("ERROR:-\n\tWrong input for largest/smallest signal\n");
		return -1;
	}
}
//By third function
int kLargest3(int arr[],int size,int k,int ls)//ls=signal for largest or smallest
{
    if(size<=0)
	{
		printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
		return -1;
	}
	if(k<=0||k>size)
	{
		printf("MESSAGE:-\n\t");
		printf("k can't be negative or more than the size of array\n");
		return -1;
	}
	if(ls==1)//main body of the function
	{//it simply sorts the complete array
		mergeSort(arr,0,size-1);
		return 1;
	}
	else if(ls==2)
	{
		mergeSort(arr,0,size-1);
		return 2;
	}
	else
	{
		printf("ERROR:-\n\tWrong input for largest/smallest signal\n");
		return -1;
	}
}
//By fourth function
int kLargest4(int arr[],int size,int k,int ls)//ls=signal for largest or smallest
{
	int i;
    if(size<=0)
	{
		printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
		return -1;
	}
	if(k<=0||k>size)
	{
		printf("MESSAGE:-\n\t");
		printf("k can't be negative or more than the size of array\n");
		return -1;
	}
	if(ls==1)//main body of the function
	{//First creates the max heap
	 //Then it consicutively cuts k roots and add them at the end of the array
	 //Similar case for ls=2
		for(i=0;i<size;i++)
		    heapify(arr,i,2);
		for(i=0;i<size;i++)
		    arr[size-i-1]=cutRootMax(arr,size-i);
		return 1;
	}
	else if(ls==2)
	{
		for(i=0;i<size;i++)
		    heapify(arr,i,1);
		for(i=0;i<size;i++)
		    arr[size-i-1]=cutRootMin(arr,size-i);
		for(i=0;i<k;i++)
			swap(arr+i,arr+size-i-1);
		return 2;
	}
	else
	{
		printf("ERROR:-\n\tWrong input for largest/smallest signal\n");
		return -1;
	}
}
//By fifth function
int kLargest5(int arr[],int size,int k,int ls)//ls=signal for largest or smallest
{
	int i,min,max;
    if(size<=0)
	{
		printf("MESSAGE:-\n\t");
		printf("No processing can be done for zero or negative size array\n");
		return -1;
	}
	if(k<=0||k>size)
	{
		printf("MESSAGE:-\n\t");
		printf("k can't be negative or more than the size of array\n");
		return -1;
	}
	if(ls==1)//main body of the function
	{//it is simply extension of method 2
	 //in place of finding minimum, it just cuts the root of min heap
	 //Similar case for ls=2
		for(i=0;i<k;i++)
		    heapify(arr,i,1);
		for(i=k;i<size;i++)
		    if(arr[i]>arr[0])
		    {
				swap(arr,arr+i);
				min=cutRootMin(arr,k);
				arr[k-1]=min;
				heapify(arr,k-1,1);
		    }
		for(i=0;i<k;i++)
		    swap(arr+i,arr+size-i-1);
		return 1;
	}
	else if(ls==2)
	{
		for(i=0;i<k;i++)
		    heapify(arr,i,2);
		for(i=k;i<size;i++)
		    if(arr[i]<arr[0])
		    {
				swap(arr,arr+i);
				max=cutRootMax(arr,k);
				arr[k-1]=max;
				heapify(arr,k-1,2);
		    }
		return 2;
	}
	else
	{
		printf("ERROR:-\n\tWrong input for largest/smallest signal\n");
		return -1;
	}
}
void mergeSort(int arr[],int low,int high)
{
	if(low<high)
	{
		mergeSort(arr,low,(low+high)/2);
        mergeSort(arr,(low+high)/2+1,high);
        merge(arr,low,(low+high)/2,high);
	}
}
void merge(int arr[],int low,int mid,int high)
{
	int left=low,right=mid+1,k=0,temp[high-low+1];
	while(left<=mid&&right<=high)
	    if(arr[left]<arr[right])
	        temp[k++]=arr[left++];
		else
		    temp[k++]=arr[right++];
 	while(left<=mid)
	    temp[k++]=arr[left++];
	while(right<=high)
	    temp[k++]=arr[right++];
	for(left=low,k=0;left<=high;left++,k++)
	    arr[left]=temp[k];
}
void heapify(int arr[],int index,int minmax)//minmax indicates minheap/maxheap i.e 1/2
{//minmax=1=>minheap and minmax=2=> maxheap
	int val=arr[index];
	if(minmax==1)
		for(;(index>0)&&(arr[index/2]>val);index/=2)
			arr[index]=arr[index/2];
	else
		for(;(index>0)&&(arr[index/2]<val);index/=2)
			arr[index]=arr[index/2];
	arr[index]=val;
}
int cutRootMin(int arr[],int size)
{
	int val=arr[0],prt=0,left=1,right=2;
	arr[0]=arr[size-1];
	while(left<size-1)
	{
		if(arr[prt]<=arr[left]&&arr[prt]<=arr[right])
		    return val;
		else if(arr[left]<=arr[right])
		{
			swap(arr+prt,arr+left);
			prt=left;
		}
		else
		{
			swap(arr+prt,arr+right);
			prt=right;
		}
		left=2*prt;
		right=left+1;
	}
	return val;
}
int cutRootMax(int arr[],int size)
{
	int val=arr[0],prt=0,left=1,right=2;
	arr[0]=arr[size-1];
	while(left<size-1)
	{
		if(arr[prt]>=arr[left]&&arr[prt]>=arr[right])
		    return val;
		else if(arr[left]>=arr[right])
		{
			swap(arr+prt,arr+left);
			prt=left;
		}
		else
		{
			swap(arr+prt,arr+right);
			prt=right;
		}
		left=2*prt;
		right=left+1;
	}
	return val;
}
void swap(int *a,int *b)
{
	int temp;
	temp=*a;
	*a=*b;
	*b=temp;
}
int minOfArr(int arr[],int low,int high)
{
	int index=low,min=arr[low];
	while((++low)<=high)
		if(arr[low]<min)
		{
			index=low;
			min=arr[low];
	    }
	return index;
}
int maxOfArr(int arr[],int low,int high)
{
	int index=low,max=arr[low];
	while((++low)<=high)
	    if(arr[low]>max)
	    {
			index=low;
			max=arr[low];
	    }
	return index;
}
