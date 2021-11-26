/*
* This is a program that calculates the mean and median
* after reading in a text file into an array.
*
* @author  Matthew Sanii
* @version 1.0
* @since   2021-25-11
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
* This is the statistics program.
*/
final class Statistics {

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Statistics() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The mean() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @param totalNumbers the size of the array of numbers
    * @return the mean of the integers
    */
    public static double mean(final Integer[] arrayOfIntegers, final int totalNumbers) {
        final double mean;
        final Integer[] list = arrayOfIntegers;
        int sum;
        int spot;
        sum = 0;
        for (spot = 0; spot < totalNumbers; spot++) {
            sum += list[spot];
        }
        mean = sum / totalNumbers;
        return mean;
    }

    /**
    * The median() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @param totalNumbers the size of the array of numbers
    * @return the median of the integers
    */
    public static double median(final Integer[] arrayOfIntegers, final int totalNumbers) {
        final Integer[] array = arrayOfIntegers;
        final double amount;
        Arrays.sort(array);
        if (totalNumbers % 2 == 0) {
            amount = ((double) array[totalNumbers / 2] + (double) array[totalNumbers / 2 - 1]) / 2;
        } else {
            amount = (double) array[totalNumbers / 2];
        }
        return amount;
    }

    /**
    * The starting main() function.
    *
    * @param args Name of file containing a string of numbers
    */
    public static void main(final String[] args) {
        int tempNumber;
        int total;
        total = 0;
        final ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        final Charset charset = Charset.forName("UTF-8");

        if (!Files.exists(Paths.get(args[0]))) {
            System.err.println("Exiting as file does not exist: " + args[0]);
        }

        final Path filePath = Paths.get(args[0]);
        try (BufferedReader reader = Files.newBufferedReader(
                                     filePath, charset)) {
            String line = "hi";
            while ((line = reader.readLine()) != null) {
                try {
                    tempNumber = Integer.parseInt(line);
                    listOfNumbers.add(tempNumber);
                    total += 1;
                } catch (ArrayIndexOutOfBoundsException errorCode) {
                    line = null;
                }
            }
        } catch (IOException errorCode) {
            System.err.println(errorCode);
        }

        final Integer[] arrayOfNumbers = listOfNumbers.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arrayOfNumbers));

        System.out.println("\nCalculating mean and median...");
        final double mean = mean(arrayOfNumbers, total);
        final double median = median(arrayOfNumbers, total);

        System.out.println("The mean is: " + mean);
        System.out.println("The median is: " + median);
        System.out.println("\nDone.");
    }
}
