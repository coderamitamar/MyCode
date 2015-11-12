package driver;

import java.util.Scanner;
//import queue.ArrCirQueue;
//import queue.LLCirQueue;
import queue.QueueByCirLL;

public class QueueDrive
{
	public static void main(String[] args)
	{
		int choice,getout=0,created=0,toRun=0;
		//int size;
		Object item=0;
		//ArrCirQueue Q=null;
		//LLCirQueue Q=null;
		QueueByCirLL Q=null;
		Scanner sc=new Scanner(System.in);
		//run while user wants
		while(getout==0)
		{
			System.out.println("\t1> Create Queue");
			System.out.println("\t2> Enqueue the element");
			System.out.println("\t3> Dequeue the element");
			System.out.println("\t4> See the elements");
			System.out.print("\t5> Exit\n  choice: ");
			choice=sc.nextInt();
			//switch to the choosed case
			switch(choice)
			{
				case 1:
					{
						//System.out.print("Enter the size of the queue: ");
						//size=sc.nextInt();
						//Q=new ArrCirQueue(size);
						//Object set[]={1,2,3,4,5};
						Q=new QueueByCirLL();
						created=1;
						break;
					}
				case 2:
					{
						if(created==1)
						{
							System.out.print("Enter the item to be enqueued: ");
							item=sc.nextInt();
							Q.enqueue(item);
						}
						else
							System.out.println("Queue is not available!!!\n");
						break;
					}
				case 3:
					{
						if(created==1)
						{
							item=Q.dequeue();
							if(!item.equals("NotOk"))
								System.out.println("Dequeued element is: "+item);
							else
								System.out.println("Queue is empty!!!");
						}
						else
							System.out.println("Queue is not available!!!\n");
						break;
					}
				case 4:
				{
					//System.out.println(Q.getSize());
					if(created==1)	Q.show();
					else
						System.out.println("Queue is not available!!!\n");
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
