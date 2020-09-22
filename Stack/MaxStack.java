public class MaxStack
{
	Stack<Integer> stack1 = new Stack<Integer> (); 
	Stack<Integer> stack2 = new Stack<Integer> ();
	public void push(int x)
	{
		stack1.push(x);
		if(stack2.size != 0) 
			int max = stack2.peek();
		else
			int max = Integer.MIN_VALUE;
		if(max < x)
		{
			max = x;
		}
		stack2.push(max);

	}
	public int pop()
	{
		stack2.pop();
		return stack1.pop();
	}
	public int top()
	{
		return stack1.peek();
	}
	public int getMax()
	{
		return stack2.peek();
	}
}
















