/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-03-04
 * Purpose: Task 5
 */
package task5;

import java.util.*;

public class Main {

    private static final String[] TASK_1_ELE = {"apple", "orange", "banana"};
    private static final Integer[] TASK_2_ELE = {92, 9, 30, 81, 93, 3, 31, 82, 1, 16};
    private static final Character[] TASK_3_ELE = {'A', 'B', 'C', 'D', 'E', 'F'};

    private static final String[] TASK_4_COLOR = {"black", "white", "red", "blue", "green", "yellow", "orange", "purple"};
    private static final Integer[] TASK_4_VALUE = {255, 0, 205, 100, 64, 200, 222, 128};

    public static void main(String[] args) {
        System.out.println("===== Task 1 =====");
        taskOne();
        System.out.println("===== Task 2 =====");
        taskTwo();
        System.out.println("===== Task 3 =====");
        taskThree();
        System.out.println("===== Task 4 =====");
        taskFour();
    }

    /**
     * Task 1
     *      Create an ArrayList of 3 String elements
     *      Ask the user for an element value
     *      Determine if this value is in the ArrayList, Remove if it is
     *      Using 3 iteration structures, display all the elements
     *      (For loop & while loop + iterator() method)
     */
    public static void taskOne() {
        //arraylist collection
        List<String> fruitList = new ArrayList<String>();

        //insert 3 string elements
        for (String ele : TASK_1_ELE) {
            fruitList.add(ele);
        }

        //ask user to enter fruit name
        System.out.print("Enter fruit: ");
        Scanner scan = new Scanner(System.in);
        String fruit = scan.nextLine().strip();
        System.out.println(fruitList);

        //Remove from list, if it exists
        if(fruitList.contains(fruit)) {
            fruitList.remove(fruit);
        } else {
            fruitList.add(fruit);
        }
        System.out.println(fruitList);

        //use for-loop to display all elements
        System.out.println("Fop-loop to display all elements:");
        for(String ele : fruitList) {
            System.out.println(ele);
        }

        //use while + iterator to display all elements
        System.out.println("While-loop & Iterator to display all elements:");
        Iterator<String> iterator = fruitList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Task 2
     *      Create a LinkedList of 10 random Integers
     *      Using the ListIterator, start with index 5 (6th element)
     *      Go forward twice (display the 6th and 7th element
     *      Go backwards 5 times(display 7th-3rd elements)
     *      Sort the LinkedList
     *      Output the min and max values
     *      Shuffle the LinkedList.
     *      Output all the elements of the LinkedList using for loop
     */
    public static void taskTwo() {
        //creat a linked list collection
        List<Integer> numList = new LinkedList<Integer>();

        //insert 10 elements
        for (Integer ele : TASK_2_ELE) {
            numList.add(ele);
        }
        System.out.println(numList);

        //
        System.out.println("Get elements which index from 5 to 6: ");
        ListIterator<Integer> listIterator = numList.listIterator(5);
        for(int i=0; i<2; i++) {
            System.out.println(listIterator.nextIndex() + "\t" + listIterator.next());
        }
        System.out.println("Get elements which index from 6 to 2:");
        for(int i=5; i>0; i--) {
            System.out.println(listIterator.previousIndex() + "\t" + listIterator.previous());
        }

        //sort
        System.out.println("Sort list:");
        Collections.sort(numList);
        System.out.println(numList);

        //max and min value
        System.out.println("Max: " + Collections.max(numList));
        System.out.println("Min: " + Collections.min(numList));

        //shuffle
        System.out.println("Shuffle list:");
        Collections.shuffle(numList);
        System.out.println(numList);

        //use for-loop to display all elements
        System.out.println("Fop-loop to display all elements");
        for (int i=0; i<numList.size(); i++) {
            System.out.println(numList.get(i));
        }
    }

    /**
     * Task3
     *      Create a TreeSet of Characters
     *      add 6 Strings (A-F)
     *
     *      get all characters that come before the letter C
     *      will return SortedSet
     *      get all characters that come after letter B
     *      will return SortedSet
     *
     *      using enhanced for loop, output all the characters for both SortedSets
     *
     *      Collection
     *          - Set
     *              -SortedSet
     *                  -NavigableSet
     *                      -TreeSet
     */
    public static void taskThree() {
        //create a tree set collection
        TreeSet<Character> charTreeSet = new TreeSet<Character>();

        //add 6 characters
        for (Character ele : TASK_3_ELE) {
            charTreeSet.add(ele);
        }

        System.out.println("Get all characters that come before the letter C");
        SortedSet<Character> setFromC = (SortedSet<Character>)charTreeSet.headSet('C');
        for(Character c: setFromC) {
            System.out.println(c);
        }

        System.out.println("Get all characters that come after letter B");
        SortedSet<Character> setFromB = (SortedSet<Character>)charTreeSet.tailSet('B');
        for(Character c: setFromB) {
            System.out.println(c);
        }

    }

    /**
     * Task 4
     *      Create a Map that stores a user's fav colors
     *      The map should be integer and string
     *      Ask the user 3 times for their top 3 colors
     *      Output the map values to the screens
     */
    public static void taskFour() {
        Map<String, Integer> favColorMap = new HashMap<String, Integer>();

        Scanner scan = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);

        for(int i=0; i<TASK_4_VALUE.length; i++) {
            favColorMap.put(TASK_4_COLOR[i], TASK_4_VALUE[i]);
        }

        for(int i=0; i<3; i++) {
            System.out.print("Enter your favourite color: ");
            String color = scan.nextLine();
            System.out.println(favColorMap.get(color.toLowerCase()));
        }
    }
}
