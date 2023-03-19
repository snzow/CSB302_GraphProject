import graph.Graph;
import graph.GraphInterface;
import graph.Vertex;
import graph.VertexInterface;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        GraphInterface g = new Graph();
        VertexInterface v1 = new Vertex("A", 4);
        VertexInterface v2 = new Vertex("B", 46);
        VertexInterface v3 = new Vertex("C", 47);
        VertexInterface v4 = new Vertex("D", 1);
        VertexInterface v5 = new Vertex("E", 2);
        VertexInterface v6 = new Vertex("F", 3);

        v1.addNeighborDirected(v2,generateRandomNumber(1,10));
        v1.addNeighborDirected(v6,generateRandomNumber(1,10));
        v2.addNeighborDirected(v3,generateRandomNumber(1,10));
        v2.addNeighborDirected(v6,generateRandomNumber(1,10));
        v3.addNeighborDirected(v5,generateRandomNumber(1,10));
        v3.addNeighborDirected(v4,generateRandomNumber(1,10));
        v4.addNeighborDirected(v5,generateRandomNumber(1,10));
        v4.addNeighborDirected(v6,generateRandomNumber(1,10));
        v5.addNeighborDirected(v6,generateRandomNumber(1,10));

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);

        System.out.println("---graph---");
        g.printGraph();
        System.out.println("---DAG Shortest Paths---");
        Algorithms.dagSPA(g,v1);

    }
    public static int generateRandomNumber(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
}