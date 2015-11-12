void getDegs(graph *G,int inDeg[],int outDeg[],int deg[])
{
	//variable declaration
	int i,j;
	int vSize=G->vertCount,eSize;
	vertex *vert=G->root;
	list *temp;
	for(i=0;i<vSize;i++)
		inDeg[i]=outDeg[i]=deg[i]=0;
	if(G->type==1)
	{
		for(i=0;i<vSize;i++,vert=vert->nextVert)
		{
			//vertCount is the outdegree so assign it
			outDeg[i]=vert->vertCount;
			//check for indegree
			temp=vert->firstAdj;
			while(temp!=NULL)
			{
				j=temp->nextVert->nodeNo;
				inDeg[j]++;
				temp=temp->nextAdj;
			}
		}
		for(i=0;i<vSize;i++)
			deg[i]=inDeg[i]+outDeg[i];
	}
	else if(G->type==2)
		for(i=0;i<vSize;i++,vert=vert->nextVert)
			inDeg[i]=outDeg[i]=deg[i]=vert->vertCount;
	else
		//show message
		showMessage(8);
}
