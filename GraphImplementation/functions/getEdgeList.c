int getEdgeList(graph *G,vertex *vert,char *from[],char *to[])
{
	//variable declaration
	int i,eCount=0,vSize=G->vertCount;
	list *tempe=vert->firstAdj;
	vertex *tempv;
	//build edge list
	while(tempe!=NULL)
	{
		from[eCount]=vert->nodeName;
		to[eCount++]=tempe->nodeName;
		tempe=tempe->nextAdj;
	}
 	printf("\nHI i am in getEdge-1\n");
	if(G->type==1)
	{
		tempv=G->root;
		for(i=0;i<vSize;i++,tempv=tempv->nextVert)
		{
		 	if(!strcmp(tempv->nodeName,vert->nodeName))
			  continue;
			else
			{
				tempe=tempv->firstAdj;
				while(tempe!=NULL)
				{
					if(!strcmp(tempe->nodeName,vert->nodeName))
					{
						from[eCount]=tempv->nodeName;
						to[eCount++]=tempe->nodeName;
					}
					tempe=tempe->nextAdj;
				}
			}			
		}
 	printf("\nHI i am in getEdge-2\n");
	}
	return eCount;	
}
