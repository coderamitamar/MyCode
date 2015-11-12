/*
	NAME:- Sorting array according to frequency
	AUTHOR:- Amit Kumar Amar
	DATE:- 29-09-2014
	No. of lines:- 147
*/
#include<stdio.h>
#include<conio.h>
void sortByFrequency(int [],int);
void mergeSort(int [],int [],int,int,int);
void merge(int [],int [],int,int,int,int);
void print(int [],int,int);
int main()
{
	int i,size;
	printf("Enter the size of the array\n");
	scanf("%d",&size);
	int arr[size];
	printf("Start entering the elements of the array\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr+i);
	printf("Array sorted according to the frecuency is\n");
	sortByFrequency(arr,size);
	print(arr,0,size-1);
	getch();
	return 0;
}
void sortByFrequency(int arr[],int size)
{
	int i,j=0,k=0,low,high,count=1,arr1[size],arr2[size],arr3[size],arr4[size];
	for(i=0;i<size;i++)
	{
		arr1[i]=arr[i];//Copying the given array into arr1
	    arr2[i]=i;//Saving the indices of elements in original array
	}
	mergeSort(arr1,arr2,0,size-1,1);//Sorting arr1 and arr2 according to array arr1
	for(i=0;i<size-1;i++)
	{//Now making the array arr4 for frequency of an element
	 //And arr3 for index of first occuring of the element
		if(arr1[i]!=arr1[i+1])
		{
			arr3[j]=arr2[i];//arr3 and arr2 are the array of indices
			arr4[j++]=count;//array of frequency  j is the number of different element
			count=1;
		}
		else
		    count++;
	}
	arr3[j]=arr2[i];
	arr4[j++]=count;
	mergeSort(arr4,arr3,0,j-1,1);//Sorting arr3 and arr4 according to array arr4
	for(i=0;i<j;i++)
	{//Checking for the frequency tie of two elements
	 //If tie occurs then the element which came first in original array
	 //will come first in sorted array also
		if(arr4[i]==arr4[i+1])
		{
			k=low=i;
			while(arr4[k]==arr4[k+1])
			    k++;
			high=k;
			mergeSort(arr3,arr4,low,high,2);
			i=k;
		}
	}
	count=0;
	for(i=0;i<j;i++)
	{//making the sorted array from frequency and indices array
		for(k=0;k<arr4[i];k++)
		    arr2[count++]=arr[arr3[i]];
	}
	for(i=0;i<size;i++)//making original array ready therefor it can be returned
	    arr[size-i-1]=arr2[i];
}
void mergeSort(int arr1[],int arr2[],int low,int high,int flag)
{
	if(low==high)
	    return;
	else
	{
		mergeSort(arr1,arr2,low,(low+high)/2,flag);
        mergeSort(arr1,arr2,(low+high)/2+1,high,flag);
        merge(arr1,arr2,low,(low+high)/2,high,flag);
	}
}
void merge(int arr1[],int arr2[],int low,int mid,int high,int flag)
{
	int i=low,j=mid+1,index=0,left,right,temp[2][high-low+1];
	while(i<=mid&&j<=high)
	{
		if(flag==1)//flag=1 indicates increasing order
			if(arr1[i]>=arr1[j])
			{
				temp[0][index]=arr1[j];
            	temp[1][index++]=arr2[j++];
			}
			else
			{
				temp[0][index]=arr1[i];
				temp[1][index++]=arr2[i++];
			}
		else//Case for decreasing order
		    if(arr1[i]<=arr1[j])
			{
				temp[0][index]=arr1[j];
            	temp[1][index++]=arr2[j++];
			}
			else
			{
				temp[0][index]=arr1[i];
				temp[1][index++]=arr2[i++];
			}
	}
	if(i==mid+1)
	{
		left=j;
		right=high;
	}
	else
	{
		left=i;
		right=mid;
	}
	for(i=left;i<=right;i++)
	{
		temp[0][index]=arr1[i];
		temp[1][index++]=arr2[i];
	}
	for(i=0;i<index;i++)
	{
		arr1[low+i]=temp[0][i];
		arr2[low+i]=temp[1][i];
	}
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
/*
	There is two more methods:-
	1> By BST:-
		In this sorting of original array, finding frequency is done by bst
		Each node contains a element, its frequency and its first occurence
		Rest of the part is done in the same way as above
	2> By Hashing
*/
