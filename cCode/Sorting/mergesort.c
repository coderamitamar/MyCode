#include<stdio.h>
#include<conio.h>
void merge(int [],int,int,int);
void mergesort(int [],int,int);
void main()
{
	int n,i;
	printf("How many numbers do you want to sort: ");
	scanf("%d",&n);
	int rawdata[n];
	printf("Start entering the data:\n");
	for(i=0;i<n;i++)
		scanf("%d",&rawdata[i]);
	mergesort(rawdata,0,n-1);
	printf("Sorted data are:\n");
	for(i=0;i<n;i++)
		printf("%d\t",rawdata[i]);
	getch();
}
void mergesort(int raw[],int low,int high)
{
	int mid;
	if(low<high)
	{
		mid=(low+high)/2;
		mergesort(raw,low,mid);
		mergesort(raw,mid+1,high);
		merge(raw,low,mid,high);
	}
}
void merge(int raw[],int low,int mid,int high)
{
	int i=low,j=mid+1,index=low,temp[high-low+1],k;
	while((i<=mid)&&(j<=high))
		if(raw[i]<raw[j])
			temp[index++]=raw[i++];
		else
			temp[index++]=raw[j++];
	if(i>mid)
		while(j<=high)
			temp[index++]=raw[j++];
	else
		while(i<=mid)
			temp[index++]=raw[i++];
	for(k=low;k<index;k++)
	raw[k]=temp[k];
}
