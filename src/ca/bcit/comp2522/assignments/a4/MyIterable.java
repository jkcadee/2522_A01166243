package ca.bcit.comp2522.assignments.a4;;

/**
 * Provides a means to access a parameterized iterator.
 *
 * @author BCIT
 * @version 2020
 */
public interface MyIterable<E> {
    /**
     * Returns an iterator for a set of elements.
     * @pre true
     * @post the set is not changed
     * @return An iterator for the set of elements that points to the beginning of the set.
     */
    MyIterator<E> iterator();
}
