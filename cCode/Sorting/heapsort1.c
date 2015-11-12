#include<stdio.h>
#include<conio.h>
void rhu(int [],int);/*restore heap up*/
int deleteroot(int [],int);
void main(){
	int n,i,j,temp;
	printf("How many numbers do you want to sort: ");
	scanf("%d",&n);
	int heap[n],result[n];
	printf("Start entering the numbers\n");
	for(i=1;i<=n;i++){
		scanf("%d",&heap[i]);
		rhu(heap,i);
	}
	j=n;
	for(i=1;i<=j;i++){
		result[i]=deleteroot(heap,n);
		n--;
	}
	n=j;
	printf("The sorted elements are\n");
	for(i=1;i<=n;i++)
		printf("%d\t",result[i]);
	getch();
}
void rhu(int heap[],int index){
	int val=heap[index];
	while((index>1)&&(heap[index/2]>val)){
		heap[index]=heap[index/2];
		index/=2;
	}
	heap[index]=val;
}
int deleteroot(int heap[],int n){
	int j=1,item,temp;
	item=heap[1];
	heap[1]=temp=heap[n--];
	while(j<=n){
		if((2*j+1)>n){
			if(2*j>n)
				break;
			else{
				if(temp>heap[2*j]){
					heap[j]=heap[2*j];
     				j*=2;
					break;
				}else
					break;
			}
		}else if(heap[2*j]<heap[2*j+1]){
			heap[j]=heap[2*j];
			j*=2;
		}else if(heap[2*j]>heap[2*j+1]){
            heap[j]=heap[2*j+1];
			j=2*j+1;
		}else
			continue;
	}
	heap[j]=temp;
	return item;
}
