#include<stdio.h>
#include<conio.h>
void mult_matrix(int [][10],int [][10],int [][10],int,int,int);
void take_matrix(int [][10],int,int);
void print_matrix(int [][10],int,int);
int main()
{
	int n,m,r,s;
	printf("Enter the order of matrix-1\n");
	scanf("%d%d",&m,&n);
	printf("Enter the order of matrix-2\n");
	scanf("%d%d",&r,&s);
	if(m==0||n==0||r==0||s==0)
	{
		printf("Either one or both matrix doesn't exist\n");
		getch();
		return 0;
	}
	if(n!=r)
	{
		printf("Given matrices are incompatible for matrix multiplication\n");
		getch();
		return 0;
	}
	int matr1[m][n],matr2[r][s],matr3[m][s];
	take_matrix(matr1,m,n);
    take_matrix(matr2,r,s);
    mult_matrix(matr1,matr2,matr3,m,n,s);
    print_matrix(matr3,m,s);
    getch();
    return 0;
}
void mult_matrix(int matr1[][10],int matr2[][10],int matr3[][10],int m,int n,int p)
{
	int i,j,k;
	for(i=0;i<m;i++)
	    for(j=0;j<p;j++)
	    {
			matr3[i][j]=0;
			for(k=0;k<n;k++)
				matr3[i][j]+=matr1[i][k]*matr2[k][j];
		}
}
void take_matrix(int matr[][10],int m,int n)
{
	static int matr_no=1;
	int i,j;
    printf("Enter the Matrix-no-%d\n",matr_no++);
	for(i=0;i<m;i++)
	    for(j=0;j<n;j++)
			scanf("%d",&matr[i][j]);
}
void print_matrix(int matr[][10],int m,int n)
{
	int i,j;
    printf("Resultant Matrix\n");
	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
			printf("%d\t",matr[i][j]);
		printf("\n");
	}
}
