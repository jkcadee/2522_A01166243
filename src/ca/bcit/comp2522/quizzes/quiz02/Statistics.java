package ca.bcit.comp2522.quizzes.quiz02;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {
    public static int median(ArrayList<Integer> args) {
        ArrayList<Integer> medianList = new ArrayList<>(args);
        Collections.sort(medianList);
        int totalNumber = medianList.size();
        if (totalNumber % 2 == 0) {
            int middleValue = totalNumber / 2;
            int otherMiddleValue = totalNumber / 2 + 1;

            return (medianList.get(middleValue) + medianList.get(otherMiddleValue)) / 2;

        } else {
            int middleValue = totalNumber / 2 + 1;
            return medianList.get(middleValue);
        }
    }
    public static void main(String... args) throws NegativeIntegerException {
        ArrayList<Integer> commandLineArguments = new ArrayList<>();
        for (String a : args) {
            if (Integer.parseInt(a) < 0) {
                throw new NegativeIntegerException("Invalid value");
            }
            commandLineArguments.add(Integer.getInteger(a));
        }
        int median = Statistics.median(commandLineArguments);
        System.out.println(median);
    }
}
