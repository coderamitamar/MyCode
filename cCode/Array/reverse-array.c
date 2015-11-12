#include<stdio.h>
#include<conio.h>
void reverse_iterative(int [],int);
void reverse_recursive(int [],int,int);
void swap(int *,int *);
void print(int [],int);
int main()
{
	int size,i;
	printf("Enter the size of array: ");
	scanf("%d",&size);
	int arr[size];
	printf("Enter the elements of the array\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr+i);
	reverse_iterative(arr,size);
	printf("Reversed array is\n");
	print(arr,size);
    reverse_recursive(arr,0,size-1);
	printf("\nAgain reversed array is\n");
	print(arr,size);
	getch();
	return 0;
}
void reverse_iterative(int arr[],int size)
{
	int start=0,end=size-1;
	while(start<end)
		swap(arr+start++,arr+end--);
}
void reverse_recursive(int arr[],int start,int end)
{
	if(start>=end)
	    return;
	swap(arr+start,arr+end);
    reverse_recursive(arr,start+1,end-1);
}
void swap(int *x,int *y)
{
	*x=*x+*y;
	*y=*x-*y;
	*x=*x-*y;
}
void print(int arr[],int size)
{
	int i;
	for(i=0;i<size;i++)
	    printf("%d\t",arr[i]);
}
