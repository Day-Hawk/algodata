package bubble;

import example.Data;

import java.util.Arrays;

public final class BubbleSortDriver {


    public static void main(String[] args) {
        final Integer[] unsortedFirst = Data.randomIntegerArray(5, 100, 10);
        System.out.printf("First%s: DESC \n", Arrays.toString(unsortedFirst));
        final Integer[] sortedFirst =
                new BubbleSort<>(unsortedFirst, (integer, integer2) -> integer < integer2).sort();
        System.out.printf("First sorted: %s. \n", Arrays.toString(sortedFirst));


        final Integer[] unsortedSecond = Data.randomIntegerArray(5, 100, 10);
        System.out.printf("Second%s: ASC \n", Arrays.toString(unsortedSecond));
        final Integer[] sortedSecond =
                new BubbleSort<>(unsortedSecond, (integer, integer2) -> integer > integer2).sort();
        System.out.printf("Second sorted: %s. \n", Arrays.toString(sortedSecond));
    }
}
