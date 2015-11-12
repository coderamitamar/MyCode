void showMessage(int opt)
{
	if(opt!=15)
		printf("\n\t\t|-|-|-|-|  MESSAGE  |-|-|-|-|\n");
	switch(opt)
	{
		case 1:
			{
				printf("\n\t>>>You entered some wrong vertex name for");
				printf(" any end of any edge\n\t   Check it and add ");
				printf("this edge by addEdge() function if you want\n");
				break;
			}
		case 2:
			{
				printf("\tBad call for getAdjMatrix()\n");
				break;
			}
		case 3:
			{
				printf("\tBad call for updateGraph()\n");
				break;
			}
		case 4:
			{
				printf("\tEdges have been succesfully added\n");
				break;
			}
		case 5:
			{
				printf("\tVertices have been succesfully added\n");
				break;
			}
		case 6:
			{
				printf("\tEdges have been succesfully deleted\n");
				break;
			}
		case 7:
			{
				printf("\tVertices have been succesfully deleted\n");
				break;
			}
		case 8:
			{
				printf("\tBad call for getDegs()\n");
				break;
			}
		case 9:
			{
				printf("\tBad call for addEdge()\n");
				break;
			}
		case 10:
			{
				printf("\tBad call for delEdge()\n");
				break;
			}
		case 11:
			{
				printf("\tSome Edges,which are to be deleted, is not found\n");
				break;
			}
		case 12:
			{
				printf("\tSome Vertices,which are to be deleted, is not found\n");
				break;
			}
		case 13:
			{
				printf("\tBad call for delVertex()\n");
				break;
			}
		case 14:
			{
				printf("\tBad call for addEdge()\n");
				break;
			}
		case 15:
			{
				printf("\t1> Enter a New Graph\n");
				printf("\t2> See the detail of Graph\n");
				printf("\t3> See the Adjacency matrix of Graph\n");
				printf("\t4> Add an Edge to a graph\n");
				printf("\t5> Delete an Edge from a graph\n");
				printf("\t6> Add a Vertex to a graph\n");
				printf("\t7> Delete a Vertex from a graph\n");
				printf("\t8> Exit\n");
				break;
			}
		default:
			{
				printf("Bad call for showMessage()");
				break;
			}
	}
}
