#include<stdio.h>
#include<conio.h>
void quicksort(int [],int,int);
int partition(int [],int,int);
void swap(int *,int *);
void main(){
	int n,i;
	printf("How many numbers do you want to sort: ");
	scanf("%d",&n);
	int rawdata[n];
	printf("Start entering the elements:\n");
	for(i=0;i<n;i++)
		scanf("%d",&rawdata[i]);
	quicksort(rawdata,0,n-1);
	printf("Sorted elements are:\n");
	for(i=0;i<n;i++)
		printf("%d\t",rawdata[i]);
	getch();
}
void quicksort(int raw[],int beg,int end){
	int loc;
	if(beg<end){
		loc=partition(raw,beg,end);
		quicksort(raw,beg,loc-1);
		quicksort(raw,loc+1,end);
	}
}
int partition(int arr[],int big,int end){
	int i=big-1,j,x=arr[end];
	for(j=big;j<=end-1;j++){
		if(arr[j]<=x){
			i++;
			swap(&arr[i],&arr[j]);
		}
	}
	swap(&arr[i+1],&arr[end]);
	return (i+1);
}
void swap(int *a, int *b){
	int temp;
	temp = *a;
  *a   = *b;
  *b   = temp;
}
