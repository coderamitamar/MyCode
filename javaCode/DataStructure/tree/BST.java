package tree;
import java.util.ArrayDeque;
import java.util.Deque;

public class BST<E extends Comparable<E>,F>{
	//variables
	private BstNode<E,F> root;
	//Constructors
	public BST(){
		root=null;
	}
	//methods
	public BstNode<E,F> getRoot(){
		return root;
	}
	public int getHeight(BstNode<E,F> x){
		if(x==null)
			return 0;
		return 1+Math.max(getHeight(x.getL()), getHeight(x.getR()));
	}
	public void printRightView(BST<Integer,Integer> bst){
		Deque<BstNode<Integer,Integer>> q1=new ArrayDeque<>();//for key
		Deque<Integer> q2=new ArrayDeque<Integer>();//for level
		BstNode<Integer,Integer> root=bst.getRoot();
		int height=bst.getHeight(root);
		int ar[]=new int[height];
		q1.addLast(root);
		q2.addLast(1);
		int level;
		while(!q1.isEmpty()){
			root=q1.removeFirst();
			level=q2.removeFirst();
			ar[level-1]=root.getKey();
			if(root.getL()!=null){
				q1.addLast(root.getL());
				q2.addLast(level+1);
			}
			if(root.getR()!=null){
				q1.addLast(root.getR());
				q2.addLast(level+1);
			}
		}
		for(int i=0;i<height;i++){
			System.out.print(ar[i]+" ");
		}
	}
	public void printLeftView(BST<Integer,Integer> bst){
		Deque<BstNode<Integer,Integer>> q1=new ArrayDeque<>();//for key
		Deque<Integer> q2=new ArrayDeque<Integer>();//for level
		BstNode<Integer,Integer> root=bst.getRoot();
		int height=bst.getHeight(root);
		int ar[]=new int[height];
		q1.addLast(root);
		q2.addLast(1);
		int level;
		while(!q1.isEmpty()){
			root=q1.removeFirst();
			level=q2.removeFirst();
			ar[level-1]=root.getKey();
			if(root.getR()!=null){
				q1.addLast(root.getR());
				q2.addLast(level+1);
			}
			if(root.getL()!=null){
				q1.addLast(root.getL());
				q2.addLast(level+1);
			}
		}
		for(int i=0;i<height;i++){
			System.out.print(ar[i]+" ");
		}
	}
 	public BstNode<E,F> searchBst(E key){
		if(root==null)
			return null;
		else{
			BstNode<E,F> trv=root;
			BstNode<E,F> prt=root;
			E tkey=trv.getKey();
			while(tkey.compareTo(key)!=0&&trv!=null){
				tkey=trv.getKey();
				prt=trv;
				if(key.compareTo(tkey)<0)
					trv=trv.getL();
				else
					trv=trv.getR();
			}
			if(prt.getKey().compareTo(key)!=0)
				return null;
			return prt;
		}
	}
 	public void transplant(BstNode<E,F> u,BstNode<E,F> v){
		if(u.getP()==null)
			root=v;
		else if(u.getP().getL()==u)
			u.getP().setL(v);
		else
			u.getP().setR(v);
		if(v!=null)
			v.setP(u.getP());
	}
	public BstNode<E,F> getMin(BstNode<E,F> node){
		while(node.getL()!=null)
			node=node.getL();
		return node;
	}
	public void insBst(E key,F val){
		BstNode<E,F> newNode=new BstNode<>(key,val);
		//insert the newNode
		if(root==null)
			root=newNode;
		else{
			//first search the parent of this key
			BstNode<E,F> trv,prt=null;
			E tkey;
			prt=root;
			trv=root;
			while(trv!=null){
				prt=trv;
				tkey=trv.getKey();
				if(key.compareTo(tkey)<0)
					trv=trv.getL();
				else
					trv=trv.getR();
			}
			//insert the newNode at the found place
			newNode.setP(prt);
			if(prt.getKey().compareTo(key)>0)//insertion as left child
				prt.setL(newNode);
			else							  //insertion as right child
				prt.setR(newNode);
		}
	}
	public BstNode<E,F> delBst(E key){
		BstNode<E,F> target=searchBst(key);
		//System.out.println(target.getKey());
		if(target!=null){
			BstNode<E,F> succ;
			if(target.getL()==null)
				transplant(target,target.getR());
			else if(target.getR()==null)
				transplant(target,target.getL());
			else{
				succ=getMin(target.getR());
				if(succ!=target.getR()){
					transplant(succ,succ.getR());
					succ.setR(target.getR());
					succ.getR().setP(succ);
				}
				transplant(target,succ);
				succ.setL(target.getL());
				succ.getL().setP(succ);
			}
		}
		else
			System.out.println("Key not found");
		return target;
	}
	public void showInorder(BstNode<E,F> trv){
		if(trv==null)
			return;
		showInorder(trv.getL());
		System.out.println(trv.getKey()+"--->"+trv.getVal());
		showInorder(trv.getR());
	}
	public void showInorderWithoutStack(BstNode<E,F> trv){
		if(trv==null)
			return;
		BstNode<E,F> curr,pre;
		curr=trv;
		while(curr!=null){
			if(curr.getL()==null){
				System.out.println(curr.getKey()+"--->"+curr.getVal());
				curr=curr.getR();
			}else{
				pre=curr.getL();
				while(pre.getR()!=null && pre.getR()!=curr)
					pre=pre.getR();
				if(pre.getR()==null){
					pre.setR(curr);
					curr=curr.getL();
				}else{
					pre.setR(null);
					System.out.println(curr.getKey()+"--->"+curr.getVal());
					curr=curr.getR();
				}
			}
		}
	}
}
