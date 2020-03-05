package ca.bcit.comp2522.labs.lab05;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(Object data) {
        if (head == null) {
            Node newNode = new Node(data);
            head = newNode;
        } else {
            Node iterator = head;
            while(iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            Node newNode = new Node(data);
            iterator.setNext(newNode);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinkedList{");
        sb.append("head=").append(head);
        sb.append('}');
        return sb.toString();
    }
}

class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);

        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);

        System.out.println(linkedList.toString());
    }
}