#include<stdio.h>
#include<conio.h>
void bucketsort(int [],int,int);
void main(){
	int n,i,max=0;
	printf("How many numbers do you want to sort: ");
	scanf("%d",&n);
	int rawdata[n];
	printf("Start entering the elements\n");
	for(i=1;i<=n;i++){
		scanf("%d",&rawdata[i]);
		if(rawdata[i]>max)
		max=rawdata[i];
	}
	bucketsort(rawdata,n,max);
	printf("Sorted elements are\n");
	for(i=1;i<=n;i++)
	printf("%d\t",rawdata[i]);
	getch();
}
void bucketsort(int rawdata[],int n,int size){
	int bucket[size],i,j,k=1;
	for(i=1;i<=size;i++)
	bucket[i]=0;
	for(i=1;i<=n;i++)
	bucket[rawdata[i]]+=1;
	for(i=1;i<=size;i++){
		if(bucket[i]==0)
			continue;
		else{
			for(j=1;j<=bucket[i];j++){
				rawdata[k++]=i;
			}
		}
	}
}
