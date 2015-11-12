#include<stdio.h>
#include<conio.h>
int add(int **,int **,int **,int,int);
void inputMatrix(int **,int,int);
void print2D(int **,int,int);
void swap(int *,int *);
int main()
{
	int am,an,bm,bn;
	printf("Enter the dimensions of matrix\n");
	printf("am: ");
	scanf("%d",&am);
	printf("an: ");
	scanf("%d",&an);
	printf("bm: ");
	scanf("%d",&bm);
	printf("bn: ");
	scanf("%d",&bn);
	if(am!=bm||an!=bn)
	{
		printf("Matrices should be of same dimension for addition\n");
		getch();
		return 0;
	}
	int arr[am][an],brr[bm][bn];
	printf("Enter the elements of first matrix\n");
	inputMatrix((int **)arr,am,an);
	printf("Enter the elements of second matrix\n");
	inputMatrix((int **)brr,bm,bn);
	int crr[am][an];
	if(add((int **)arr,(int **)brr,(int **)crr,am,an))
	{
		printf("Resultant matrix of (A+B) is:\n");
		print2D((int **)crr,am,an);
	}
    getch();
	return 0;
}
int add(int *arr[],int *brr[],int *crr[],int m,int n)
{
	int i,j;
	for(i=0;i<m;i++)
	 for(j=0;j<n;j++)
	  *((int *)((crr+i*n)+j))=*((int *)((arr+i*n)+j))+*((int *)((brr+i*n)+j));
	return 1;
}
void inputMatrix(int *arr[],int m,int n)
{
	int i,j;
	for(i=0;i<m;i++)
	 for(j=0;j<n;j++)
	  scanf("%d",((arr+i*n)+j));
}
void print2D(int *arr[],int m,int n)
{
	int i,j;
	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		    printf("%d\t",*((arr+i*n)+j));
		printf("\n\n");
	}
}
