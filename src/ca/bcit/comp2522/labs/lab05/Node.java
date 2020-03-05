package ca.bcit.comp2522.labs.lab05;

import java.util.Objects;

public class Node {
    private Object data;
    private Node next;

    public Node(final Object data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getObject() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("data=").append(data);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
