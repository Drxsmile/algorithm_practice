class Stack//based on array
{
	private int size;
	private int capacity;
	private String[] elements;
	public Stack(int capacity)
	{
		size = 0;
		this.capacity = capacity;
		elements = new String[capacity];
	}

	public boolean push(String item)
	{
		if(capacity == 0) return false;//throw exception
		if(size == capacity) resize(elements);
		elements[size++] = item;
		return true;
	}

	public String pop()
	{
		if(size == 0)  return null;//throw exception
		String temp = elements[--size];
		return temp;

	}

	public String peek()
	{
		if(size == 0) return null;
		return elements[size - 1];

	}

	public void resize(String[] arr)
	{

	}
}


public class StackTest
{
	public static void main (String[] args)
	{
		Stack<String> s = new Stack<>(6);
		System.out.println(s.elements.length);
	}
}

public class Stack//based on LinkedList
{
	 private ListNode top = null;

	public void push(int item)
	{
		ListNode newNode = new ListNode(item, null);
		if(top == null)
		{
			top = newNode;
			top.next = null;
		}
		else//头插
		{
			newNode.next = top;
			top = newNode;
		}
	}

	public int pop()
	{
		if(top == null) return -1;
		int temp = top.data;
		top = top.next;
		return temp;
	}

	public void printAll()
	{
		ListNode head = top;
		if(top == null) System.out.println("null");
		while(top.next != null)
		{
			System.out.print(top.data + ",");
			top = top.next;
		}
		System.out.println(top.data);
	}

	public static class ListNode
	{
		private int data;
		private ListNode next;
		ListNode(int data_, ListNode next_)
		{
			data = data_;
			next = next_;
		}
	}

}

























