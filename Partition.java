class LinkedList {
    LinkedList next = null;
    int val;

    public LinkedList(int val) {
        this.val = val;
    }
}

class Partition {
    private static LinkedList partition(LinkedList head, int target) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode tail = prev;
        int counter = 0;
        while(tail.next != null) {
            tail = tail.next;
            counter += 1;
        }

        while(prev != null && prev.next != null) {
            counter -= 1;
            if(prev.next.val >= x) {
                tail.next = new ListNode(prev.next.val);
                tail = tail.next;
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
            if(counter == 0) {
                return dummy.next;
            }
        }
        return dummy.next;
    }

    public static void main(String args[]) {
        LinkedList pointer = new LinkedList(5);
        pointer.next = new LinkedList(6);
        pointer.next.next = new LinkedList(6);
        pointer.next.next.next = new LinkedList(7);
        pointer.next.next.next.next = new LinkedList(5);
        LinkedList res = Partition.partition(pointer, 6);
    }
}