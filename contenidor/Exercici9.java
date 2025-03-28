package contenidor;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Exercici9 {

    // Method to insert an element in the middle of the list
    public static void insertMiddle(List<Integer> list, String listType) {
        Random rand = new Random();
        int index = list.size() / 2; // Middle index
        int value = rand.nextInt();  // Random integer to insert

        long startTime = System.currentTimeMillis();
        list.add(index, value);  // Insert element at middle index
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken to insert in the middle for " + listType + ": " + (endTime - startTime) + " milliseconds");
    }

    // Method to remove an element from the middle of the list
    public static void removeMiddle(List<Integer> list, String listType) {
        Random rand = new Random();
        int index = list.size() / 2; // Middle index

        long startTime = System.currentTimeMillis();
        list.remove(index);  // Remove element at middle index
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken to remove from the middle for " + listType + ": " + (endTime - startTime) + " milliseconds");
    }

    public static void main(String[] args) {
        // Test for ArrayList
        List<Integer> l1 = new ArrayList<Integer>();
        for (int i = 0; i < 500000; i++) {  // Fill the list with 500,000 elements
            l1.add(i);
        }

        insertMiddle(l1, "ArrayList");  // Test insertion in the middle for ArrayList
        removeMiddle(l1, "ArrayList");  // Test removal from the middle for ArrayList

        // Test for LinkedList
        List<Integer> l2 = new LinkedList<Integer>();
        for (int i = 0; i < 500000; i++) {  // Fill the list with 500,000 elements
            l2.add(i);
        }

        insertMiddle(l2, "LinkedList");  // Test insertion in the middle for LinkedList
        removeMiddle(l2, "LinkedList");  // Test removal from the middle for LinkedList
    }
}
