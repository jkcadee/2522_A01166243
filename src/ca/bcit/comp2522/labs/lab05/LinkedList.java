package ca.bcit.comp2522.labs.lab05;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

//    public void add(Object data) {
//        if (head == null) {
//            Node newNode = new Node(data);
//            head = newNode;
//        } else {
//            Node iterator = head;
//            while(iterator.getNext() != null) {
//                iterator = iterator.getNext();
//            }
//            Node newNode = new Node(data);
//            iterator.setNext(newNode);
//        }

    public void prepend(Object data) {
        if (head == null) {
            Node newNode = new Node(data);
            head = newNode;
        } else {
            Node newHeadNode = new Node(data);
            newHeadNode.setNext(head);
            head = newHeadNode;
        }
    }

    public void append(Object data) {
        if (head == null) {
            Node newNode = new Node(data);
            head = newNode;
        } else {
            Node headIterator = head;
            while (headIterator.getNext() != null) {
                headIterator = headIterator.getNext();
            }
            Node newEndNode = new Node(data);
            headIterator.setNext(newEndNode);
        }
    }

    public void add(Object data, int index) {
        if (head == null) {
            Node newNode = new Node(data);
            head = newNode;
        } else {
            Node headIterator = head;
            if (index < 0) {
                throw new IndexOutOfBoundsException();
            }
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                headIterator = headIterator.getNext();
            }
            if (headIterator == null) {
                throw new IndexOutOfBoundsException();
            }
            
        }
    }

    public int size() {
        int counter = 0;
        if (head == null) {
            return counter;
        }
        Node headIterator = head;
        while (headIterator.getNext() != null) {
            counter++;
            headIterator = headIterator.getNext();
        }
        return counter + 1;
    }

    public void clear() {
        head = null;
    }

    public Object get (int index) {
        if (index < size() - 1 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node headIterator = head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            headIterator = headIterator.getNext();
        }
        return headIterator;
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

        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        int size = linkedList.size();
        Object nodeGet = linkedList.get(2);

        System.out.println(linkedList.toString());
        System.out.println(size);
        System.out.println(nodeGet);
    }
}