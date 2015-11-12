package driver;
import graph.AdjListGraph;
public class GraphDriver
{
	public static void main(String[] args)
	{
		AdjListGraph g=new AdjListGraph();
		/*g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addEdge(0, 1, 10);
		g.addEdge(0, 2, 10);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 0, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 3, 10);*/
		//g.showAllEdges();
		
		//g.doBfs(2);
		//g.doDfs(2);
		//if(g.isCyclic()==true)
			//System.out.println("Yes, Cycle Exists");
		//else
			//System.out.println("No, Cycle doesn't Exist");
		
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 1, 10);
		g.addEdge(4, 0, 10);
		g.addEdge(4, 1, 10);
		g.addEdge(5, 0, 10);
		g.addEdge(5, 2, 10);
		g.topoSort();
	}
}