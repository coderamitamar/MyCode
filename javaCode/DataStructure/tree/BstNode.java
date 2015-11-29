public class BstNode<E extends Comparable<E>,F>{
	//Variables
	private E key;
	private F val;
	private BstNode<E,F> p,l,r;
	//Constructors
	public BstNode(){
		key=null;
		val=null;
		p=null;
		l=null;
		r=null;
	}
	public BstNode(E key,F val){
		this.key=key;
		this.val=val;
		p=null;
		l=null;
		r=null;
	}
	//Element access methods
	public void setP(BstNode<E,F> link){
		this.p=link;
	}
	public void setL(BstNode<E,F> link){
		this.l=link;
	}
	public void setR(BstNode<E,F> link){
		this.r=link;
	}
	public void setKey(E key){
		this.key=key;
	}
	public void setVal(F val){
		this.val=val;
	}
	public BstNode<E,F> getP(){
		return this.p;
	}
	public BstNode<E,F> getL(){
		return this.l;
	}
	public BstNode<E,F> getR(){
		return this.r;
	}
	public E getKey(){
		return this.key;
	}
	public F getVal(){
		return this.val;
	}
}
