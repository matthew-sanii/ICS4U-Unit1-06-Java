/*
* This is a program that calculates the mean and median
* after reading in a text file into an array.
*
* @author  Matthew Sanii
* @version 1.0
* @since   2021-25-11
*/

import java.lang.Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    * @return the mean of the integers
    */
    public static double mean(final Integer[] arrayOfIntegers, final int totalNumbers) {
        double mean;
        Integer[] list = arrayOfIntegers;
        int sum, i;
        int max = totalNumbers;
        sum = 0;
        for(i = 0; i < totalNumbers; i++) {
            sum+=list[i];
    }
        mean = sum/max;
        return mean;
    }

    /**
    * The median() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @return the median of the integers
    */
    public static double median(final Integer[] arrayOfIntegers, final int totalNumbers) {
        Integer[] array = arrayOfIntegers;
        double amount;
        Arrays.sort(array);
        amount = array[totalNumbers/2];
        return amount;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        int tempNumber;
        int total;
        total = 0;
        final ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        final Path filePath = Paths.get("../", args[0]);
        final Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(
                                     filePath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                tempNumber = Integer.parseInt(line);
                listOfNumbers.add(tempNumber);
                total += 1;
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
