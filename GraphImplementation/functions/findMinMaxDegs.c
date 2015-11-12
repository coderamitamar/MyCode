//attach the function to get degrees of graph
#include "getDegs.c"
//Here starts the function for minmax degress
graph *findMinMaxDegs(graph *G)
{
	int i,v=G->vertCount;
	int inDeg[v],outDeg[v],deg[v];
	vertex *vert;
	vert=G->root;
	//get the degrees first
	getDegs(G,inDeg,outDeg,deg);
	//Make blocks as per the types of graph
	if(G->type==1)
	{
		//Initialising degree variables
		G->minInDeg=G->maxInDeg=inDeg[0];
		G->minOutDeg=G->maxOutDeg=outDeg[0];
		G->minDeg=G->maxDeg=deg[0];
		//Initialising minMaxDeg name variables 
		G->minInDegVert=vert->nodeName;
		G->maxInDegVert=vert->nodeName;
		G->minOutDegVert=vert->nodeName;
		G->maxOutDegVert=vert->nodeName;
		G->minDegVert=vert->nodeName;
		G->maxDegVert=vert->nodeName;
		//finding minMax degs
		for(i=1;i<v;i++)
		{
	 	 vert=vert->nextVert;
		 if(G->minInDeg>inDeg[i])
		 {
			 G->minInDeg=inDeg[i];
			 G->minDegVert=vert->nodeName;
		 }
		 if(G->maxInDeg<inDeg[i])
		 {
		 	 G->maxInDeg=inDeg[i];
			 G->maxInDegVert=vert->nodeName;
		 }
		 if(G->minOutDeg>outDeg[i])
		 {
			 G->minOutDeg=outDeg[i];
			 G->minOutDegVert=vert->nodeName;
		 }
		 if(G->maxOutDeg<outDeg[i])
		 {
			 G->maxOutDeg=outDeg[i];
			 G->maxOutDegVert=vert->nodeName;
		 }
		 if(G->minDeg>deg[i])
		 {
			 G->minDeg=deg[i];
			 G->minDegVert=vert->nodeName;
		 }
		 if(G->maxDeg<deg[i])
		 {
			 G->maxDeg=deg[i];
			 G->maxDegVert=vert->nodeName;
		 }
		}
	}
	else
	{
		//Initialising degree variables
		G->minDeg=G->maxDeg=deg[0];
		//Initialising minMaxDeg name variables
		G->minDegVert=vert->nodeName;
		G->maxDegVert=vert->nodeName;
		//finding minMax degs
		for(i=1;i<v;i++)
		{
			vert=vert->nextVert;
			if(G->minDeg>deg[i])
		 	{
			 G->minDeg=deg[i];
			 G->minDegVert=vert->nodeName;
			}
		 	if(G->maxDeg<deg[i])
		 	{
			 G->maxDeg=deg[i];
			 G->maxDegVert=vert->nodeName;
		 	}
		}
	}
	return G;
}
