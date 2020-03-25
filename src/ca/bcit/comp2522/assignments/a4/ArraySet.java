package ca.bcit.comp2522.assignments.a4;

import java.lang.reflect.Array;
import java.util.Arrays;

;

/**
 * <p>ArraySet is a resizeable-array implementation of the Set interface. It
 * contains a set of elements in no particular order that excludes duplicates or
 * nulls.</p>
 * 
 * <p>Elements may be added to, removed from, and searched for in the ArraySet. As
 * elements are added to the ArraySet its capacity is resized automatically.</p>
 * 
 * <p>ArraySet contains a SetIterator that permits access to the elements in the
 * ArraySet one at a time.</p>
 * 
 * @author Your name
 * @version Date
 * @invariant The ArraySet never contains duplicate elements.
 * @invariant The ArraySet never contains nulls.
 */
public class ArraySet<E> implements Set<E>, MyIterable<E> {

    /**
     * The initial capacity of the ArraySet.
     */
    public static final int INITIAL_CAPACITY = 10;

    /**
     * The capacity of the ArraySet.
     */
    protected int capacity;

    /**
     * The number of elements contained in the ArraySet.
     */
    protected int elementCount;

    /**
     * The array buffer that stores the elements of the ArraySet.
     */
    protected E[] collection;

    /**
     * Constructs a new empty ArraySet of default initial capacity 10.
     * 
     * @pre true
     * @post size() = 0.
     */
    public ArraySet() {
        // Your code goes here
        this.collection = (E[]) new Object[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    /**
     * Adds the specified element to the ArraySet if it is not already present.
     * 
     * @param element The element to be added to the set.
     * @pre true
     * @post IF ( element != null AND NOT @pre.contains(element) ) THEN
     *       contains(element) ELSE the ArraySet is not changed
     * @return true if the ArraySet did not already contain the specified
     *         element, else false.
     */
    public boolean add(final E element) {
        // Your code goes here
        if (element == null || contains(element)) {
            return false;
        }

        if (size() == capacity) {
                resize();
        }
        if (collection[size()] == null) {
            collection[size()] = element;
            return true;
        }
        return true;
    }

    /**
     * Removes the specified element from the ArraySet if it exists.
     * 
     * @param element The element to be removed, if present.
     * @pre true
     * @post IF @pre.contains(element) THEN NOT contains(element) ELSE the
     *       ArraySet is not changed
     * @return true if element was removed from the ArraySet, else false.
     */
    public boolean remove(final E element) {
        // Your code goes here
        if (element == null || !contains(element)) {
            return false;
        }
        int index = -1;
        SetIterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            index++;
            E nextElement = iterator.next();
            if (nextElement.equals(element)) {
                collection[index] = collection[size()- 1];
                collection[size() - 1] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all elements from the ArraySet. The ArraySet will be empty after
     * this call returns.
     * 
     * @pre true
     * @post size() = 0
     */
    public void clear() {
        // Your code goes here
        Arrays.fill(collection, null);
        capacity = size();
    }

    /**
     * Returns true if this ArraySet contains the specified element.
     * 
     * @param element The element to be checked for containment.
     * @pre true
     * @post true
     * @return true if element is in the ArraySet, and false otherwise.
     */
    public boolean contains(final E element) {
        // Your code goes here.nm,
        if (element == null || size() == 0) {
            return false;
        }

        for (E elements : collection) {
            if (elements == null) {
                return false;
            }
            if (elements.hashCode() == element.hashCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in the ArraySet (its cardinality).
     * 
     * @pre true
     * @post true
     * @return The number of elements in the ArraySet.
     */
    public int size() {
        // Your code goes here
        elementCount = 0;
        for (E element : collection) {
            if (element != null) {
                elementCount++;
            }
        }
        return elementCount;
    }

    /**
     * Doubles the size of the ArraySet.
     * 
     * @pre true
     * @post the capacity of the ArraySet is doubled.
     */
    private void resize() {
        // Your code goes here
        collection = Arrays.copyOf(collection, capacity * 2);
        capacity = collection.length;
    }

    /**
     * Creates and returns an array containing the elements of the ArraySet.
     * 
     * @pre true
     * @post true
     * @return an unordered array containing the elements of the ArraySet.
     */
    public Object[] toArray() {
        // Your code goes here
        Object[] array = new Object[size()];
        for (int index = 0; index < size(); index++) {
            array[index] = collection[index];
        }
        return array;
    }

    @Override
    public String toString() {
        return "ArraySet{" +
                "capacity=" + capacity +
                ", elementCount=" + elementCount +
                ", collection=" + Arrays.toString(collection) +
                '}';
    }

    /**
     * Returns an iterator over the elements in this ArraySet. The elements are
     * returned in no particular order.
     * 
     * @pre true
     * @post true
     * @return an iterator for the ArraySet of elements that points to the first
     *         element in the ArraySet.
     */
    public SetIterator<E> iterator() {
        // Your code goes here
        return new SetIterator<>();
    }

    /**
     * SetIterator provides a means for iterating over the elements of an
     * ArraySet.
     */
    private class SetIterator<E> implements MyIterator<E> {

        /**
         * Returns true if the iteration has more elements.
         * 
         * @pre true
         * @post true
         * @return true if the iteration has more elements, false otherwise.
         */
        private int position = 0;

        @Override
        public boolean hasNext() {
            // Your code goes here
            return position < capacity && collection[position] != null;
        }

        /**
         * Returns the next element in the iteration and advances to point to
         * the next.
         * 
         * @pre @pre.hasNext()
         * @post SetIterator points to the next element in the ArraySet.
         * @return the element pointed to by the SetIterator when the method is
         *         called.
         */
        @Override
        public E next() {
            if (hasNext()) {
                return (E) collection[position++];
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ArraySet<Integer> arraySet = new ArraySet<>();

        for (int i = 0; i < 20; i++) {
            arraySet.add(i);
        }
        System.out.println(arraySet.toString());
        arraySet.remove(4);
        System.out.println(arraySet.contains(4));
    }
}
