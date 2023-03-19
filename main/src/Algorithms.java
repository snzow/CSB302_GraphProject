import graph.Graph;
import graph.GraphInterface;
import graph.Vertex;
import graph.VertexInterface;

import java.util.*;

public class Algorithms {

    public static void bellmanFord(GraphInterface g, VertexInterface start) {

    }

    public static void floydWarshall(GraphInterface g, VertexInterface start) {

    }

    public static void dagSPA(GraphInterface g, VertexInterface start) {
        Queue<VertexInterface> q = topologicalSort(g,start);
        List<VertexInterface> vertexList = g.getVertices();
        Map<VertexInterface,Integer> costMap = new HashMap<>();
        for(int i = 0; i < vertexList.size(); i++){
            costMap.put(vertexList.get(i),1_000_000);
        }
        costMap.put(start,0);
        for(int i = 0; i < vertexList.size() - 1; i++){
            VertexInterface cur = q.remove();
            List<VertexInterface> neighborList = cur.getNeighbors();
            for(int j = 0; j< neighborList.size();j++){
                VertexInterface neighbor = neighborList.get(j);
                int eval = costMap.get(cur) + cur.getCostTo(neighbor);
                if( eval < costMap.get(neighbor)){
                    costMap.put(neighbor,eval);
                }
            }
        }
        for(int i = 0; i < vertexList.size(); i++){
            VertexInterface v = vertexList.get(i);
            System.out.println("Vertex: " + v.toString() + " Distance: " + costMap.get(v));
        }
    }

    public static Queue<VertexInterface> topologicalSort(GraphInterface g, VertexInterface start) {
        Stack<VertexInterface> vertexStack = new Stack<>();
        Queue<VertexInterface> toReturn = new LinkedList<>();
        g.resetVisitedFlags();
        topoRecur(start, vertexStack);
        while (vertexStack.empty() == false) {
            toReturn.add(vertexStack.pop());
        }

        return toReturn;
    }

    private static void topoRecur(VertexInterface v, Stack<VertexInterface> vertexStack) {
        v.visit();
        ArrayList<VertexInterface> neighborList = v.getNeighbors();
        for (int i = 0; i < neighborList.size(); i++){
            VertexInterface cur = neighborList.get(i);
            if(!cur.isVisited()){
                topoRecur(cur, vertexStack);
            }

        }
        vertexStack.push(v);
    }
}
