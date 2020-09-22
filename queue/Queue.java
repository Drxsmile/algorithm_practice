public class Queue //based on array
{
	private int size;
	private int capacity;
	private int front;
	private int rear;
	private String[] elements;
	public Queue(int cap)
	{
		capacity = cap;
		front = 0;
		rear = 0;
		size = 0;
		elements = new String[capacity];  
	}

}

public boolean add(String item)
{
	if(size == capacity) return false;
	size++;
	elements[rear] = item;//rear 所在位置是空的
	rear = (rear + 1) % capacity;
	return true;
}

public String poll()
{
	if(size == 0) return null;
	size--;
	String temp = elements[front];
	front = (front + 1) % capacity;
	return temp;
}

public String peek()
{
	if(size == 0) return null;
	return elements[front];
}

public class Queue  //based on LinkedList
{
	ListNode front = null;
	ListNode rear = front;
	public void enqueue(int item)
	{
		ListNode newnode = new ListNode(item);
		if(front == null)
		{
			front = newnode;
			rear = newnode;
		}
		else
		{
			rear.next = newnode;
			rear = newnode;
		}
	}

	public int dequeue()
	{
		if(front == null) return -1;
		int val = front.data;
		front = front.next;
		if(front == null) rear = null;
		return val;
	}
	public static class ListNode
	{
		private int data;
		private ListNode next;
		ListNode(int data, ListNode next)
		{
			this.data = data;
			this.next = next;
		}
		ListNode(int data)
		{
			this(data, null);
		}
	}
}
















