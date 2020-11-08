package it.unibo.oop.lab06.generics1;

/**
 *
 */
public final class UseGraph {

    private UseGraph() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        final Graph<String> g =  new GraphImpl<>();
        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");
        g.addEdge("a", "b");
        g.addEdge("b", "c");
        g.addEdge("c", "d");
        g.addEdge("d", "e");
        g.addEdge("c", "a");
        g.addEdge("e", "a");
        
        
        g.addNode("z");
        g.addNode("x");
        g.addNode("y");
        g.addNode("o");
        g.addNode("k");
        g.addNode("fail");
        g.addEdge("z", "k");
        g.addEdge("z", "x");

        g.addEdge("k", "fail");
        
        g.addEdge("x", "k");
        g.addEdge("x", "o");
        g.addEdge("x", "fail");
        
        g.addEdge("o", "k");
        g.addEdge("o", "y");



        
        
        /*
         * Should print ["a","b","c","d","e"], in any order
         */
        System.out.println(g.nodeSet());
        /*
         * ["d","a"], in any order
         */
        System.out.println(g.linkedNodes("c"));
        /*
         * Must print either the path b,c,a or b,c,d,e,a
         */
        System.out.println(g.getPath("z", "y"));
    }
}
