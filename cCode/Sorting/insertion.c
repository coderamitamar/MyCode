#include<stdio.h>
#include<conio.h>
void main(){
	int n,i,j,k,temp;
	printf("How many numbers do you want to sort: ");
	scanf("%d",&n);
	int sortingarr[n];
	printf("Start Entering the numbers\n");
	scanf("%d",&sortingarr[0]);
	for(i=1;i<n;i++){
        scanf("%d",&temp);
        for(j=i-1;j>=0;j--){
			if(temp>sortingarr[j]){
				sortingarr[j+1]=temp;
				break;
			}else
				sortingarr[j+1]=sortingarr[j];
		}
		if(j==-1)
			sortingarr[0]=temp;
	}
	printf("Sorted elements are:");
	for(i=0;i<n;i++)
		printf("%d\t",sortingarr[i]);
	getch();
}
