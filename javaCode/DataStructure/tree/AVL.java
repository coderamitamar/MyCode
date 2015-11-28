package tree;
class AvlNode{
	//Defining structure on avl node
	int key;		//to perform search
	int val;		//to hold dataVal
	AvlNode left;	//reference to left child
	AvlNode right;	//reference to right child
	int height;		//store the height of the subtree having root as this node
	//First Constructor
	public AvlNode(int key){
		this.key=key;
		this.val=0;
		left=null;
		right=null;
		height=1;
	}
	//Second Constructor
	public AvlNode(int key,int val){
		this.key=key;
		this.val=val;
		left=null;
		right=null;
		height=1;
	}
}
public class AVL {
	private AvlNode root=null; //Holding the root of the tree
	private AvlNode minValNode(AvlNode node){
		while(node.left!=null)
			node=node.left;
		return node;
	}
	//finds the difference between heights of left and right subtrees
	private int getBalance(AvlNode x){
		if(x==null)
			return 0;
		return height(x.left)-height(x.right);
	}
	//finds the height of the tree 
	private int height(AvlNode a){
		if(a==null)
			return 0;
		return a.height;
	}
	//Perform right rotation on a given node
	private AvlNode rightRotate(AvlNode y){
		AvlNode x=y.left;
		AvlNode z=x.right;
		//perform rotation
		x.right=y;
		y.left=z;
		//update height
		y.height=Math.max(height(y.left), height(y.right))+1;
		x.height=Math.max(height(x.left), height(x.right))+1;
		return x;
	}
	//Perform left rotation on a given node
	private AvlNode leftRotate(AvlNode x){
		AvlNode y=x.right;
		AvlNode z=y.left;
		//perform rotation
		y.left=x;
		x.right=z;
		//update height
		x.height=Math.max(height(x.left), height(x.right))+1;
		y.height=Math.max(height(y.left), height(y.right))+1;
		return y;
	}
	private AvlNode insertUtil(AvlNode node,int key,int val){
		if(node==null)
			return new AvlNode(key,val);
		if(key<node.key)
			node.left=insertUtil(node.left,key,val);
		else
			node.right=insertUtil(node.right,key,val);
		node.height=Math.max(height(node.left), height(node.right))+1;
		int balance=getBalance(node);
		//left left case
		if(balance>1 && key<node.left.key)
			return rightRotate(node);
		//rifhg right case
		if(balance<-1 && key>node.right.key)
			return leftRotate(node);
		//left right case
		if(balance>1 && key>node.left.key){
			node.left=leftRotate(node.left);
			return rightRotate(node);
		}
		//Right left case
		if(balance<-1 && key<node.right.key){
			node.right=rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}
	private AvlNode deleteUtil(AvlNode node,int key){
		//first use bst delete to delete the node
		if(node==null)
			return node;
		if(key<node.key)
			node.left=deleteUtil(node.left,key);
		else if(key>node.key)
			node.right=deleteUtil(node.right,key);
		else{//if key is at this node
			if(node.left==null || node.right==null){
				//if one or no child is there for this node
				AvlNode temp=(node.left!=null)?node.left:node.right;
				if(temp==null){
					node=null;
				}else{
					node.key=temp.key;
					node.val=temp.val;
					node.left=null;
					node.right=null;
				}
			}else{//if both child are there for this node
				AvlNode temp=minValNode(node.right);
				node.key=temp.key;
				node.val=temp.val;
				node.right=deleteUtil(node.right,temp.key);
			}
		}
		if(node==null)//if node had no child
			return node;
		//do balancing of tree
		node.height=Math.max(height(node.left), height(node.right))+1;
		int bal=getBalance(node);
		if(bal>1 && getBalance(node.left)>=0)//left left case
			return rightRotate(node);
		if(bal>1 && getBalance(node.left)<0){//left right case
			node.left=leftRotate(node.left);
			return rightRotate(node);
		}
		if(bal<-1 && getBalance(node.right)<=0)//right right case
			return leftRotate(node);
		if(bal<-1 && getBalance(node.right)>0){//right left case
			node.right=rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}
	public void insert(int key,int val){
		root=insertUtil(root,key,val);
	}
	public void delete(int key){
		root=deleteUtil(root,key);
	}
	public int getVal(int key){
		//search the key and return corresponding value
		AvlNode curr=root;
		while(curr!=null && curr.key!=key){
			if(key<curr.key)
				curr=curr.left;
			else// if(key>curr.key)
				curr=curr.right;
		}
		if(curr==null)
			return Integer.MAX_VALUE;
		return curr.val;
	}
	public void printInOrder(AvlNode x){
		if(x==null)	return;
		printInOrder(x.left);
		System.out.print(x.key+" ");
		printInOrder(x.right);
	}
	public static void main(String[] args){
		AVL avl=new AVL();
		avl.insert(2, 5);
		avl.insert(3, 5);
		avl.insert(1, 5);
		avl.insert(7, 5);
		avl.insert(10, 5);
		avl.insert(5, 5);
		avl.insert(8, 5);
		avl.insert(6, 5);
		avl.insert(9, 5);
		System.out.print(avl.height(avl.root)+"\n");
		avl.printInOrder(avl.root);
		avl.delete(6);
		avl.delete(2);
		avl.delete(7);
		avl.delete(7);
		System.out.print("\n"+avl.height(avl.root)+"\n");
		avl.printInOrder(avl.root);
		int key=5;
		int val=avl.getVal(key);
		if(val!=Integer.MAX_VALUE)
			System.out.print("\n"+key+" --> "+val+"\n");
		else
			System.out.print("\nKey Not Found\n");
	}
}