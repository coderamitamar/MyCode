//Define the Graph data structure
typedef struct
{
	char *gName;
	int type;
	int vertCount;
	int edgeCount;
	int minInDeg;
	int maxInDeg;
	int minOutDeg;
	int maxOutDeg;
	int minDeg;
	int maxDeg;
	char *minInDegVert;
	char *maxInDegVert;
	char *minOutDegVert;
	char *maxOutDegVert;
	char *minDegVert;
	char *maxDegVert;
	struct node *root;
}graph;
//Structure of node of linked list
struct lList
{
	char *nodeName;
	struct node *nextVert;
	struct lList *nextAdj;
};
//structure of node
struct node
{
	char *nodeName;
	int nodeNo;
	int vertCount;
	struct lList *firstAdj;
	struct node *nextVert;
};
//Define these structures as a datatype
typedef struct node vertex;
typedef struct lList list;
