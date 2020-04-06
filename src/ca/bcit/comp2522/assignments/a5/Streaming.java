package ca.bcit.comp2522.assignments.a5;

import java.util.*;
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
 */
public class Streaming {
    public static List<Character> words() {
        Random random = new Random();
        List<Character> characterList = new ArrayList<>();

        final int numberOfCharacters = 30;

        for (int index = 0; index < numberOfCharacters; index++) {
            characterList.add((char) (97 + random.nextInt(26)));
        }

        return characterList;
    }

    public static List<Character> ascendingSort(List<Character> characterList) {
        return characterList.stream()
                .sorted(Character::compareTo)
                .collect(Collectors.toList());
    }

    public static List<Character> descendingOrder(List<Character> characterList) {
        return characterList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<Character> descendingOrderNoDuplicates(List<Character> characterList) {
        return characterList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static void lazyStream(List<String> lazyStringList) {
        lazyStringList.stream()
                .filter(e -> e.length() > 10)
                .forEach(System.out::println);
    }

    public static Stream<Character> characterStream(String input) {
        return input.chars()
                .mapToObj(e -> (char) e);
    }

    public static void main(String[] args) {
        String string = "New string";

        characterStream(string).forEach(System.out::println);
    }
}
