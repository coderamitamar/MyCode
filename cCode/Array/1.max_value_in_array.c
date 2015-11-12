#include<stdio.h>
#include<conio.h>
int max_arr_iterative(int [],int);
int max_arr_recursive(int [],int);
int maximum(int,int);
int main()
{
	int i,n;
	printf("Enter the no. of elements: %d: ",'a');
	scanf("%d",&n);
	int arr[n];
	for(i=0;i<n;i++)
	scanf("%d",(arr+i));
	printf("Max value in the array is: %d\n",max_arr_iterative(arr,n));
	printf("Max value in the array is: %d\n",max_arr_recursive(arr,n));
	getch();
	return 0;
}
int max_arr_iterative(int arr[],int size)
{
	int i,max=arr[0];
	for(i=1;i<size;i++)
		if(arr[i]>max)
			max=arr[i];
	return max;
}
int max_arr_recursive(int arr[],int size)
{
	static int max=0;
	if(!size)
		return 0;
	else
		return max=maximum(arr[size-1],max_arr_recursive(arr,size-1));
}
int maximum(int a,int b)
{
	if(a>=b)
		return a;
	else
		return b;
}
