public class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void displayList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverse() {
        if (head == null) return;

        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    public void deleteAlternateNodes() {
        if (head == null) return;

        Node temp = head;
        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;
            temp.next = nextNode.next;
            if (nextNode.next != null) {
                nextNode.next.prev = temp;
            }
            nextNode = null;
            temp = temp.next;
        }
    }

    public void swapNodes(int data1, int data2) {
        if (head == null) return;

        Node node1 = head, node2 = head;

        while (node1 != null && node1.data != data1) {
            node1 = node1.next;
        }
        while (node2 != null && node2.data != data2) {
            node2 = node2.next;
        }

        if (node1 == null || node2 == null) {
            System.out.println("Nodes with the specified data not found.");
            return;
        }

        int tempData = node1.data;
        node1.data = node2.data;
        node2.data = tempData;
    }

    public int countOccurrences(int data) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

    public void insertAfter(int newData, int prevNodeData) {
        if (head == null) return;

        Node temp = head;
        while (temp != null && temp.data != prevNodeData) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node with specified previous data not found.");
            return;
        }

        Node newNode = new Node(newData);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }
}
