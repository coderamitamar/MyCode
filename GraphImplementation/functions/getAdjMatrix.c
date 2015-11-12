//This function generates the adjacency matrix
//of the given graph
void getAdjMatrix(graph *G,int adj[][G->vertCount])
{
	int i,j,size=G->vertCount;
	vertex *vert;
	list *temp;
	vert=G->root;
	for(i=0;i<size;i++)
		for(j=0;j<size;j++)
			adj[i][j]=0;
	if(G->type==1||G->type==2)
		for(i=0;i<size;i++,vert=vert->nextVert)
		{
		 	temp=vert->firstAdj;
			while(temp!=NULL)
			{
			 	j=temp->nextVert->nodeNo;
				adj[i][j]=1;
				temp=temp->nextAdj;
			}
		}
	else
		showMessage(2);
}
