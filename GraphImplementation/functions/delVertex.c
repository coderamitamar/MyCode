graph *delVertex(graph *G,char *vertName[],int noOfVert)
{
	//variable declaration
	int i,j,check=0,vCount=0,eCount=0,vSize=G->vertCount;
	vertex *vert,*prt;
	list *temp1,*temp2;
	//deletion starts here
	for(i=0;i<noOfVert;i++)
	{
		//initialise the variables
		vert=G->root;
		check=0;
		for(j=0;j<vSize;j++,vert=vert->nextVert)
		{
			//when vertex matches to the vertex to be deleted
			if(!strcmp(vertName[i],vert->nodeName))
			{
				//deleting all outgoing edge
				temp1=vert->firstAdj;
				vert->firstAdj=NULL;
				vCount+=1;//vertex counter tracks the number of edges deleted
				check=1;//checks that vertex are deleted or not
				while(temp1!=NULL)
				{
					//disconnect one node from edge list
					temp2=temp1;
					temp1=temp1->nextAdj;
					//free that node
					free(temp2);
					temp2=NULL;
					//increase the edge counter to count number of deleted edge
					eCount++;
				}
			}
			else
			{
				//deleting all incoming edges
				temp2=temp1=vert->firstAdj;
				while(temp1!=NULL)
				{
				 	//if match found
				 	if(!strcmp(temp1->nodeName,vertName[i]))
				 	{//if the node is not the first node of the list
				 		if(temp1!=vert->firstAdj)
				 		{
				 			temp2->nextAdj=temp1->nextAdj;
				 			free(temp1);
				 			temp1=temp2->nextAdj;
				 			//increase the ecounter to count number of deleted edge
				 			eCount++;
				 			//decrease the vertCount of the vertex
				 			vert->vertCount-=1;
				 		}
				 		else
				 		{
				 			vert->firstAdj=temp1->nextAdj;
				 			free(temp1);
				 			temp1=vert->firstAdj;
				 			//increase the ecounter to count number of deleted edge
				 			eCount++;
				 			//decrease the vertCount of the vertex
				 			vert->vertCount-=1;
				 		}
				 	}
				 	else
				 	{//if match not found then simply move ahead
				 		temp2=temp1;
				 		temp1=temp1->nextAdj;
				 	}
				}
			}
		}
		if(check==1)
		{
			//Now delete the vertex
			prt=vert=G->root;
			while(vert!=NULL)
			{
				if(!strcmp(vertName[i],vert->nodeName))
				{
					if(vert==G->root)
					{//if node to be deleted is root
						G->root=vert->nextVert;
						free(vert);
						vert=NULL;
						break;
					}
					else
					{//otherwise
						prt->nextVert=vert->nextVert;
						free(vert);
						vert=NULL;
						break;
					}
				}
				//otherwise increamnet the pointer
				prt=vert;
				vert=vert->nextVert;
			}
			//since vertex is deleted so vSize must be decreased
			vSize--;
		}
	}//loop ends here
	//assign nodenumbers
	vert=G->root;
	j=0;
	while(vert!=NULL)
	{
		vert->nodeNo=j;
		j++;
		vert=vert->nextVert;
	}
	if(vCount<noOfVert)
		//show message
		showMessage(12);
	//decrease number of vertices
	G->vertCount-=vCount;
	//decrease number of edges
	if(G->type==1)
		G->edgeCount-=eCount;
	else if(G->type==2)
		G->edgeCount-=(eCount/2);
	//find minmaxdegs
	if(vCount!=0)
		G=findMinMaxDegs(G);
	return G;
}
