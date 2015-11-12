#include<stdio.h>
#include<conio.h>
float findMedian1(int [],int [],int);
float findMedian2(int [],int [],int);
float findMedian3(int [],int [],int);
float findMedianRec(int [],int [],int,int,int);
int median(int [],int);
int max(int,int);
int min(int,int);
int main()
{
	int size,i;
	float c1,c2,c3;
	printf("Enter the size of array: ");
	scanf("%d",&size);
	int arr1[size],arr2[size];
	printf("Start entering the elements of arrays in sorted manner\n");
	printf("Enter the elements for first array\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr1+i);
    printf("Enter the elements for second array\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr2+i);
	c1=findMedian1(arr1,arr2,size);
	c2=findMedian2(arr1,arr2,size);
	c3=findMedian3(arr1,arr2,size);
	printf("By median1: %f\nBy median2: %f\nBy median3: %f\n",c1,c2,c3);
	getch();
	return 0;
}
float findMedian1(int arr1[],int arr2[],int n)
{
	int counter=0,counter1=0,counter2=0;
	float small=0,large=0;
	while(counter1!=n||counter2!=n)
	{
		if(arr1[counter1]>=arr2[counter2])
		{
			small=large;
			large=arr2[counter2++];
			counter++;
		}
		else
		{
			small=large;
			large=arr1[counter1++];
			counter++;
		}
		if(counter==n+1)
			break;
	}
	return (small+large)/2;
}
float findMedian2(int arr1[],int arr2[],int n)
{
	int m1,m2;
	if(n<=0)
		return -1;
	if(n==1)
	    return ((float)arr1[0]+(float)arr2[0])/2;
	if(n==2)
	    return ((float)max(arr1[0],arr2[0])+(float)min(arr1[1],arr2[1]))/2;
	m1=median(arr1,n);
	m2=median(arr2,n);
	if(m1==m2)
	    return m1;
	if(m1<m2)
	    if(n%2==0)
	        return findMedian2(arr1+n/2-1,arr2,n-n/2+1);
	    else    return findMedian2(arr1+n/2,arr2,n-n/2);
	if(m1>m2)
	    if(n%2==0)
	        return findMedian2(arr2+n/2-1,arr1,n-n/2+1);
	    else    return findMedian2(arr2+n/2,arr1,n-n/2);
}
float findMedian3(int arr1[],int arr2[],int n)
{
	return findMedianRec(arr1,arr2,0,n-1,n);
}
float findMedianRec(int arr1[],int arr2[],int left,int right,int n)
{
	int i,j;
	i=(left+right)/2;
	j=n-i-1;
	if(left>right)
	    return findMedianRec(arr2,arr1,0,n-1,n);
	if(arr2[j]<arr1[i] && (j==n-1 || arr1[i]<=arr2[j+1]))
	{
		if(i==0||arr2[j]>arr1[i-1])
		    return ((float)arr1[i]+(float)arr2[j])/2;
		else return ((float)arr1[i]+(float)arr1[i-1])/2;
	}
	else if(arr1[i]>arr2[j] && j!=(n-1) && arr1[i]>arr2[j+1])
		return findMedianRec(arr1,arr2,left,i-1,n);
	else return findMedianRec(arr1,arr2,i+1,right,n);
}
int median(int arr[],int n)
{
	if(n%2==0)
	    return (arr[n/2]+arr[n/2-1])/2;
	else
	    return arr[n/2];
}
int max(int a,int b)
{
	(a>b)?({return a;}):({return b;});//if(a>b) return a; else return b;
}
int min(int a,int b)
{
    (a<b)?({return a;}):({return b;});//if(a<b) return a; else return b;
}
