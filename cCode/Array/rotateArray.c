/*
	Name:- Methods for rotating the array
	Author:- Amit kumar Amar
	Date:- 27-09-2014
	Language:- C
	No. of lines:- 313 lines
*/
#include<stdio.h>
#include<conio.h>
void rotateArray(int [],int,int,int,int,int);
void rotateArray1(int [],int,int,int);
void rotateArray2(int [],int,int,int);
void rotateArray3(int [],int,int,int);
void rotateArray4(int [],int,int,int);
void rotateArray5(int [],int,int,int);
void rotateArray6(int [],int,int,int);
void reverseArray(int [],int,int);
void blockSwap(int [],int,int,int);
void swap(int *,int *);
void print(int[],int);
int main()
{
	int size,i,lr,d;
	printf("Enter the size of array: ");
	scanf("%d",&size);
	int arr[size];
	printf("Start entering the elements of the array\n");
	for(i=0;i<size;i++)
	    scanf("%d",arr+i);
	printf("How many times do you want to rotate the array: ");
	scanf("%d",&d);
	printf("In which direction do you want to rotate the array\n");
	printf("1>Left\n2>Right\nEnter the Choice: ");
	scanf("%d",&lr);
	if(lr!=1&&lr!=2)
	{
        printf("ERROR MESSEGE:\n");
	    for(i=1;i<=6;i++)
	    {
            printf("By rotateArray%d:\n",i);
			rotateArray(arr,size,d,lr,0,i);
	    }
	}
	else
	    for(i=1;i<=6;i++)
	    {
            printf("By rotateArray%d:\n",i);
			rotateArray(arr,size,d,lr,0,i);
			print(arr,size);
			rotateArray(arr,size,d,lr,1,i);
	    }
	getch();
	return 0;
}
void rotateArray(int arr[],int size,int d,int lr,int flag,int f_no)
{
	//f_no represents function number
	//This function is to drive all functions from single point
	int new_lr;
	if(flag==1)//flag=1 means we are rotating in the reverse order of lr signal
	    if(lr==1)
	        new_lr=2;
		else if(lr==2)
		    new_lr=1;
		else
		    new_lr=3;
	else
	    new_lr=lr;
	if(f_no==1)
	    rotateArray1(arr,size,d,new_lr);
	else if(f_no==2)
	    rotateArray2(arr,size,d,new_lr);
	else if(f_no==3)
	    rotateArray3(arr,size,d,new_lr);
	else if(f_no==4)
	    rotateArray4(arr,size,d,new_lr);
	else if(f_no==5)
	    rotateArray5(arr,size,d,new_lr);
	else
	    rotateArray6(arr,size,d,new_lr);
}
void rotateArray1(int arr[],int size,int d,int lr)
{
	//This function is simplest one.
	//d represents no. of times array to be rotated and lr shows left or right rotation
	//It first stores d no. of values in a temp array
	//Then shifts the remaining array
	//Then write the temp array values in the actual array on that side in which space is vecant
	int i,j=0,temp[d];
	if(lr==1)//lr=1 means left rotation
	{
		for(i=0;i<d;i++)
		    temp[i]=arr[i];
        for(;i<size;i++)//initially i=d in this case due to above for loop
            arr[j++]=arr[i];
        for(i=0;j<size;j++)//initially j=n-1+d in this case due to above for loop
            arr[j]=temp[i++];
	}
	else if(lr==2)//lr=2 means right rotation
		rotateArray1(arr,size,size-d,1);
	/*//Or it can be written as follows
		{
			for(i=size-1,j=d-1;i>=(size-d);i--)
		    	temp[j--]=arr[i];
        	for(j=size-1;i>=0;i--)//initially i=n-d-1 in this case due to above for loop
            	arr[j--]=arr[i];
        	for(i=d-1;j>=0;j--)//initially j=n-d-1 in this case due to above for loop
            	arr[j]=temp[i--];
		}
	*/
	else//Inapropriate value of lr
	    printf("\tInapropriate value of lr is passed\n");
}
void rotateArray2(int arr[],int size,int d,int lr)
{
	//This function shifts the array one element each time and shifts d times
	int temp,i;
	if(lr==1)
		while(d--)
		{
			temp=arr[0];
			for(i=0;i<size-1;i++)
			    arr[i]=arr[i+1];
			arr[i]=temp;
		}
	else if(lr==2)//lr=2 means right rotation
		rotateArray2(arr,size,size-d,1);
	/*//Or it can also be written as follows
	    while(d--)
		{
			temp=arr[size-1];
			for(i=size-1;i>0;i--)
			    arr[i]=arr[i-1];
			arr[i]=temp;
		}
	*/
	else//Inapropriate value of lr
	    printf("\tInapropriate value of lr is passed\n");
}
void rotateArray3(int arr[],int size,int d,int lr)
{
	//This is called Juggling algorithm
	//This is an extension of method 2. Instead of moving one by one, divide the array in different sets
	//where number of sets is equal to GCD of size and d and move the elements within sets.
	int i,j,k,temp,set;
	set=gcd(size,d);
	if(lr==1)
	    for(i=0;i<set;i++)
	    {
            temp=arr[i];
    		j=i;
    		while(1)
    		{
    	  		k=j+d;
      			if(k>=size)
        			k=k-size;
      			if(k==i)
        			break;
      			arr[j]=arr[k];
      			j=k;
    		}
    		arr[j]=temp;
	    }
	else if(lr==2)//lr=2 means right rotation
		rotateArray3(arr,size,size-d,1);
	/*//Or it can be written as follows
	    for(i=size-1;i>=size-set;i--)
	    {
			temp=arr[i];
			j=i;
			while(1)
			{
				k=j-d;
				if(k<0)
				    k=k+size;
				if(k==i)
				    break;
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=temp;
	    }
	*/
	else//Inapropriate value of lr
	    printf("\tInapropriate value of lr is passed\n");
}
void rotateArray4(int arr[],int size,int d,int lr)
{
	//This is called reversal algorithm for array rotation
	//It first reverses first d elements
	//Then reverser last size-d elements
	//Then reverses the entire array
	int i,j,k,temp,set;
	set=gcd(size,d);
	if(lr==1)
	{
		reverseArray(arr,0,d-1);
		reverseArray(arr,d,size-1);
		reverseArray(arr,0,size-1);
	}
	else if(lr==2)//lr=2 means right rotation
		rotateArray4(arr,size,size-d,1);
	/*//Or it can be written as follows
		{
			reverseArray(arr,size-d,size-1);
			reverseArray(arr,0,size-d-1);
			reverseArray(arr,0,size-1);
		}
	*/
	else//Inapropriate value of lr
	    printf("\tInapropriate value of lr is passed\n");
}
void rotateArray5(int arr[],int size,int d,int lr)
{
	//This is called block swap method (Recursive version)
	//Initialize A = arr[0..d-1] and B = arr[d..n-1]
	//	1) Do following until size of A is equal to size of B
  	//		a)  If A is shorter, divide B into Bl and Br such that Br is of same
  	//     		length as A. Swap A and Br to change ABlBr into BrBlA. Now A
	//       	is at its final place, so recur on pieces of B.
   	//		b)  If A is longer, divide A into Al and Ar such that Al is of same
    // 			length as B Swap Al and B to change AlArB into BArAl. Now B
    //			is at its final place, so recur on pieces of A.
	//	2) Finally when A and B are of equal size, block swap them.
    if(lr!=1&&lr!=2)//Inapropriate value of lr
	{
		printf("\tInapropriate value of lr is passed\n");
		return;
	}
	if(d==0||d==size)
	    return;
	if(d==size-d)
	{
		blockSwap(arr,0,d,d);
		return;
	}
    if(lr==1)
	{
		if(d<size-d)
		{
			blockSwap(arr,0,size-d,d);
			rotateArray5(arr,size-d,d,lr);
		}
		else
		{
			blockSwap(arr,0,d,size-d);
			rotateArray5(arr+size-d,d,2*d-size,lr);
		}
	}
	else//lr=2 means right rotation
        rotateArray5(arr,size,size-d,1);
}
void rotateArray6(int arr[],int size,int d,int lr)
{
    //This is called block swap method (Iterative version)
	int i=d,j=size-d;
    if(lr!=1&&lr!=2)//Inapropriate value of lr
	{
		printf("\tInapropriate value of lr is passed\n");
		return;
	}
	if(d==0||d==size)
	    return;
    if(lr==1)
    {
		while(i!=j)
    	{
			if(i<j)
   			{
				blockSwap(arr,d-i,d+j-i,i);
				j-=i;
			}
			else
			{
				blockSwap(arr,d-i,d,j);
				i-=j;
			}
    	}
    	blockSwap(arr,d-i,d,i);
	}
	else//lr=2 means right rotation
        rotateArray6(arr,size,size-d,1);
}
void reverseArray(int arr[],int start,int end)
{
	while(start<end)
	    swap(arr+start++,arr+end--);
}
void blockSwap(int arr[],int fi,int si,int d)
{
	d++;
	while(--d)
	    swap(arr+fi+d-1,arr+si+d-1);
}
void swap(int *x,int *y)
{
	*x=*x+*y;
	*y=*x-*y;
	*x=*x-*y;
}
void print(int arr[],int size)
{
	int i;
	for(i=0;i<size;i++)
	    printf("%d\t",arr[i]);
	printf("\n");
}
int gcd(int a,int b)
{
	if(b==0)
		return a;
	else
		return gcd(b,a%b);
}
