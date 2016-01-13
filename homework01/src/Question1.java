import java.util.TreeSet;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Question1 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null) {

			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode tmp = head;
		TreeSet<Integer> numset = new TreeSet<Integer>();
		numset.add(head.val);

		boolean del = false;
		while (tmp.next != null) {

			if (tmp.val == tmp.next.val) {

				del = true;

			} else if (tmp.val != tmp.next.val) {

				if (del == true) {

					numset.remove(tmp.val);
					numset.add(tmp.next.val);
					del = false;
				} else if (del == false) {

					numset.add(tmp.next.val);

				}

			}
			 
			tmp = tmp.next;
		}

		if (del == true) {

			numset.remove(tmp.val);
		}

		if (numset.size() < 1) {

			return null;
		}

		ListNode result = new ListNode(numset.iterator().next());
		numset.remove(result.val);
		ListNode tmplist = result;
		for (Integer num : numset) {
			tmplist.next = new ListNode(num);
			tmplist = tmplist.next;
		}

		return result;

	}

}
