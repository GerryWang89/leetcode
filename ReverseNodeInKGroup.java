package leetcode;

public class ReverseNodeInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        ListNode pre;
        int len = 0;
        while(p != null){
            len++;
            p = p.next;
        }
        if(k > len)
            return head;
        if(head == null || head.next == null)
            return head;
        if(k == 1)
            return head;
        ListNode ori = new ListNode(0);
        pre = ori;
        p = head;
        ori.next = head;
        ListNode q = p.next;
        ListNode r = q.next;
        for(int m = 0; m < len/k; m++){
            int i = 1;
            p = pre.next;
            q = p.next;
            r = q.next;
	        while(i < k){
	            q.next = p;
	            p = q;
	            q = r;
	            if(r != null)
	                r = r.next;
	            i++;
	        }
	        pre.next.next = q;
	        ListNode tmp = pre.next;
	        pre.next = p;
	        pre = tmp;
        }
        return ori.next;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		new ReverseNodeInKGroup().reverseKGroup(head, 2);
	}

}
