package stack;
public class ArrayStack{
	//Variable section
	private Object stk[];
	private int top;
	private int maxSize;
	
	//Constructor section
	public ArrayStack(){
		maxSize=1;
		stk=new Object[1];
		top=-1;
	}
	public ArrayStack(int size){
		maxSize=size;
		stk=new Object[size];
		top=-1;
	}
	
	//Method section
	public int size(){
		return top+1;
	}
	public boolean isEmpty(){
		return (top<0);
	}
	public void push(Object o){
		int i=0;
		if(this.size()==maxSize){
			Object o1[]=new Object[2*maxSize];
			for(Object k:stk)
				o1[i++]=k;
			stk=o1;
			stk[++top]=o;
		}else
			stk[++top]=o;
	}
	public Object pop(){
		Object o;
		try{
			o=stk[top];
			stk[top--]=null;
			return o;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Stack underflow!!!");
			return "NotOk";
		}
	}
	public void show(){
		int i;
		if(top<0){
			System.out.println("Stack is empty!!!\n");
			return;
		}
		System.out.println("The stack contains:");
		for(i=0;i<=top;i++)
			System.out.print(stk[i]+"\t");
		System.out.println();
	}
}
