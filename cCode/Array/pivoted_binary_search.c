#include<stdio.h>
#include<conio.h>
//Recursive way to search the element in the rotated array
int pivoted_binary_search_recursive(int [],int,int,int,int);
//Iterative way to search the element in the rotated array
int pivoted_binary_search_iterative(int [],int,int);
/*
	There is one more way to do this job and that is by finding pivot node first.
	1> Write a function find_pivot_node which finds the pivot node
	2> Write a function binary_search
	3> Write a function pivoted_binary_search that co-ordinates both the above written functions
		a> first invoke find_pivot_node to find the pivot node and then
		b> invoke binary_search function to search in that part which contains the search item
																									*/
int main()
{
	int recursive,iterative,size,item;
	printf("Enter the size of array: ");
	scanf("%d",&size);
	int arr[size];
	printf("Start entering the elements\n");
	for(iterative=0;iterative<size;iterative++)//iterative is temporarily used as counter
	    scanf("%d",arr+iterative);
	printf("Enter the element to be searched: ");//take the element to be searched
	scanf("%d",&item);
	//recursive gives index of item in arr by recursive search method
	recursive=pivoted_binary_search_recursive(arr,item,0,(size-1)/2,size-1);
	//iterative gives index of item in arr by iterative search method
	iterative=pivoted_binary_search_iterative(arr,size,item);
    printf("%d\t%d\n",recursive,iterative);
	getch();
	return 0;
}
int pivoted_binary_search_recursive(int arr[],int item,int low,int mid,int high)
{
	int k=-2;
	if(low==high)
	    if(arr[low]==item)
	        return low;
		else return -1;
	else if(low+1==high)
	    if(arr[low]==item)
	        return low;
		else if(arr[high]==item)
		    return high;
		else return -1;
	else
	{
		if(arr[mid]==item)
		    return mid;
		else if(arr[low]<=arr[mid])
		{
			if(arr[low]<=item&&item<arr[mid])
			    k=pivoted_binary_search_recursive(arr,item,low,(low+mid-1)/2,mid-1);
			else k=pivoted_binary_search_recursive(arr,item,mid+1,(mid+1+high)/2,high);
		}
		else
		{
			if(arr[mid]<item&&item<=arr[high])
			    k=pivoted_binary_search_recursive(arr,item,mid+1,(mid+1+high)/2,high);
			else k=pivoted_binary_search_recursive(arr,item,low,(low+mid-1)/2,mid-1);
		}
	}
	if(k==-1)
	{
        if(arr[mid]==item)
		    return mid;
		else if(arr[low]>=arr[mid])
		{
			if(arr[low]>=item&&item>arr[mid])
			    k=pivoted_binary_search_recursive(arr,item,low,(low+mid-1)/2,mid-1);
			else k=pivoted_binary_search_recursive(arr,item,mid+1,(mid+1+high)/2,high);
		}
		else
		{
			if(arr[mid]>item&&item>=arr[high])
			    k=pivoted_binary_search_recursive(arr,item,mid+1,(mid+1+high)/2,high);
			else k=pivoted_binary_search_recursive(arr,item,low,(low+mid-1)/2,mid-1);
		}
		return k;
	}
}
int pivoted_binary_search_iterative(int arr[],int size,int item)
{
	int mid,low=0,high=size-1;
	while(low<=high)
	{
		mid=(low+high)/2;
		if(arr[mid]==item)
		    return mid;
		else if(arr[low]<=arr[mid])
		{
			if(arr[low]<=item&&item<arr[mid])
			    high=mid-1;
			else
			    low=mid+1;
		}
		else
		{
			if(arr[mid]<item&&item<=arr[high])
			    low=mid+1;
			else
			    high=mid-1;
		}
	}
	low=0;
	high=size-1;
	while(low<=high)
	{
        mid=(low+high)/2;
		if(arr[mid]==item)
		    return mid;
		else if(arr[low]>=arr[mid])
		{
			if(arr[low]>=item&&item>arr[mid])
			    high=mid-1;
			else
			    low=mid+1;
		}
		else
		{
			if(arr[mid]>item&&item>=arr[high])
			    low=mid+1;
			else
			    high=mid-1;
		}
	}
	return -1;
}
