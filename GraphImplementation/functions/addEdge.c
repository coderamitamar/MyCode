graph *addEdge(graph *G,char *from[],char *to[],int eSize)
{
	//variable declaration
	int i,j,k,l,eAdded=0,check=0;
	int vSize=G->vertCount;
	int opt=G->type;
	vertex *vert,*start,*end;
	//Block for Directed graph
	if(opt==1)
	{
		for(i=0;i<eSize;i++)
		{
			//Initialise variables
			vert=G->root;
			start=NULL;
			end=NULL;
			//find both vertices
			for(j=0;j<vSize;j++,vert=vert->nextVert)
			{
				if(!strcmp(from[i],vert->nodeName))
					{
						start=vert;
						k=j;
					}
				if(!strcmp(to[i],vert->nodeName))
					{
						end=vert;
						l=j;
					}
			}
			if(start!=NULL&&end!=NULL)
			{
				//take a list type node
				list *temp1,*prt;
				temp1=(list *)malloc(sizeof(list));
				//assign the name
				temp1->nodeName=to[i];
				temp1->nextAdj=NULL;
				//Connect its nextvert to vert[l]
				temp1->nextVert=end;
				//connect it to vertex list
				if(start->firstAdj==NULL)
					start->firstAdj=temp1;
				else
				{
					prt=start->firstAdj;
					while(prt->nextAdj!=NULL)
						prt=prt->nextAdj;
					prt->nextAdj=temp1;
				}
				temp1=NULL;
				//increase the vertcount of 'from' vertex
				start->vertCount++;
				eAdded++;
			}
			else
				check=1;
		}
		//Show message
		if(check==1)
			showMessage(1);
		//update all minimum and maximum degrees
		G=findMinMaxDegs(G);
		//update edgeCount of graph
		G->edgeCount+=eAdded;
	}
	//Block for the Undirected graph
	else if(opt==2)
	{
		for(i=0;i<eSize;i++)
		{
			vert=G->root;
			start=NULL;
			end=NULL;
			//find both vertices
			for(j=0;j<vSize;j++,vert=vert->nextVert)
			{
				if(!strcmp(from[i],vert->nodeName))
					{
						start=vert;
						k=j;
					}
				if(!strcmp(to[i],vert->nodeName))
					{
						end=vert;
						l=j;
					}
			}
			if(start!=NULL&&end!=NULL)
			{				
			 				//*** FOR FIRST EDGE ADDITION  ***//
				//take a list type node
				list *temp1,*prt;
				temp1=(list *)malloc(sizeof(list));
				//assign the name
				temp1->nodeName=to[i];
				temp1->nextAdj=NULL;
				//Connect its nextvert to vert[l]
				temp1->nextVert=end;
				//connect it to vertex list
				if(start->firstAdj==NULL)
					start->firstAdj=temp1;
				else
				{
				 	prt=start->firstAdj;
					while(prt->nextAdj!=NULL)
						prt=prt->nextAdj;
					prt->nextAdj=temp1;
				}
				temp1=NULL;
				//increase the vertcount of 'from' vertex
				start->vertCount++;
							//*** FOR SECOND EDGE ADDITION  ***//
				//take a list type node
				list *temp2;
				temp2=(list *)malloc(sizeof(list));
				//assign the name
				temp2->nodeName=from[i];
				temp2->nextAdj=NULL;
				//Connect its nextvert to vert[l]
				temp2->nextVert=start;
				//connect it to vertex list
				if(end->firstAdj==NULL)
					end->firstAdj=temp2;
				else
				{
				  prt=end->firstAdj;
					while(prt->nextAdj!=NULL)
						prt=prt->nextAdj;
					prt->nextAdj=temp2;
				}
				temp2=NULL;
				//increase the vertcount of 'from' vertex
				end->vertCount++;
				eAdded++;
			}
			else
				check=1;
		}
		//Show message		
		if(check==1)
			showMessage(1);
		//update all minimum and maximum degrees
		G=findMinMaxDegs(G);
		//update edgeCount of graph
		G->edgeCount+=eAdded;
	}
	//Block for the wrong input of type
	else
		//show message
		showMessage(9);
	return G;
}
