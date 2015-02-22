

public class LinkedListCycle {
	
	class ListNode{
		int val;
		public ListNode next;
		ListNode(int x)
		{
			val = x;
			next = null;
		}
		
	}
	
    public boolean hasCycle(ListNode head) {
    	if(head == null || head.next == null) return false;
        if(head.next == head) return true;
        ListNode nextNode = head.next; 
        head.next = head;
        boolean isCycle = hasCycle(nextNode);
        return isCycle;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListCycle llc = new LinkedListCycle();
		boolean result = llc.hasCycle(null);
		System.out.println(result);
	}

}
