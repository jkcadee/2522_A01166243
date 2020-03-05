package ca.bcit.comp2522.quizzes.quiz04;

/**
 * A class that simulates a LinkedList with a add() method and a count() method.
 *
 * @author Janelle Kwok A01166243
 * @author Kayden Schmidt A01174919
 */

public class QuizLinkedList {
    private QuizNode head;

    public QuizLinkedList() {
        this.head = null;
    }

    public void add(Object data) {
        if (head == null) {
            QuizNode newQuizNode = new QuizNode(data);
            head = newQuizNode;
        } else {
            QuizNode iterator = head;
            while(iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            QuizNode newQuizNode = new QuizNode(data);
            iterator.setNext(newQuizNode);
        }
    }

    /**
     * Counts the number of nodes that contain an equal object to the one passed in the parameter.
     *
     * @param o Object against which to check.
     * @return The number of nodes that contain the object that was checked against.
     * @throws EmptyListException Throws this exception when the LinkedList has no elements.
     */
    public int count(Object o) throws EmptyListException {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        int counter = 0;
        if (head == null) {
            throw new EmptyListException();
        } else {
            QuizNode iterator = head;
            while(iterator.getNext() != null) {
                if (iterator.getObject() != null && iterator.getObject().equals(o)) {
                    counter++;
                }
                iterator = iterator.getNext();
            }
            if (iterator.getObject() != null && iterator.getObject().equals(o)) {
                counter++;
            }
            return counter;
        }
    }
}

class QuizDriver {
    public static void main(String[] args) throws EmptyListException {
        QuizLinkedList linkedList = new QuizLinkedList();

        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(4);
        linkedList.add(4);
        linkedList.add(5);

        int count = linkedList.count(5);
        System.out.println(count);

        QuizLinkedList emptyList = new QuizLinkedList();

        try {
            count = emptyList.count(5);
            System.out.println(count);
        } catch(EmptyListException e) {
            System.out.println(e.toString());
        }

        try {
            count = linkedList.count(null);
            System.out.println(count);
        } catch(IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
}
