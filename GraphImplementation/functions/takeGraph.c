//function body
graph *takeGraph()
{
	//Declaration of variables
	int i,j,k,l,check=0;
	int vSize,eSize,opt;
	vertex *start,*end,*vert,*root,*temp;
	//Take name of graph
	printf("Enter the name of the Graph: ");
	fflush(stdin);
	graph *G;
	G=(graph *)malloc(sizeof(graph));
	G->gName=takeString();
	//Take the number of vertices and edges
	printf("Enter the number of Vertices: ");
	scanf("%d",&vSize);
	G->vertCount=vSize;
	printf("\nEnter the number of edges: ");
	scanf("%d",&eSize);
	G->edgeCount=eSize;
						//TAKING N VERTICES
	printf("\n\tEnter the names of all vertices::\n");
	fflush(stdin);
	//taking first(or root) vertex
	root=(vertex *)malloc(sizeof(vertex));
	printf("\t\tName of 1th vertex: ");
	root->nodeName=takeString();
	//initialising variables of root
	root->firstAdj=NULL;
	root->nextVert=NULL;
	root->vertCount=0;
	root->nodeNo=0;
	//taking other vertices
	for(i=1;i<vSize;i++)
	{
		//memory allocation to vertix
		vert=(vertex *)malloc(sizeof(vertex));
		printf("\t\tName of %dth vertex: ",i+1);
		vert->nodeName=takeString();
		//Initialising variables
		vert->firstAdj=NULL;
		vert->nextVert=NULL;
		vert->vertCount=0;
		vert->nodeNo=i;
		//connect vert to vertex list
		temp=root;
		while(temp->nextVert!=NULL)
			temp=temp->nextVert;
		temp->nextVert=vert;
		vert=NULL;
	}
	 					//TAKING VERTICES ENDS HERE
						//TAKING EDGES STARTS HERE
	char *from[eSize],*to[eSize];
	printf("\n\tEnter the names of ends of edges:\n");
	for(i=0;i<eSize;i++)
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
	 			//*****CREATION OF GRAPH STARTS HERE*****//
	//ask for the type of graph
	printf("\tChoose the option:\n");
	printf("\t\t1> Directed Graph\n");
	printf("\t\t2> Undirected Graph\n");
	printf("\tOption: ");
	scanf("%d",&opt);
	//according to the type-i/p make the blocks
	//Block for Directed graph
	if(opt==1)
	{
		G->type=1;
		for(i=0;i<eSize;i++)
		{
			//Initialise variables
			vert=root;
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
			}
			else
				check=1;
		}
		//Show message
		if(check==1)
			showMessage(1);
		G->root=root;
		//find all minimum and maximum degrees
		G=findMinMaxDegs(G);
		printf("\n\t\t||***  GRAPH IS CREATED  ***||\n");
	}
	//Block for the Undirected graph
	else if(opt==2)
	{
		G->type=2;
		for(i=0;i<eSize;i++)
		{
			vert=root;
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
			}
			else
				check=1;
		}
		//Show message		
		if(check==1)
			showMessage(1);
		G->root=root;
		//find minimum and maximum degrees
		G=findMinMaxDegs(G);
		printf("\n\t\t||***  GRAPH IS CREATED  ***||\n");
	}
	//Block for the wrong input of type
	else
	{
		G->type=3;
		printf("\t*** You entered the wrong choice ***\n");
		printf("\n\t\t||---  Graph is not Created  ---||\n");
	}
	return G;
}
