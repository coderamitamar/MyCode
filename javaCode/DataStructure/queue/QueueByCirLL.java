package queue;

public class QueueByCirLL
{
	//Variable section
	private LLNode head;
	private LLNode trv;
	private int size;
	
	//Constructor section
	public QueueByCirLL()
	{
		head=null;
		trv=null;
		size=0;
	}
	
	//Method section
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return (size()==0);
	}
	public void enqueue(Object data)
	{
		if(isEmpty())
		{
			head=new LLNode(data);
			head.setNext(head);
		}
		else
		{
			trv=new LLNode(data);
			trv.setNext(head.getNext());
			head.setNext(trv);
			head=head.getNext();
		}
		size++;
		trv=null;
	}
	public Object dequeue()
	{
		if(isEmpty())
			return "NotOk";
		else
		{
			Object temp;
			if(size()==1)
			{
				temp=head.getData();
				head=null;
			}
			else
			{
				trv=head.getNext();
				head.setNext(head.getNext().getNext());
				trv.setNext(null);
				temp=trv.getData();
			}
			size--;
			return temp;
		}
	}
	public void show() 
	{
		if(isEmpty())
			System.out.println("Queue is empty!!!");
		else
		{
			for(trv=head.getNext();trv!=head;trv=trv.getNext())
				System.out.print(trv.getData()+"\t");
			System.out.print(trv.getData()+"\t");
			System.out.println();
			trv=null;
		}
	}
}
