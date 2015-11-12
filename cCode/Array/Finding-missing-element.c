#include<stdio.h>
#include<conio.h>
int find_missing_num_by_sum(int [],int);
int find_missing_num_by_xor(int [],int);
int main()
{
	int i,size;
	printf("Enter the size of array: ");
	scanf("%d",&size);
	int arr[size];
	printf("Start entering the elements of array\n");
	for(i=0;i<size;i++)
		scanf("%d",arr+i);
	printf("Finding missing element by method of summing\n");
	printf("Missing element is %d\n\n",find_missing_num_by_sum(arr,size));
    printf("Finding missing element by method of xor operation\n");
	printf("Missing element is %d",find_missing_num_by_xor(arr,size));
    getch();
    return 0;
}
int find_missing_num_by_sum(int arr[],int size)
{/*Finds the missing number when numbers from 1 to n, except any one of them, is entered*/
	int i,sum1,sum2=0;
	sum1=(size+1)*(size+2)/2;
	for(i=0;i<size;i++)
	    sum2+=arr[i];
	return (sum1-sum2);
}
int find_missing_num_by_xor(int arr[],int size)
{/*Finds the missing number when numbers from 1 to n, except any one of them, is entered*/
	int i,xor1=0,xor2=0;
	for(i=0;i<size;i++)
	{
		xor1^=(i+1);
		xor2^=arr[i];
	}
	xor1^=(i+1);
	return (xor1^xor2);
}
