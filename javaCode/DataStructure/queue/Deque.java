package queue;

class DLLNode
{
	//variable section
	private Object data;
	private DLLNode next;
	private DLLNode prev;
	
	//Constructor section
	public DLLNode()
	{
		data="I am null";
		next=null;
		prev=null;
	}
	public DLLNode(DLLNode obj)
	{
		data=obj.data;
		next=obj.next;
		prev=obj.prev;
	}
	public DLLNode(Object data)
	{
		this.data=data;
		next=null;
		prev=null;
	}
	public DLLNode(DLLNode next,DLLNode prev)
	{
		data="i am null";
		this.next=next;
		this.prev=prev;
	}
	
	//method section
	public Object getData()
	{
		return this.data;
	}
	public void setData(Object data)
	{
		this.data=data;
	}
	public DLLNode getNext()
	{
		return this.next;
	}
	public void setNext(DLLNode n)
	{
		this.next=n;
	}
	public DLLNode getPrev()
	{
		return this.prev;
	}
	public void setPrev(DLLNode p)
	{
		this.prev=p;
	}
}
public class Deque
{
	//variable section
	private DLLNode head,tail;	//these are sentinals
	private DLLNode trv;		//this is to traverse the list
	private int size;
	
	//Constructor section
	public Deque()
	{
		head=new DLLNode();
		tail=new DLLNode();
		head.setNext(tail);
		tail.setPrev(head);
		trv=null;
		size=0;
	}
	
	//method section
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return (head.getNext()==tail);
	}
	public void insertFirst(Object data)
	{
		trv=new DLLNode(data);
		if(isEmpty())
		{
			trv.setNext(tail);
			trv.setPrev(head);
			head.setNext(trv);
			tail.setPrev(trv);
			
		}
		else
		{
			trv.setNext(head.getNext());
			trv.setPrev(head);
			head.getNext().setPrev(trv);
			head.setNext(trv);
		}
		size++;
		trv=null;
	}
	public Object removeFirst()
	{
		if(isEmpty())
			return "NotOk";
		else if(size==1)
		{
			trv=head.getNext();
			head.setNext(tail);
			tail.setPrev(head);
			trv.setNext(null);
			trv.setPrev(null);
		}
		else
		{
			trv=head.getNext();
			head.setNext(trv.getNext());
			trv.getNext().setPrev(head);
			trv.setNext(null);
			trv.setPrev(null);
		}
		return trv.getData();
	}
	public void insertLast(Object data)
	{
		trv=new DLLNode(data);
		if(isEmpty())
		{
			trv.setNext(tail);
			trv.setPrev(head);
			head.setNext(trv);
			tail.setPrev(trv);
			
		}
		else
		{
			trv.setNext(tail);
			trv.setPrev(tail.getPrev());
			tail.getPrev().setNext(trv);
			tail.setPrev(trv);
		}
		size++;
		trv=null;
	}
	public Object removeLast()
	{
		if(isEmpty())
			return "NotOk";
		else if(size==1)
		{
			trv=head.getNext();
			head.setNext(tail);
			tail.setPrev(head);
			trv.setNext(null);
			trv.setPrev(null);
		}
		else
		{
			trv=tail.getPrev();
			tail.setPrev(trv.getPrev());
			trv.getPrev().setNext(tail);
			trv.setNext(null);
			trv.setPrev(null);
		}
		return trv.getData();
	}
	public void show()
	{
		if(isEmpty())
			System.out.println("Queue is empty!!!");
		else
		{
			for(trv=head.getNext();trv!=tail;trv=trv.getNext())
				System.out.print(trv.getData()+"\t");
			System.out.println();
			trv=null;
		}
	}
}
