#include<stdio.h>
#include<conio.h>
#define HASH_SIZE 100
void find_pair_by_hashmap(int [],int,int);
void find_pair_by_sorting(int [],int,int);
void bubble_sort(int [],int);
void swap(int *,int *);
int main()
{
	int i,size,sum_required;
	printf("Enter the no. of elements: ");
	scanf("%d",&size);
	int arr[size];
	printf("Enter all elements of the array\n");
	for(i=0;i<size;i++)
		scanf("%d",&arr[i]);
	printf("Enter the value of sum to be found: ");
	scanf("%d",&sum_required);
	printf("Pairs are (By Hash map):\n");
	find_pair_by_hashmap(arr,size,sum_required);
	printf("Pairs are (By sorting):\n");
	find_pair_by_sorting(arr,size,sum_required);
	getch();
	return 0;
}
void find_pair_by_hashmap(int arr[],int size,int sum)
{
	int i,temp,hashMap[HASH_SIZE]={0};
	for(i=0;i<size;i++)
	{
		temp=sum-arr[i];
		if(temp>=0&&hashMap[temp]==1)
			printf("(%d,%d)\n",arr[i],temp);
		else
			hashMap[arr[i]]=1;
	}
}
void find_pair_by_sorting(int arr[],int size,int sum)
{
	int left=0,right=size-1;
	bubble_sort(arr,size);
	while(left<right)
	{
		if((arr[left]+arr[right])>sum)
			right--;
		else if((arr[left]+arr[right])<sum)
			left++;
		else
			printf("(%d,%d)\n",arr[left++],arr[right]);
	}
}
void bubble_sort(int arr[],int size)
{
	int i,j;
	for(i=0;i<size;i++)
	    for(j=0;j<size;j++)
			if(arr[i]<arr[j])
			    swap(arr+i,arr+j);
}
void swap(int *a,int *b)
{
	*a=*a+*b;
	*b=*a-*b;
	*a=*a-*b;
}
