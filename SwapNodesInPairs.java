package leetcode;
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return head;
        }
        ListNode p=null,q=head,r=head.next;
        q.next = r.next;
        r.next = q;
        head = r;
        while( (p = q) != null && (q = q.next) != null && (r = q.next) != null){
            q.next = r.next;
            r.next = q;
            p.next = r;
        }
        return head;
    }

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
