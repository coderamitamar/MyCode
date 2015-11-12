#include<stdio.h>
#include<conio.h>
void selectionsort(int [],int);
void main(){
	int n,i;
	printf("How many numbers do you want to sort: ");
	scanf("%d",&n);
	int rawdata[n];
	printf("Start entering numbers\n");
	for(i=0;i<n;i++)
		scanf("%d",&rawdata[i]);
	selectionsort(rawdata,n);
	printf("Sorted elements are\n");
    for(i=0;i<n;i++)
		printf("%d\t",rawdata[i]);
	getch();
}
void selectionsort(int arr[],int n){
	int i,j,k=0,smallest,temp;
	for(i=1;i<n;i++){
		k=i-1;
		smallest=arr[i-1];
		for(j=i-1;j<n;j++){
			if(arr[j]<smallest){
				k=j;
				smallest=arr[j];
			}
		}
		temp=arr[i-1];
		arr[i-1]=arr[k];
		arr[k]=temp;
	}
}
