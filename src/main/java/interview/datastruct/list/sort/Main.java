package interview.datastruct.list.sort;

public class Main {
	public static void main(String[] args) {
		Node node1 = new Node(1);
        Node node2 = new Node(8);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        Node node5 = new Node(5);
        Node node6 = new Node(4);
        Node node7 = new Node(7);
        Node node8 = new Node(2);
        Node node9 = new Node(9);
        
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4); 
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7); 
        node7.setNext(node8);
        node8.setNext(node9);
	
        Node head = node1;
        print(head);
        head = reverse(head);
        print(head);
        
	}
	
	public static void print(Node head) {
		Node node = head;
		while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
		System.out.println();
	}
	public static Node reverse(Node head) {
		Node pre = null;
		Node behind = null;
		while (head.getNext() != null) {
			behind = head.getNext();
			head.setNext(pre);
			pre = head;
			head = behind;
		}
		head.setNext(pre);
		return head;
	}
	
	public static void divide(Node head) {
		int cnt = 1;
		Node head1 = new Node();
		Node head2 = new Node();
		Node cur1 = head1;
		Node cur2 = head2;
		while (head != null) {
			if (cnt % 2 == 1) {
				head1.setNext(head);
				cur1 = cur1.getNext();
			} else {
				head2.setNext(head);
				cur2 = cur2.getNext();
			}
			head = head.getNext();
		}
	}
}
