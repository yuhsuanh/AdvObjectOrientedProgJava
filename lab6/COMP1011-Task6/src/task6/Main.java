/**
 * Author: Yu-Hsuan Huang
 * Date: 2021/03/29
 * Purpose: Learning Stream
 *
 */
package task6;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Task1();
        Task2();
        Task3();
    }

    /**
     * Task 1
     * Use the LongStream
     * Create a stream of longs from 1 to 100
     * Find the min, max, sum and average of this stream.
     */
    public static void Task1() {
        //Another way to create stream with long type
        /*
            ArrayList<Long> longList = new ArrayList<Long>();
            for (long i=0; i<100; i++) {
                longList.add(i);
            }
            Stream<Long> longStream = longList.stream();
        */

        //Use Long Stream
        //Stream only can been use once
        //Java stream has already been operated upon or closed use next supplier
        /*
            LongStream longStream = LongStream.range(1L, 101L);
            System.out.println(longStream.min().getAsLong());
            System.out.println(longStream.max().getAsLong());
            System.out.println(longStream.sum());
            System.out.println(longStream.average().orElse(0));
         */


        Supplier<LongStream> longStreamSupplier = () -> LongStream.rangeClosed(1L, 100L);

        System.out.printf("Min value in Stream: ");
        System.out.println(longStreamSupplier.get().min().getAsLong());
        System.out.printf("Max value in Stream: ");
        System.out.println(longStreamSupplier.get().max().getAsLong());
        System.out.printf("Sum value in Stream: ");
        System.out.println(longStreamSupplier.get().sum());
        System.out.printf("Average value in Stream: ");
        System.out.println(longStreamSupplier.get().average().orElse(0));
    }

    /**
     * Task 2
     * Create a list of Strings
     * Output all of the strings in their uppercase format
     */
    public static void Task2() {
        List<String> nameList = Arrays.asList("sean", "joseph", "winnie", "lucas", "jasmine", "olive");

        nameList.stream().map(name -> name.toUpperCase()).sorted().forEach(System.out::println);
    }

    /**
     * Task 3
     * Create 5 random numbers between 1 and 25
     * Output the max value
     */
    public static void Task3() {
        SecureRandom secureRandom = new SecureRandom();
        IntStream intStream = secureRandom.ints(5, 1, 26);

        System.out.println("Max value in Stream(Randomly Created): ");
        System.out.println(intStream.max().getAsInt());
    }
}
