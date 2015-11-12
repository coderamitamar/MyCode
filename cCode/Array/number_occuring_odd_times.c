#include<stdio.h>
#include<conio.h>
int find(int arr[],int size)
{
	int i,res=0;
	for(i=0;i<size;i++)
		res=res^arr[i];
	return res;
}
int main()
{
	int i,size;
	printf("Enter the size of array: ");
	scanf("%d",&size);
	printf("Start entering the elelments\n");/*Note that only one element should be there whose*/
	int arr[size];							 /*occurence is odd and other should occur even times*/
	for(i=0;i<size;i++)
	scanf("%d",&arr[i]);
	printf("Element having odd occurence is: %d\n",find(arr,size));
	getch();
	return 0;
}
