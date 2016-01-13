public class Question3 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode result = new ListNode(0);
		ListNode tmplist = result;
		// result = result.next;

		while (l1 != null && l2 != null) {

			if (l1.val <= l2.val) {

				tmplist.next = new ListNode(l1.val);
				l1 = l1.next;

			} else {

				tmplist.next = new ListNode(l2.val);
				l2 = l2.next;

			}

			tmplist = tmplist.next;
		}

		if (l1 == null) {
			tmplist.next = l2;
		}

		if (l2 == null) {
			tmplist.next = l1;
		}

		return result.next;
	}

}
