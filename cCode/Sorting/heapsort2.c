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
	int last=heap[n],prt=1,left=2,right=3,val,temp;
	n--;
	val=heap[1];
	heap[1]=last;
	while(left<=n){
		if((heap[prt]<=heap[left])&&(heap[prt]<=heap[right]))
		return val;
		if(heap[left]<=heap[right]){
			temp=heap[left];
			heap[left]=heap[prt];
			heap[prt]=temp;
			prt=left;
		}else{
            temp=heap[right];
			heap[right]=heap[prt];
			heap[prt]=temp;
			prt=right;
		}
		left=2*prt;
		right=left+1;
	}
	return val;
}
