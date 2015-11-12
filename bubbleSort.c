#include<stdio.h>
#include<conio.h>
void bubblesort(int [],int);
int main(){
	int n,i;
	printf("How many numbers do you want to sort: ");
	scanf("%d",&n);
	int rawdata[n];
	printf("Start entering the numbers\n");
	for(i=0;i<n;i++)
		scanf("%d",&rawdata[i]);
	bubblesort(rawdata,n);
	printf("Sorted elements are:\n");
	for(i=0;i<n;i++)
		printf("%d\t",rawdata[i]);
	getch();
	return 0;
}
void bubblesort(int arr[],int n){
	int i,j,temp;
	for(i=1;i<n;i++){
		for(j=0;j<i;j++){
			if(arr[j]>arr[i]){
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
}
