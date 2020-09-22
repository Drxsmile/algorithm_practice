//count related
// linked list length
public int length(ListNode head)
{
	int len = 0;
	ListNode cur = head;
	while(cur != null)
	{
		len++;
		cur = cur.next
		
	}
	return len;
}

//kth node from the end
//method1:length-k 
//method2: fast slow

public ListNode kthNode(ListNode head, int k)
{
	ListNode fast = head;
	ListNode slow = head;
	while(k-- !=0)
	{
		fast = fast.next;
	}
	while(fast != null)
	{
		fast = fast.next;
		slow = slow.next;

	}
	return slow;
}

//Middle node

public ListNode middleNode(ListNode head)
{
	ListNode fast = head;
	ListNode slow = head;
	while(fast.next.next != null && fast.next != null)
	{
		fast = fast.next.next;
		slow = slow.next;
	}
	return slow;
}

public boolean ifCircle(ListNode head)
{
	boolean res = false;
	if (head == null) return res;
	ListNode fast = head;
	ListNode slow = head;
	while(fast.next != null &&fast.next.next != null)
	{
		slow = slow.next;
		fast = fast.next.next;
		if(slow == fast)
		{
			res = true;
			break;
		}
	} 
	return res;

}


















































