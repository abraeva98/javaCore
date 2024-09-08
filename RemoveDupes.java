import java.util.Map;
import java.util.HashMap;

class LinkedList {
    LinkedList next = null;
    int val;

    public LinkedList(int val) {
        this.val = val;
    }
}

class RemoveDupes {
    private LinkedList removeDupes(LinkedList head) {
        ListNode helper = head;
        Map<Integer, Integer> occurrence = new HashMap<>();
        while(helper != null) {
            occurrence.put(helper.val, occurrence.getOrDefault(helper.val, 0) + 1);
            helper = helper.next;
        }
        while(head != null && occurrence.get(head.val) > 1) {
            head = head.next;
        }
        ListNode removeHelper = head;
        while(removeHelper != null && removeHelper.next != null) {
            if(occurrence.get(removeHelper.next.val) > 1) {
                removeHelper.next = removeHelper.next.next;
            } else {
                removeHelper = removeHelper.next;
            }
        }
        return head;       
    }
    public static void main(String args[]) {
        LinkedList head = new LinkedList(5);
        LinkedList pointer = head;
        pointer.next = new LinkedList(6);
        pointer.next.next = new LinkedList(6);
        pointer.next.next.next = new LinkedList(7);
        pointer.next.next.next.next = new LinkedList(5);
        LinkedList noDupesList = new RemoveDupes().removeDupes(head);
    }
}