package graph;
import java.util.*;
public class AdjListGraph
{
	private Vector<Vert> vList;
	public AdjListGraph(){
		vList =new Vector<Vert>();
	}
	public int getVertCnt(){
		return vList.size();
	}
	public Vert getVertex(int i){
		return vList.get(i);
	}
	public void addVertex(int nodeVal){
		vList.add(new Vert(nodeVal));
	}
	public void delVertex(int nodeVal){
	}
	public void addEdge(int from,int to,int weight){
		vList.get(from).getEList().add(new Edge(weight,to));
	}
	public void delEdge(){
	}
	public void showAllEdges(){
		int eCnt,vCnt=vList.size();
		List<Edge> e;
		for(int i=0;i<vCnt;i++){
			e=vList.get(i).getEList();
			eCnt=e.size();
			for(int j=0;j<eCnt;j++){
				System.out.println(i+"--->"+e.get(j).toVert);
			}
		}
	}
	public void doBfs(int nodeVal){
		Vert v;
		Iterator<Edge> t=null;
		Deque<Vert> q=new ArrayDeque<>();
		v=getVertex(nodeVal);
		v.isVisited=true;
		q.addLast(v);
		while(!q.isEmpty()){
			v=q.removeFirst();
			System.out.print(v.data+" ");
			t=v.getEList().iterator();
			while(t.hasNext()){
				v=getVertex(t.next().toVert);
				if(v.isVisited==false){
					v.isVisited=true;
					q.addLast(v);
				}
			}
		}
	}
	public void doDfs(int nodeVal){
		Vert v;
		Iterator<Edge> t=null;
		Stack<Vert> s=new Stack<>();
		v=getVertex(nodeVal);
		v.isVisited=true;
		s.push(v);
		while(!s.isEmpty()){
			v=s.pop();
			System.out.print(v.data+" ");
			t=v.getEList().iterator();
			while(t.hasNext()){
				v=getVertex(t.next().toVert);
				if(v.isVisited==false){
					v.isVisited=true;
					s.push(v);
				}
			}
		}
	}
	public boolean isCyclic(){
		int size=vList.size();
		boolean recStk[]=new boolean[size];
		for(int i=0;i<size;i++)
			if(isCyclicUtil(i,recStk)==true)
				return true;
		return false;
	}
	private boolean isCyclicUtil(int v,boolean recStk[]){
		Vert x=getVertex(v);
		if(x.isVisited==false){
			x.isVisited=true;
			recStk[v]=true;
			Iterator<Edge> t;
			Edge e;
			t=x.getEList().iterator();
			while(t.hasNext()){
				e=t.next();
				x=getVertex(e.toVert);
				if(x.isVisited==false && isCyclicUtil(x.data,recStk)==true)
					return true;
				else if(recStk[x.data]==true)
					return true;
			}
		}
		recStk[v]=false;
		return false;
	}
	public void topoSort(){//topologicalSort
		Stack<Integer> s=new Stack<Integer>();
		int size=vList.size();
		boolean visited[]=new boolean[size];
		for(int i=0;i<size;i++)
			if(visited[i]==false)
				topoSortUtil(s,visited,i);
		while(!s.isEmpty())
			System.out.print(s.pop()+" ");
	}
	private void topoSortUtil(Stack<Integer> s,boolean vis[],int i){
		vis[i]=true;
		Edge e;
		Iterator<Edge> it=vList.get(i).getEList().iterator();
		while(it.hasNext()){
			e=it.next();
			if(vis[e.toVert]==false)
				topoSortUtil(s,vis,e.toVert);
		}
		s.push(i);
	}
}