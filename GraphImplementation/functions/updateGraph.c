#include "addEdge.c"
#include "addVertex.c"
#include "delEdge.c"
#include "delVertex.c"
graph *updateGraph(graph *G,int sig)
{
	//switch to the updation type
	switch(sig)
	{
		case 1:
			{
				 	 	 						 //ADDING NUMBER OF EDGES//
		 		//variable declaration
				int i,j,edgeCount;//i.e number of edges
				//take number of edges
				printf("Enter the number of edges to be added: ");
				scanf("%d",&edgeCount);
				//take arrays to store edge end names
				char *from[edgeCount],*to[edgeCount];
			 	//TAKING EDGES STARTS HERE
				printf("\n\tEnter the names of ends of edges:\n");
				fflush(stdin);
				for(i=0;i<edgeCount;i++)
				{
				 	printf("\n\t\tEnd names for %dth Edge:\n",i+1);
					from[i]=(char *)malloc(sizeof(char));
					to[i]=(char *)malloc(sizeof(char));
					printf("\t\t\tEdge from end: ");
					from[i]=takeString();
					printf("\t\t\tEdge to end: ");
					to[i]=takeString();
				}
	 			//TAKING EDGES ENDS HERE
	 			//Add these edges to graph
	 			G=addEdge(G,from,to,edgeCount);
	 			//show message
	 			showMessage(4);
				break;
			}
		case 2:
			{
				 	 							//ADDING NUMBER OF VERTICES//
			  //Variable declaration
			  int i,noOfVert;//i.e number of vertices
			  //Take number of vertices
			  printf("Enter the number of vertices to be added: ");
			  scanf("%d",&noOfVert);
			  //take array to store the names
			  char *vertName[noOfVert];
			  //TAKING VERTICES STARTS HERE
			  printf("Enter the names of vertices:\n");
			  fflush(stdin);
			  for(i=0;i<noOfVert;i++)
			  {
			  	printf("Name of Vertex-%d: ",i+1);
			  	vertName[i]=(char *)malloc(sizeof(char));
			  	vertName[i]=takeString();
			  }
			  //TAKING VERTICES ENDS HERE
			  //Add them to the Graph
			  G=addVertex(G,vertName,noOfVert);
			  //show message
			  showMessage(5);
				break;
			}
		case 3:
			{
				 	 							//DELETING NUMBER OF EDGES//
			  //variable declaration
				int i,j,edgeCount;//i.e number of edges
				//take number of edges
				printf("Enter the number of edges to be deleted: ");
				scanf("%d",&edgeCount);
				//take arrays to store edge end names
				char *from[edgeCount],*to[edgeCount];
			 	//TAKING EDGES STARTS HERE
				printf("\n\tEnter the names of ends of edges:\n");
				fflush(stdin);
				for(i=0;i<edgeCount;i++)
				{
				 	printf("\n\t\tEnd names for %dth Edge:\n",i+1);
					from[i]=(char *)malloc(sizeof(char));
					to[i]=(char *)malloc(sizeof(char));
					printf("\t\t\tEdge from end: ");
					from[i]=takeString();
					printf("\t\t\tEdge to end: ");
					to[i]=takeString();
				}
	 			//TAKING EDGES ENDS HERE
	 			//Delete the edges from the graph
	 			G=delEdge(G,from,to,edgeCount);
	 			//show message
	 			showMessage(6);
				break;
			}
		case 4:
			{
				 	 							//DELETING NUMBER OF VERTICES//
			  //Variable declaration
			  int i,noOfVert;//i.e number of vertices
			  //Take number of vertices
			  printf("Enter the number of vertices to be deleted: ");
			  scanf("%d",&noOfVert);
			  //take array to store the names
			  char *vertName[noOfVert];
			  //TAKING VERTICES STARTS HERE
			  printf("Enter the names of vertices:\n");
			  fflush(stdin);
			  for(i=0;i<noOfVert;i++)
			  {
			  	printf("Name of Vertex-%d: ",i+1);
			  	vertName[i]=(char *)malloc(sizeof(char));
			  	vertName[i]=takeString();
			  }
			  //TAKING VERTICES ENDS HERE
			  //Delete them from the Graph
			  G=delVertex(G,vertName,noOfVert);
			  //show message
			  showMessage(7);
				break;
			}
		default:
			{
				showMessage(3);
				break;
			}
	}
	return G;
}
