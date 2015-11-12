#include<stdio.h>
#include<conio.h>
void shellsort(int [],int);
void main(){
	int n,i;
	printf("How many numbers do you want to sort: ");
	scanf("%d",&n);
	int rawdata[n];
	printf("Start entering the elements\n");
	for(i=0;i<n;i++)
		scanf("%d",&rawdata[i]);
	shellsort(rawdata,n);
	printf("Sorted elements are\n");
	for(i=0;i<n;i++)
		printf("%d\t",rawdata[i]);
	getch();
}
void shellsort(int rawdata[],int n){
	int gapsize=n,temp,i,flag=1;
	while(gapsize>1){
		gapsize=(gapsize+1)/2;
		for(i=0;i<(n-gapsize);i++){
			if(rawdata[i]>rawdata[i+gapsize]){
				temp=rawdata[i];
				rawdata[i]=rawdata[i+gapsize];
				rawdata[i+gapsize]=temp;
			}
		}
	}
	while(flag!=0){
		flag=0;
		for(i=0;i<(n-1);i++){
			if(rawdata[i]>rawdata[i+1]){
				flag=1;
				temp=rawdata[i];
				rawdata[i]=rawdata[i+1];
				rawdata[i+1]=temp;
			}
		}
	}
}
