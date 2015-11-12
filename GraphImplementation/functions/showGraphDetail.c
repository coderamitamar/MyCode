void showGraphDetail(graph *G)
{
	int i,j;
	int v=G->vertCount;
	vertex *vert;
	//checking for right call
	if(G->type!=3)
	{
	 printf("\n\tVertices names are\n");
	 vert=G->root;	
	 for(i=0;i<v;i++,vert=vert->nextVert)
		printf("\t\t\t%s\n",vert->nodeName);
	 printf("\tEdges are:\n");
	 list *y;
	 vertex *x=G->root;
	 for(i=0;i<v;i++,x=x->nextVert)
	 {
		printf("\n\tDegree of %s=%d\n",x->nodeName,x->vertCount);
		y=x->firstAdj;
		while(y!=NULL)
		{
			printf("\t\t%s---->%s\n",x->nodeName,y->nodeName);
			y=y->nextAdj;
		}
	 }
	 printf("\tDegrees of Graph %s::\n",G->gName);
	 if(G->type==1)
	 {
	 	printf("\t\tMinimum indegree: %d\t",G->minInDeg);
	 	printf("(%s)\n",G->minInDegVert);
	 	printf("\t\tMaximum indegree: %d\t",G->maxInDeg);
	 	printf("(%s)\n",G->maxInDegVert);
	 	printf("\t\tMinimum outdegree: %d\t",G->minOutDeg);
	 	printf("(%s)\n",G->minOutDegVert);
	 	printf("\t\tMaximum outdegree: %d\t",G->maxOutDeg);
	 	printf("(%s)\n",G->maxOutDegVert);
	 	printf("\t\tMinimum degree: %d\t",G->minDeg);
	 	printf("(%s)\n",G->minDegVert);
	 	printf("\t\tMaximum degree: %d\t",G->maxDeg);
	 	printf("(%s)\n",G->maxDegVert);
	 }
	 else
	 {
	 	printf("\t\tMinimum degree: %d\t",G->minDeg);
	 	printf("(%s)\n",G->minDegVert);
	 	printf("\t\tMaximum degree: %d\t",G->maxDeg);
	 	printf("(%s)\n",G->maxDegVert);
	 }
	}
	else
	{
		printf("\n\t\t##########  DRIVER ERROR  ##########\n");
		printf("\t\t>>Bad call of the function showGraphDetail().");
	}
}
