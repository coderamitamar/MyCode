//This function shows the adjacency matrix
//of the entered graph
void showAdjMatrix(graph *G)
{
	int i,j,size=G->vertCount;
	int adj[size][size];
	vertex *vert=G->root;
	//Generate the adjacency matrix from graph
	getAdjMatrix(G,adj);
	//Print the found matrix
	for(i=0;i<size;i++,vert=vert->nextVert)
		printf("\t%s",vert->nodeName);
	vert=G->root;
	for(i=0;i<size;i++,vert=vert->nextVert)
	{
		printf("\n\n%s",vert->nodeName);
		for(j=0;j<size;j++)
			printf("\t%d",adj[i][j]);
	}
	printf("\n");
}
