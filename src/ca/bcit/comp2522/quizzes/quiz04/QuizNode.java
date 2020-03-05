package ca.bcit.comp2522.quizzes.quiz04;

import java.util.Objects;

public class QuizNode {
    private Object data;
    private QuizNode next;

    public QuizNode(final Object data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(QuizNode next) {
        this.next = next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getObject() {
        return this.data;
    }

    public QuizNode getNext() {
        return this.next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizNode node = (QuizNode) o;
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
