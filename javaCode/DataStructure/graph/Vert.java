package graph;
import java.util.*;
public class Vert
{
	int data;
	private List<Edge> eList;
	boolean isVisited;
	public Vert(int nodeVal)
	{
		data=nodeVal;
		isVisited=false;
		eList=new LinkedList<>();
	}
	public List<Edge> getEList()
	{
		return eList;
	}
}
class Edge
{
	int weight;
	int toVert;
	Edge(int w,int to)
	{
		weight=w;
		toVert=to;
	}
}