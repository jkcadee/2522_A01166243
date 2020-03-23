package ca.bcit.comp2522.labs.lab06;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Tests the LinkedList class.
 *
 * @author Janelle Kwok
 * @author BCIT
 * @version 2020
 */
public class LinkedListTest {

    private LinkedList<Integer> linkedListInteger = new LinkedList<>();
    private LinkedList<String> linkedListString = new LinkedList<>();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void creatingIntegerList() {
        for (int i = 0; i < 20; i++) {
            linkedListInteger.append(i);
        }
        linkedListInteger.append(4);
        linkedListInteger.append(7);
    }

    @Before
    public void creatingStringList() {
        for (int i = 0; i < 15; i++) {
            linkedListString.append(String.valueOf(i));
        }
        linkedListString.append("3");
    }

    @Test
    public void prependIntegerList() {
        linkedListInteger.prepend(4);
        final Integer expected = 4;
        assertEquals(expected, linkedListInteger.get(0));
    }

    @Test
    public void prependStringList() {
        linkedListString.prepend("6");
        final String expected = "6";
        assertEquals(expected, linkedListString.get(0));
    }

    @Test
    public void appendIntegerList() {
        linkedListInteger.append(189);
        final Integer expected = 189;
        assertEquals(expected, linkedListInteger.get(linkedListInteger.size() - 1));
    }

    @Test
    public void appendStringList() {
        linkedListString.append("Hello");
        final String expected = "Hello";
        assertEquals(expected, linkedListString.get(linkedListString.size() - 1));
    }

    @Test
    public void addIntegerList() {
        linkedListInteger.add(57, 4);
        final Integer expected = 57;
        assertEquals(expected, linkedListInteger.get(4));
    }

    @Test
    public void addStringList() {
        linkedListString.add("Rivers in the Desert", 5);
        final String expected = "Rivers in the Desert";
        assertEquals(expected, linkedListString.get(5));
    }

    @Test
    public void sizeIntegerList() {
        assertEquals(22, linkedListInteger.size());
    }

    @Test
    public void sizeStringList() {
        assertEquals(16, linkedListString.size());
    }

    @Test
    public void clearIntegerList() {
        linkedListInteger.clear();
        assertEquals(0, linkedListInteger.size());
    }

    @Test
    public void clearStringList(){
        linkedListString.clear();
        assertEquals(0, linkedListString.size());
    }

    @Test
    public void getIntegerList() throws IndexOutOfBoundsException {
        linkedListInteger.add(5, 5);
        final Integer expected = 5;
        assertEquals(expected, linkedListInteger.get(5));
    }

    @Test
    public void getStringList() throws IndexOutOfBoundsException {
        linkedListString.add("Persona 5", 5);
        final String expected = "Persona 5";
        assertEquals(expected, linkedListString.get(5));
    }

    @Test
    public void removeIntegerListFront() throws IndexOutOfBoundsException {
        linkedListInteger.remove(0);
        final Integer expected = 1;
        assertEquals(expected, linkedListInteger.get(0));
    }

    @Test
    public void removeStringListFront() throws IndexOutOfBoundsException {
        linkedListString.remove(0);
        final String expected = "1";
        assertEquals(expected, linkedListString.get(0));
    }

    @Test
    public void removeIntegerListBack() throws IndexOutOfBoundsException {
        linkedListInteger.remove(linkedListInteger.size() - 1);
        final Integer expected = 4;
        assertEquals(expected, linkedListInteger.get(linkedListInteger.size() - 1));
    }

    @Test
    public void removeStringListBack() throws IndexOutOfBoundsException {
        linkedListString.remove(linkedListString.size() - 1);
        final String expected = "14";
        assertEquals(expected, linkedListString.get(linkedListString.size() - 1));
    }

    @Test
    public void removeIntegerList() throws IndexOutOfBoundsException {
        linkedListInteger.remove(4);
        final Integer expected = 5;
        assertEquals(expected, linkedListInteger.get(4));
    }

    @Test
    public void removeStringList() throws IndexOutOfBoundsException {
        linkedListString.remove(8);
        final String expected = "9";
        assertEquals(expected, linkedListString.get(8));
    }

    @Test
    public void countIntegerList() throws EmptyListException, IllegalArgumentException {
        final Integer number = linkedListInteger.count(7);
        final Integer expected = 2;
        assertEquals(expected, number);
    }

    @Test
    public void countStringList() throws EmptyListException, IllegalArgumentException {
        final Integer number = linkedListString.count("3");
        final Integer expected = 2;
        assertEquals(expected, number);
    }

    @Test
    public void addThrowsException() throws IndexOutOfBoundsException {
        thrown.expect(IndexOutOfBoundsException.class);
        linkedListInteger.add(3, -1);
    }

    @Test
    public void getThrowsException() throws IndexOutOfBoundsException {
        thrown.expect(IndexOutOfBoundsException.class);
        linkedListString.get(-2);
    }

    @Test
    public void removeThrowsException() throws IndexOutOfBoundsException {
        thrown.expect(IndexOutOfBoundsException.class);
        linkedListString.remove(-200);
    }
}
