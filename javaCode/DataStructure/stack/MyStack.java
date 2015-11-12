package stack;

public class MyStack{							//DATA SECTION STARTS HERE
	final int UNDERFLOW=-999999999;
	int size;
	private int top;
	private int stck[];
									//DATA SECTION ENDS HERE
									
									//CONSTRUCTOR SECTION STARTS HERE
	public MyStack(int s){
		size=s;
		top=-1;
		stck=new int[size];
	}
									//CONSTRUCTOR SECTION ENDS HERE

									//METHOD SECTION STARTS HERE
	//FUNCTION TO PUSH THE ELEMENT TO THE STACK
	public void push(int item){
		if(top>=size-1)
			System.out.println("\t>>> Stack overflow!!!");
		else
			stck[++top]=item;
	}
	//FUNCTION TO POP THE TOP ELEMENT OF THE STACK
	public int pop(){
		if(top<0){
			System.out.println("\t>>> Stack underflow!!!");
			return UNDERFLOW;
		}else
			return stck[top--];
	}
	//FUNCTION TO PRINT ALL THE ELEMENTS OF THE STACK
	public void show(){
		int i;
		if(top<0){
			System.out.println("Stack is empty!!!\n");
			return;
		}
		System.out.println("The stack contains:");
		for(i=0;i<=top;i++)
			System.out.print(stck[i]+"\t");
		System.out.println();
	}
	//METHOD SECTION ENDS HERE
}
