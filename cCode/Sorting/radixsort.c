#include<stdio.h>
#include<conio.h>
int largest(int [],int);
void radixsort(int [],int);
void main(){
	int n,i;
	printf("How many numbers do you want to sort: ");
	scanf("%d",&n);
	int rawdata[n];
	printf("Start entering the elements\n");
	for(i=0;i<n;i++)
		scanf("%d",&rawdata[i]);
	radixsort(rawdata,n);
	printf("Sorted elements are:\n");
	for(i=0;i<n;i++)
		printf("%d\t",rawdata[i]);
	getch();
}
int largest(int arr[],int n){
	int large=arr[0],i;
	for(i=1;i<n;i++){
		if(large>arr[i])
			large=arr[i];
	}
	return large;
}
void radixsort(int raw[],int n){
	int pass,remainder,nod=0,i,j,k,large,divisor=1;
	large=largest(raw,n);
	while(large>0){
		nod++;
		large/=10;
	}
	int bucket[10][n],bucketcount[10];
	for(pass=0;pass<nod;pass++){
        for(i=0;i<10;i++)
		bucketcount[i]=0;
		for(i=0;i<n;i++){
			remainder=(raw[i]/divisor)%10;
			bucket[remainder][bucketcount[remainder]++]=raw[i];
		}
		i=0;
		for(k=0;k<10;k++){
			for(j=0;j<bucketcount[k];j++)
				raw[i++]=bucket[k][j];
		}
		divisor*=10;
	}
}
