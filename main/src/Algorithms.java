import graph.*;

import java.util.*;

public class Algorithms {

    public static void bellmanFord(GraphInterface g, VertexInterface start) {

        List<VertexInterface> vertexList = g.getVertices();
        Map<VertexInterface,Integer> costMap = new HashMap<>();
        for(int i = 0; i < vertexList.size(); i++){
            costMap.put(vertexList.get(i),1_000_000);
        }
        costMap.put(start,0);
        List<EdgeInterface> fullEdgeList = new ArrayList<>();
        for(int i = 0; i < vertexList.size(); i++){
            VertexInterface cur = vertexList.get(i);
            List<EdgeInterface> edgeList = cur.getEdgeList();
            for(int j = 0; j < edgeList.size(); j++){
                EdgeInterface edge = edgeList.get(j);
                edge.relax();
                if(fullEdgeList.contains(edge) == false){
                    fullEdgeList.add(edge);
                }
                int eval = costMap.get(cur) + cur.getCostTo(edge.getEnd());
                if(eval < costMap.get(edge.getEnd())){
                    costMap.put(edge.getEnd(),eval);
                }
            }
        }
        boolean cycle = false;
        for(int i = 0; i < fullEdgeList.size(); i++){
            if(!fullEdgeList.get(i).isRelaxed()){
                System.out.println("There is a negative weight cycle");
                cycle = true;
            }
        }
        if(cycle == false){
            for(int i = 0; i < vertexList.size(); i++){
                VertexInterface v = vertexList.get(i);
                System.out.println("Vertex: " + v.toString() + " Distance: " + costMap.get(v));
            }
        }

    }

    public static void dijkstra(GraphInterface g, VertexInterface start) {
        List<VertexInterface> vertexList = g.getVertices();
        Queue<VertexInterface> pq = new PriorityQueue<>(Comparator.comparing(VertexInterface::getData));
        Map<VertexInterface,Integer> costMap = new HashMap<>();
        for(int i = 0; i < vertexList.size(); i++){
            costMap.put(vertexList.get(i),1_000_000);
            vertexList.get(i).setData(1_000_000);
            pq.add(vertexList.get(i));
        }
        costMap.put(start,0);
        start.setData(0);
        List<EdgeInterface> relaxedEdgeList = new ArrayList<>();
        while(!pq.isEmpty()){
            VertexInterface cur = pq.remove();
            System.out.println(cur.getData());
            List<EdgeInterface> edgeList = cur.getEdgeList();
            for(int i = 0; i < cur.getEdgeList().size(); i++){
                EdgeInterface edge = edgeList.get(i);
                VertexInterface neighbor;
                if(edge.getEnd().equals(cur)){
                    neighbor = edge.getStart();
                }
                else{
                    neighbor = edge.getEnd();
                }
                if(pq.contains(neighbor)){
                    edge.relax();
                    relaxedEdgeList.add(edge);
                    if(cur.getData() + cur.getCostTo(neighbor) < neighbor.getData()){
                        neighbor.setData(cur.getData() + cur.getCostTo(neighbor));
                    }
                }
            }

        }
        for(int i = 0; i < vertexList.size(); i++){
            VertexInterface v = vertexList.get(i);
            System.out.println("Vertex: " + v.toString() + " Distance: " + v.getData());
        }
        System.out.println("-Relaxed Edges-");
        for(int i = 0; i < relaxedEdgeList.size(); i++){
            EdgeInterface e = relaxedEdgeList.get(i);
            System.out.println(e.toString());
        }
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
