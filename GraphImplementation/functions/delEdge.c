graph *delEdge(graph *G,char *from[],char *to[],int eSize)
{
	//variable declaration
	int i,j,check=0,degCheck=0,vSize=G->vertCount;
	vertex *vert,*start,*end;
	list *temp,*prt;
	//Here starts the deletion process
	if(G->type==1)
	{
		for(i=0;i<eSize;i++)
		{
			//set variables to initial position
			vert=G->root;
			start=NULL;
			//find the vertex in vertex list
			for(j=0;j<vSize;j++,vert=vert->nextVert)
				if(!strcmp(from[i],vert->nodeName))
				{
					start=vert;
					break;
				}
			//if vertex is found
			if(start!=NULL)
			{
				//find the node in edge list
				prt=temp=start->firstAdj;
				while(temp!=NULL)
				{
					if(!strcmp(temp->nodeName,to[i]))
						break;
					prt=temp;
					temp=temp->nextAdj;
				}
				//if node is found
				if(temp!=NULL)
				{
					if(temp==prt)
						//deleting the edge
						start->firstAdj=prt->nextAdj;
					else
						//deleting the edge
						prt->nextAdj=prt->nextAdj->nextAdj;
					//freeing the memory of deleted node	
					temp->nextAdj=NULL;
					temp->nextVert=NULL;
					free(temp);
					temp=NULL;
					prt=NULL;
					//decrease the vertex count
					start->vertCount-=1;
					//leave the message that degree must be rechecked
					degCheck+=1;					
				}
				else
					check=1;
			}
			else
				check=1;
		}
		//show message
		if(check==1)//to see that if atleast one edge is not deleted
			showMessage(11);
		if(degCheck>=1)//check for degrees
		{
			G=findMinMaxDegs(G);
			G->edgeCount-=degCheck;
		}
	}
	else if(G->type==2)
	{
		for(i=0;i<eSize;i++)
		{			
			//set variables to initial position
			vert=G->root;
			start=NULL;
			end=NULL;
			//find vertex in vertex list
			for(j=0;j<vSize;j++,vert=vert->nextVert)
			{
				if(!strcmp(from[i],vert->nodeName))
						start=vert;
				if(!strcmp(to[i],vert->nodeName))
						end=vert;
			}
			 							 //Deleting first edge
			//if vertex found
			if(start!=NULL)
			{
				//find the node in edge list
				prt=temp=start->firstAdj;
				while(temp!=NULL)
				{
					if(!strcmp(temp->nodeName,to[i]))
						break;
					prt=temp;
					temp=temp->nextAdj;
				}
				//if node found
				if(temp!=NULL)
				{
					if(temp==prt)
						//deleting the edge
						start->firstAdj=prt->nextAdj;
					else
						//deleting the edge
						prt->nextAdj=prt->nextAdj->nextAdj;
					//freeing the memory of deleted node
					temp->nextAdj=NULL;
					temp->nextVert=NULL;
					free(temp);
					temp=NULL;
					prt=NULL;
					//decrease the vertex count
					start->vertCount-=1;
				}
				else
					check=1;
			}
			else
				check=1;
								//Deleting second edge (undirected graph)
			//if vertex found
			prt=temp=NULL;
			if(end!=NULL)
			{
				//find the node in edge list
				prt=temp=end->firstAdj;
				while(temp!=NULL)
				{
					if(!strcmp(temp->nodeName,from[i]))
						break;
					prt=temp;
					temp=temp->nextAdj;
				}
				//if node found
				if(temp!=NULL)
				{
					if(temp==prt)
						//deleting the edge
						end->firstAdj=prt->nextAdj;
					else
						//deleting the edge
						prt->nextAdj=prt->nextAdj->nextAdj;
					//freeing the memory of deleted node
					temp->nextAdj=NULL;
					temp->nextVert=NULL;
					free(temp);
					temp=NULL;
					prt=NULL;
					//decrease the vertex count
					end->vertCount-=1;
					//leave the message that degree must be rechecked
					degCheck+=1;
				}
				else
					check=1;
			}
			else
				check=1;
		}
		//show message
		if(check==1)//to see that if atleast one edge is not deleted
			showMessage(11);
		if(degCheck>=1)//check for degrees
		{
			G=findMinMaxDegs(G);
			G->edgeCount-=degCheck;
		}
	}
	else
		//show message
		showMessage(10);
	return G;
}
