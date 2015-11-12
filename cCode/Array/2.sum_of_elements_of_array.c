#include<stdio.h>
#include<conio.h>
int iterative_sum_arr(int [],int);
int recursive_sum_arr(int [],int);
int main()
{
	int i,n;
	printf("Enter the number of elements of array: ");
	scanf("%d",&n);
	int arr[n];
	for(i=0;i<n;i++)
	scanf("%d",(arr+i));
	printf("Sum of elements of the array by iteration is: %d\n",iterative_sum_arr(arr,n));
    printf("Sum of elements of the array by recursion is: %d\n",recursive_sum_arr(arr,n));
    getch();
    return 0;
}
int iterative_sum_arr(int arr[],int size)
{
	int i,sum=0;
	for(i=0;i<size;i++)
	sum+=arr[i];
	return sum;
}
int recursive_sum_arr(int arr[],int size)
{
	static int sum=0;
	if(!size)
	return 0;
	recursive_sum_arr(arr+1,size-1);
	return sum+=*arr;
}
