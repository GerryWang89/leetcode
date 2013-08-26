package leetcode;

public class AddTwoNumber {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p = new ListNode(-1);
        ListNode s = p;
        int carry = 0;
        while(l1 != null && l2 != null){
            p.next = new ListNode(-1);
            p = p.next;
        	p.val = (l1.val + l2.val+carry)%10;
        	carry = (l1.val + l2.val+carry)/10;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        if(l1 == null && l2 != null){
        	p.next = addTwoNumbers(new ListNode(carry),l2);
        }else if(l2 == null && l1 != null){
        	p.next = addTwoNumbers(new ListNode(carry),l1);
        }else{
        	if(carry != 0){
            	p.next = new ListNode(carry);
        	}
        }
        return s.next;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new AddTwoNumber().addTwoNumbers(new ListNode(0), new ListNode(0));
	}

}
