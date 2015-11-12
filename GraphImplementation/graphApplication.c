/*
  NAME:Graph Application
  AUTHOR:AMIT KUMAR AMAR
  DATE:08-12-2014
  LOC:103
  COMPLEXITY::
	   FUNC-1:
	   FUNC-2:
*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "files/structure.c"
#include "functions/showMessage.c"
#include "functions/takeString.c"
#include "functions/findMinMaxDegs.c"
#include "functions/takeGraph.c"
#include "functions/showGraphDetail.c"
#include "functions/getAdjMatrix.c"
#include "functions/showAdjMatrix.c"
#include "functions/updateGraph.c"
int main()
{
	//variables
	int i,j,getOut=1,choice=0;
	graph *G=(graph *)malloc(sizeof(graph));
	//Header design
	printf("\t\t\t******************************\n");
	printf("\t\t\t>>>>> GRAPH APPLICATIONS <<<<<\n");
	printf("\t\t\t******************************\n");
	//make loop to use any number of times
	while(getOut==1)
	{
		//show the options to be used
		showMessage(15);
		//take the choice of function
		printf("\n\t\tEnter the choice: ");
		scanf("%d",&choice);
		//switch to the desired case
		switch(choice)
		{
			case 1:
				{
					G=takeGraph();
					break;
				}
			case 2:
				{
					printf("Graph is as follows:\n");
					showGraphDetail(G);
					break;
				}
			case 3:
				{
					printf("Adjacency matrix of the graph is as follows:\n");
					showAdjMatrix(G);
					break;
				}
			case 4:
				{
					updateGraph(G,1);
					break;
				}
			case 5:
				{
					updateGraph(G,3);
					break;
				}
			case 6:
				{
					updateGraph(G,2);
					break;
				}
			case 7:
				{
					updateGraph(G,4);
					break;
				}
			case 8:
				{
					printf("\t\t\t<<<<< OK, BYE!!!! >>>>>\n");
					getOut=2;
					break;
				}
			default:
				{
					printf("\tWrong option\n");
					break;
				}
		}
		//Hold the program to multiple time use
		while(1)
		{
			printf("\n\t1> CONTINUE\n\t2> STOP\n\t\tEnter the Choice: ");
			scanf("%d",&getOut);
			if(getOut==1||getOut==2)
				break;
			else
				printf("\tEnter the choice correctly\n");
		}
	}
	return 0;
}
