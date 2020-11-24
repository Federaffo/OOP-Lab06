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

    private static final int TO_MS = 1_000_000;
    private static final int ELEMS = 100_000;
    private static final int READS = 10_000;
    private static final String NS = "ns (";
    private static final String MS = "ms).";

    private static final long AFRICA_POPULATION = 1_110_635_000L;
    private static final long AMERICAS_POPULATION = 972_005_000L;
    private static final long ANTARCTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final long EUROPE_POPULATION = 742_452_000L;
    private static final long OCEANIA_POPULATION = 38_304_000L;

    private UseCollection() {
    }

    /**
     * @param s unused
     */
    public static void main(final String... s) {

        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers from
         * 1000 (included) to 2000 (excluded).
         */

        List<Integer> myList = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            myList.add(i);
        }
        System.out.println(myList);

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code without
         * using any looping construct (for, while), populate it with the same contents
         * of the list of point 1.
         */

        List<Integer> myList2 = new LinkedList<>();
        myList2.addAll(myList);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last element
         * of the first list. You can not use any "magic number". (Suggestion: use a
         * temporary variable)
         */

        final int el = myList.get(myList.size() - 1);
        myList.set(myList.size() - 1, myList.get(0));
        myList.set(0, el);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for (int x : myList2) {
            System.out.println(x);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of the
         * collection: measure the time required to add 100.000 elements as first
         * element of the collection for both ArrayList and LinkedList, using the
         * previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long time = System.nanoTime();

        for (int i = 1; i <= ELEMS; i++) {
            myList.add(0, i);
        }

        time = System.nanoTime() - time;
        System.out.println("Aggiungo " + ELEMS + " elements. Tempo impiegato: " + time + NS + time / TO_MS + MS);
        /*
         * System.out.println("Converting " + ELEMS +
         * " int to String and inserting them in a Set took " + time + "ns (" + time /
         * ELEMS + "ms)");
         */

        time = System.nanoTime();

        for (int i = 1; i <= ELEMS; i++) {
            myList2.add(i);
        }

        time = System.nanoTime() - time;
        System.out.println("Aggiungo " + ELEMS + " elements. Tempo impiegato: " + time + NS + time / TO_MS + MS);

        /*
         * System.out.println("Converting " + ELEMS +
         * " int to String and inserting them in a Set took " + time + "ns (" + time /
         * ELEMS + "ms)");
         */

        /*
         * 6) Measure the performance of reading 1000 times an element whose position is
         * in the middle of the collection for both ArrayList and LinkedList, using the
         * collections of point 5. In order to measure times, use as example
         * TestPerformance.java.
         */

        final int POS = 50_000;
        time = System.nanoTime();

        for (int i = 1; i <= READS; i++) {
            myList.get(myList.size() / 2);
        }

        time = System.nanoTime() - time;
        System.out.println("Leggo " + READS + " elements. Tempo impiegato: " + time + NS + time / TO_MS + MS);

        time = System.nanoTime();
        for (int i = 1; i <= READS; i++) {
            myList2.get(myList2.size() / 2);
        }

        time = System.nanoTime() - time;
        System.out.println("Leggo " + READS + " elements. Tempo impiegato: " + time + NS + time / TO_MS + MS);

        /*
         * 7) Build a new Map that associates to each continent's name its population:
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

        Map<String, Long> worldMap = new TreeMap<>();

        worldMap.put("africa", AFRICA_POPULATION);
        worldMap.put("america", AMERICAS_POPULATION);
        worldMap.put("Antarctica", ANTARCTICA_POPULATION);
        worldMap.put("Asia", ASIA_POPULATION);
        worldMap.put("Europe", EUROPE_POPULATION);
        worldMap.put("Oceania", OCEANIA_POPULATION);

        /*
         * 8) Compute the population of the world
         */
        long LONGpopulation = 0;
        for (long x : worldMap.values()) {
            LONGpopulation += x;
        }

        System.out.println(LONGpopulation);

    }
}
