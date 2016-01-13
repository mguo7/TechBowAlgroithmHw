import java.util.HashMap;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Question2 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null) {

			return null;
		}

		if (head.next == null) {
			return head;
		}

		if (m == n) {
			return head;
		}

		int low = m;
		int hight = n;
		if (m > n) {
			hight = m;
			low = n;
		}
		HashMap<Integer, Integer> nodes = new HashMap<Integer, Integer>();
		ListNode oldhead = new ListNode(0);
		ListNode oldtail = new ListNode(0);
		ListNode tmphead = oldhead;
		ListNode tmptail = oldtail;

		int counter = 1;
		int index = 0;
		while (head != null) {

			if (counter < low) {
				tmphead.next = new ListNode(head.val);
				tmphead = tmphead.next;
			} else if (counter > hight) {

				oldtail.next = new ListNode(head.val);
				tmptail = tmptail.next;
			} else {

				nodes.put(index, head.val);
				index++;
			}
			
			head = head.next;
			counter++;
		}
		
		oldhead = oldhead.next;
		oldtail = oldtail.next;
		
		ListNode result = new ListNode(0);
		ListNode tmp = result;
		int mapIndex = nodes.size();
		for(int i = 1;i<counter;i++){
			
			if(i<low){
				tmp.next = new ListNode(oldhead.val);
				oldhead = oldhead.next;
			} else if(i>hight){
				tmp.next = new ListNode(oldtail.val);
				oldtail = oldtail.next;
			} else {
				
				tmp.next = new ListNode(nodes.get(mapIndex));
				mapIndex--;
			}
			
			tmp = tmp.next;
		}

		return result;
	}
}