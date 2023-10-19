package example;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class Data {
    /**
     * Generate random integer array for test.
     *
     * @param min number that is possible
     * @param max maximal possible number.
     * @param arrayLength elements for array.
     * @return random generated array.
     */
    public static Integer[] randomIntegerArray(int min,
                               int max,
                               int arrayLength) {
        final Integer[] randomArray = new Integer[arrayLength];

        //Use random multiple times.
        final Random random = ThreadLocalRandom.current();
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextInt(max) + min;
        }

        return randomArray;
    }

}
