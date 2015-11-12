package queue;

class LLNode
{
	//variable section
	private Object data;
	private LLNode next;
	
	//Constructor section
	LLNode()
	{
		data="I am Null";
		next=null;
	}
	LLNode(LLNode l)
	{
		data=l.data;
		next=l.next;
	}
	LLNode(Object data)
	{
		this.data=data;
		next=null;
	}
	
	//method section
	public Object getData()
	{
		return data;
	}
	public void setData(Object data)
	{
		this.data=data;
	}
	public LLNode getNext()
	{
		return next;
	}
	public void setNext(LLNode next)
	{
		this.next=next;
	}
}
public class LLCirQueue
{
	//variable section
	private LLNode head,tail;
	private LLNode trv;
	private int size;
	
	//Constructor section
	public LLCirQueue()
	{
		head=null;
		tail=null;
		size=0;
	}
	public LLCirQueue(Object[] set)
	{
		for(Object k:set)
			enqueue(k);
	}
	
	//Method section
	public int getSize()
	{
		return this.size;
	}
	public boolean isEmpty()
	{
		return (head==null);
	}
	public Object getFront()
	{
		return head.getData();
	}
	public void enqueue(Object o)
	{
		trv=new LLNode(o);
		if(isEmpty())
		{
			head=trv;
			tail=trv;
		}
		else
		{
			tail.setNext(trv);
			tail=trv;
		}
		size++;
		trv=null;
	}
	public Object dequeue()
	{
		if(isEmpty())
			return "NotOk";
		else if(head==tail)
		{
			trv=head;
			head=null;
			tail=null;
			size--;
		}
		else
		{
			trv=head;
			head=head.getNext();
			size--;
		}
		return trv.getData();
	}
	public void show()
	{
		if(isEmpty())
			System.out.println("Queue is empty!!!");
		else
		{
			for(trv=head;trv!=tail;trv=trv.getNext())
				System.out.print(trv.getData()+"\t");
			System.out.println(trv.getData());
			trv=null;
		}
	}
}
