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


        System.out.println("---DAG Shortest Paths---");
        System.out.println("-Graph-");
        g.printGraph();
        System.out.println("-Algo-");
        Algorithms.dagSPA(g,v1);

        GraphInterface g2 = new Graph();

        v1 = new Vertex("A", 4);
        v2 = new Vertex("B", 46);
        v3 = new Vertex("C", 47);
        v4 = new Vertex("D", 1);
        v5 = new Vertex("E", 2);
        v6 = new Vertex("F", 3);

        v1.addNeighborDirected(v2,generateRandomNumber(1,10)-5);
        v1.addNeighborDirected(v6,generateRandomNumber(1,10)-5);
        v2.addNeighborDirected(v3,generateRandomNumber(1,10)-5);
        v2.addNeighborDirected(v6,generateRandomNumber(1,10)-5);
        v3.addNeighborDirected(v5,generateRandomNumber(1,10)-5);
        v3.addNeighborDirected(v4,generateRandomNumber(1,10)-5);
        v4.addNeighborDirected(v5,generateRandomNumber(1,10)-5);
        v4.addNeighborDirected(v6,generateRandomNumber(1,10)-5);
        v5.addNeighborDirected(v6,generateRandomNumber(1,10)-5);

        g2.addVertex(v1);
        g2.addVertex(v2);
        g2.addVertex(v3);
        g2.addVertex(v4);
        g2.addVertex(v5);
        g2.addVertex(v6);

        System.out.println("---Bellman Ford---");
        System.out.println("-Graph-");
        g2.printGraph();
        System.out.println("-Algo-");
        Algorithms.bellmanFord(g2,v1);

        /*
        v1.addNeighborUndirected(v2,generateRandomNumber(1,10));
        v2.addNeighborUndirected(v3,generateRandomNumber(1,10));
        v2.addNeighborUndirected(v6,generateRandomNumber(1,10));
        v3.addNeighborUndirected(v4,generateRandomNumber(1,10));
        v4.addNeighborUndirected(v5,generateRandomNumber(1,10));
        v4.addNeighborUndirected(v6,generateRandomNumber(1,10));
        v5.addNeighborUndirected(v6,generateRandomNumber(1,10));

        g2.addVertex(v1);
        g2.addVertex(v2);
        g2.addVertex(v3);
        g2.addVertex(v4);
        g2.addVertex(v5);
        g2.addVertex(v6);

        System.out.println("---Dijkstras---");
        System.out.println("-Graph-");
        g2.printGraph();
        System.out.println("-Algo-");
        Algorithms.dijkstra(g2,v1);

        */
    }
    public static int generateRandomNumber(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
}