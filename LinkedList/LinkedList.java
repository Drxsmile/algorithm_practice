public class LinkedNode{
	int data;
	LinkedNode next;
	LinkedNode(int val)
	{
		this.data = val;
	}
}

public class LinkedList{
    
    private ListNode head = null;
    private ListNode tail = null;
    private int size = 0;
 
}//recommended!

public class LinkedList{
    public void checkBoundsExclusive(int index) {
        if (index < 0 || index >= size) {
            // throw Exception.
            return;
        }
    }
        
    public ListNode getEntry(int index) {
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;    
        }
        //loop也可以写成
        /*
        while(index--!=0)
        {
            cur = cur.next;
        }
        */
        return cur;
    }
    
    public int get(int index) {
        checkBoundsExclusive(index);
        return getEntry(index).val;
    }

    public void set(int val, int index)
    {
        checkBoundsExclusive(index);
        getEntry(index).data = val;

    }

    public void add(int index, int val)//no dummy node
    {
        checkBoundsExclusive(index);
        size++;
        ListNode newNode = new ListNode(val);
        if(index ==0)
        {
            newNode.next = head;
            head = newNode;
            return;
            
        }
        else
        {
            ListNode pre = getEntry(index-1);
            newNode.next = pre.next;
            pre.next = newNode;

        }
        
    }

    public void remove(int index)//no dummy node
    {
        checkBoundsExclusive(index);
        size--;
        if(index == 0)
        {
            head = head.next;
            return;
        }
        ListNode pre = getEntry(index -1);
        pre.next = pre.next.next;
    }

    public void add(int index, int val)//with dummy node
    {
        checkBoundsExclusive(index);
        size++;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //head = dummy;一顿操作之后head不一定在哪了，最后还是得重新找head，所以这不改也行

        ListNode newNode = new ListNode(val);
        //接下来我要找插入点的pre
        ListNode pre = dummy;

        while(index-- !=0)//=getEntry(index-1)
        {
            pre = pre.next;
        }
        newNode.next = pre.next;
        pre.next = newNode;
        head = dummy.next;
    }

    public void remove(int index)//with dummy node
    {
        checkBoundsExclusive(index);
        size--;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //find pre
        ListNode pre = dummy;
        while(index--!=0)
        {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        head = dummy.next;
    }

}






























