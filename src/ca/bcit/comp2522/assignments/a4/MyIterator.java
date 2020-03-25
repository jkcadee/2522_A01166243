package ca.bcit.comp2522.assignments.a4;;

/**
 * A parameterized means to iterate over the elements of a collection.
 *
 * @author BCIT
 * @version 2020
 */
public interface MyIterator<E> {
    
    /**
     * Checks if there are more element in the collection to iterate over.
     * @pre true
     * @post true
     * @return true if there are more element in the collection to iterate over, false otherwise
     */
    boolean hasNext();

    /**
     * Returns the next element in the collection the iterator walks over.
     * @pre hasNext() == true
     * @post MyIterator points to the next element in the collection
     * @return The element in the collection the iterator was pointing to when the method was called.
     */
    E next();
}
