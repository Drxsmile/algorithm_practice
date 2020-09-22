package learn;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> s = new Stack<>();
		//System.out.println(s.elements.length);
	}

}

class Stack extends Object
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
}




















