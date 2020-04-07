package ca.bcit.comp2522.assignments.a5;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * QUESTION 1
 * This pipeline takes the elements of the List, type Integer and filters them buy calculating
 * if the modulo of an element when divided by two (even) is not equal to zero. If it is not,
 * it will sum the current element and all other elements that fall under that condition.
 * The pipeline finds the sum of all odd numbers in a List of Integers.
 *
 * QUESTION 2
 * The first operation of this pipeline generates 1 million numbers between the range 1 (inclusive)
 * and 3 (exclusive). The second operation boxes each element in the stream into an Integer object
 * from an IntStream object. It returns a Stream of Integer objects. The third operation creates a
 * Map object by grouping them by two different sets. The key is the identity of the object, in this
 * case, being 1 or 2. The value is the amount of times the identical object appears in the stream.
 * The final operation prints out the contents of the Map.
 *
 * QUESTION 9
 * Stream.of() returns a Stream of the Object type that is passed in as a parameter. The Stream will
 * be sequential, and contain the same elements as the collection that was passed into it as a
 * parameter.
 *
 * It is not directly possible to create a Stream<int>, this is because Streams, like the
 * Collections Framework, only accepts Objects. You could turn the stream into the Object version of
 * the primitive type, or you could do the stream operations first, and place the elements into a
 * collection like a List and turn that list into an array of the primitive type.
 *
 * Runs various answers to questions asked about streaming in Java.
 *
 * @author Janelle Kwok
 * @version 2020
 */
public class Streaming {
    /**
     * Creates a List object of Characters from ASCII values 97 to 122.
     *
     * @pre true.
     * @post characterList is not null.
     * @return A List of Characters.
     */
    public static List<Character> words() {
        Random random = new Random();
        List<Character> characterList = new ArrayList<>();

        final int numberOfCharacters = 30;
        final int boundForNextInt = 26;
        final int addingForASCII = 97;

        for (int index = 0; index < numberOfCharacters; index++) {
            characterList.add((char) (addingForASCII + random.nextInt(boundForNextInt)));
        }

        return characterList;
    }

    /**
     * Sorts a List of Characters in ascending order.
     *
     * @pre characterList is not null.
     * @post characterList is sorted and not null.
     * @param characterList A list of Character Objects.
     * @return A sorted list of Character Objects.
     */
    public static List<Character> ascendingSort(List<Character> characterList) {
        return characterList.stream()
                .sorted(Character::compareTo)
                .collect(Collectors.toList());
    }

    /**
     * Sorts a List of Characters in descending order.
     *
     * @pre characterList is not null.
     * @post characterList is sorted and not null.
     * @param characterList A list of Character Objects.
     * @return A sorted list of Character Objects.
     */
    public static List<Character> descendingSort(List<Character> characterList) {
        return characterList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * Sorts a List of Characters in descending order. It will get rid of any duplicates and will
     * not return them in the final List.
     *
     * @pre characterList is not null.
     * @post characterList is sorted and not null.
     * @param characterList A list of Character Objects.
     * @return A sorted list of Character Objects with no duplicates.
     */
    public static List<Character> descendingSortNoDuplicates(List<Character> characterList) {
        return characterList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * Prints out every instance of a String element that has a length of > 10.
     *
     * @pre lazyStringList is not null.
     * @post lazyStringList is not null.
     * @param lazyStringList A List of String Objects.
     */
    public static void lazyStream(final List<String> lazyStringList) {
        final int minStringLength = 10;

        lazyStringList.stream()
                .filter(e -> e.length() > minStringLength)
                .peek(System.out::println)
                .count();
    }

    /**
     * Returns a Stream of all Characters contained with a passed in String.
     *
     * @pre input is not null.
     * @post input is not null.
     * @param input The String Object.
     * @return A Stream of Characters containing the characters of the string passed in.
     */
    public static Stream<Character> characterStream(String input) {
        return input.chars()
                .mapToObj(e -> (char) e);
    }

    /**
     * Used to run the program. Test cases are tested here.
     *
     * @pre true.
     * @post true.
     * @param args Not used.
     */
    public static void main(String[] args) {
        ascendingSort(words()).forEach(System.out::println);

        descendingSort(words()).forEach(System.out::println);

        descendingSortNoDuplicates(words()).forEach(System.out::println);

        List<String> stringList = new ArrayList<>();
        stringList.add("Not 10");
        stringList.add("Is over length 10, definitely.");
        stringList.add("Also over length 10");

        lazyStream(stringList);

        String string = "New string";

        characterStream(string).forEach(System.out::println);
    }
}
