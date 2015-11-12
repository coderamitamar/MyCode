#include<stdio.h>
#include<conio.h>
#define NA -999
void shiftToEnd(int [],int);
void merge(int [],int [],int,int);
void print(int [],int);
int main()
{
	int i,n,mPLUSn;
	printf("Enter the size of both arrays\nBigger array size: ");
	scanf("%d",&mPLUSn);
	printf("Smaller array size: ");
	scanf("%d",&n);
	int arr_mPLUSn[mPLUSn],arr_n[n];
	printf("Start entering the elements of Bigger array\nEnter %d if element is not available\n",NA);
	for(i=0;i<mPLUSn;i++)
		scanf("%d",arr_mPLUSn+i);
	printf("Start entering the elements of Smaller array\n");
	for(i=0;i<n;i++)
		scanf("%d",arr_n+i);
	shiftToEnd(arr_mPLUSn,mPLUSn);
	merge(arr_mPLUSn,arr_n,mPLUSn,n);
	printf("Merged array is\n");
	print(arr_mPLUSn,mPLUSn);
	getch();
	return 0;
}
void shiftToEnd(int arr[],int size)
{
	int i,j=size-1;
	for(i=size-1;i>=0;i--)
		if(arr[i]!=NA)
		    arr[j--]=arr[i];
}
void merge(int arr_mPLUSn[],int arr_n[],int mPLUSn,int n)
{
	int counter_n=0,counter_mPLUSn=n,counter=0;
	//Compare and merge both array until one of them is not vecant
	while(counter_n!=n||counter_mPLUSn!=mPLUSn)
	{
		if(arr_mPLUSn[counter_mPLUSn]>=arr_n[counter_n])
			arr_mPLUSn[counter++]=arr_n[counter_n++];
		else arr_mPLUSn[counter++]=arr_mPLUSn[counter_mPLUSn++];
	}
	//If arr_n array is not vecant
	if(counter_mPLUSn==mPLUSn)
		while(counter_n!=n)
			arr_mPLUSn[counter++]=arr_n[counter_n++];
}
void print(int arr[],int size)
{
	int i;
	for(i=0;i<size;i++)
	    printf("%d\t",arr[i]);
}
