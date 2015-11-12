package queue;

public class ArrCirQueue
{
	//variable section
	private Object queue[];
	private int front,rear;
	private int maxSize;
	
	//Constructor section
	public ArrCirQueue()
	{
		maxSize=2;
		front=-1;
		rear=0;
		queue=new Object[2];
	}
	public ArrCirQueue(int size)
	{
		maxSize=size+1;
		front=-1;
		rear=0;
		queue=new Object[size+1];
	}
	
	//method section
	public int size()
	{
		if(front==-1)	return 0;
		return (maxSize-front+rear)%maxSize;
	}
	public boolean isEmpty()
	{
		if(front==-1)	return true;
		return (front==rear);
	}
	public boolean isFull()
	{
		if(this.size()==maxSize-1)
			return true;
		return false;
	}
	public Object front()
	{
		if(this.isEmpty())
			return "empty";
		return queue[front];
	}
	public void enqueue(Object o)
	{
		if(this.isFull())
			System.out.println("Queue is full!!!");
		else
		{
			if(front==-1)	front=0;
			queue[rear]=o;
			rear=(rear+1)%maxSize;
		}
	}
	public Object dequeue()
	{
		if(this.isEmpty())
			return "NotOk";
		else
		{
			Object o=queue[front];
			queue[front]=null;
			front=(front+1)%maxSize;
			return o;
		}
	}
	public void show()
	{
		int i;
		if(this.isEmpty())
		{
			System.out.println("Queue is empty!!!\n");
			return;
		}
		System.out.println("The queue contains:");
		if(front<rear)
			for(i=front;i<rear;i++)
				System.out.print(queue[i]+"\t");
		else
		{
			for(i=front;i<maxSize;i++)
				System.out.print(queue[i]+"\t");
			for(i=0;i<rear;i++)
				System.out.print(queue[i]+"\t");
		}
		System.out.println();
	}
}
