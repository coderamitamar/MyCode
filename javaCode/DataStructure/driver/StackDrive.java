package driver;
//import stack.*;
import queue.Deque;
import java.util.*;

public class StackDrive
{
	public static void main(String[] args)
	{
		int choice,getout=0,created=0,toRun=0;
		//int size;
		Object item=0;
		//MyStack S=null;
		//ArrayStack S=null;
		Deque S=null;
		Scanner sc=new Scanner(System.in);
		//run while user wants
		while(getout==0)
		{
			System.out.println("\t1> Create Stack");
			System.out.println("\t2> Push the element");
			System.out.println("\t3> Pop the element");
			System.out.println("\t4> See the elements");
			System.out.print("\t5> Exit\n  choice: ");
			choice=sc.nextInt();
			//switch to the choosed case
			switch(choice)
			{
				case 1:
					{
						//System.out.print("Enter the size of the stack: ");
						//size=sc.nextInt();
						//S=new MyStack(size);
						//S=new ArrayStack(size);
						S=new Deque();
						created=1;
						break;
					}
				case 2:
					{
						if(created==1)
						{
							System.out.print("Enter the item to be pushed: ");
							item=sc.nextInt();
							//S.push(item);
							S.insertLast(item);
						}
						else
							System.out.println("Stack is not available!!!\n");
						break;
					}
				case 3:
					{
						if(created==1)
						{
							//item=S.pop();
							item=S.removeLast();
							if(!item.equals("NotOk"))
								System.out.println("Poped element is: "+item);
							else
								System.out.println("Stack underflow!!!");
						}
						else
							System.out.println("Stack is not available!!!\n");
						break;
					}
				case 4:
				{
					if(created==1)
						S.show();
					else
						System.out.println("Stack is not available!!!\n");
					break;
				}
				case 5:
					{
						System.out.println("\t\t#### >>>>> OK BYE <<<<< ####");
						getout=1;
						break;
					}
				default:
					{
						System.out.println("\t>>> No service available for this choice");
						System.out.println("\t>>> Enter the correct choice\n");
						choice=6;
						break;
					}
			}
			//Ask the choice to continue
			while(true)
			{
				if(choice==5||choice==6)	break;
				System.out.print("\t1> Continue\n\t2> Exit\n  Choice: ");
				toRun=sc.nextInt();
				if(toRun==1)	break;
				else if(toRun==2)
				{
					System.out.println("\t\t#### >>>>> OK BYE <<<<< ####");
					getout=1;
					break;
				}
				else
				{
					System.out.println("\n\t>>> No service available for this choice");
					System.out.println("\t>>> Enter the correct choice\n");
				}
			}
		}
		//closing the scanner
		sc.close();
	}
}
