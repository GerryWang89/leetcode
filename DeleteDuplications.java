package leetcode;
public class DeleteDuplications {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		head = new ListNode(0);
		ListNode r = head;
		int val = p.val;
		boolean isFirst = true;
		while (p != null) {
			if (p.next == null) {
				if (isFirst) {
					r.next = p;
					r = r.next;
				}
				break;
			}
			if (p.next.val == val) {
				isFirst = false;
			} else {
				val = p.next.val;
				if (isFirst) {
					r.next = p;
					r = r.next;
				}
				isFirst = true;
			}
			p = p.next;
		}
		r.next = null;
		return head.next;
	}
}
