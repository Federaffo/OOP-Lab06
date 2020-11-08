package it.unibo.oop.lab.collections1;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {


	private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	List<Integer> myList = new ArrayList<>();
    	for(int i = 1000; i < 2000; i++) {
    		myList.add(i);
    	}
    	System.out.println(myList);
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	List<Integer> myList2 = new LinkedList<>();
    	myList2.addAll(myList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	

    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for (int x : myList2) {
			System.out.println(x);
		}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	final int ELEMS = 100_000;
    	long time = System.nanoTime();

    	for (int i = 1; i <= ELEMS; i++) {
            myList.add(i);
        }

        time = System.nanoTime() - time;
        /*
        System.out.println("Converting " + ELEMS
                + " int to String and inserting them in a Set took " + time
                + "ns (" + time / ELEMS + "ms)");
    	*/
        
        
        
    	time = System.nanoTime();

    	for (int i = 1; i <= ELEMS; i++) {
            myList2.add(i);
        }

        time = System.nanoTime() - time;
        
        /*
        System.out.println("Converting " + ELEMS
                + " int to String and inserting them in a Set took " + time
                + "ns (" + time / ELEMS + "ms)");
        */
        
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        
        final int POS = 50_000;
        time = System.nanoTime();

    	for (int i = 1; i <= 1000; i++) {
            myList.get(POS);
        }

        time = System.nanoTime() - time;
        System.out.println("Converting " + ELEMS
                + " int to String and inserting them in a Set took " + time
                + "ns (" + time / ELEMS + "ms)");
        
        

        time = System.nanoTime();

    	for (int i = 1; i <= 1000; i++) {
            myList2.get(POS);
        }

        time = System.nanoTime() - time;
        System.out.println("Converting " + ELEMS
                + " int to String and inserting them in a Set took " + time
                + "ns (" + time / ELEMS + "ms)");
        
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        
        
        Map<String, Integer> worldMap = new TreeMap();
        
        //worldMap.put("africa", 5110635000L);
        worldMap.put("america", 1110635000);
        worldMap.put("euerfed", 1110635000);
        worldMap.put("aferrica", 1110635000);
        worldMap.put("affrica", 1110635000);

        
        /*
         * 8) Compute the population of the world
         */
        long LONGpopulation = 0;
        LONGpopulation += worldMap.get("africa");

        System.out.println(LONGpopulation);
        
        
    }
}
