graph *addVertex(graph *G,char *vertName[],int noOfVert)
{
	//Variable declaration
	int i,j;
	vertex *temp,*vert=G->root;
	//First reach to the end of the vertex list
	while(vert->nextVert!=NULL)
			vert=vert->nextVert;
	//add vertices
	for(i=0;i<noOfVert;i++)
	{
		//Make a vertex type node
		temp=(vertex *)malloc(sizeof(vertex));
		temp->firstAdj=NULL;
		temp->nextVert=NULL;
		temp->vertCount=0;
		temp->nodeNo=(vert->nodeNo)+1;
		temp->nodeName=vertName[i];
		//connect it to the vertex list
		vert->nextVert=temp;
		vert=vert->nextVert;
		temp=NULL;
	}
	//update vertCount of graph
	G->vertCount+=noOfVert;
	return G;
}
