package graph;

import java.util.*;

public class Vertex<T> implements VertexInterface{
    int data;
    String label;
    ArrayList<VertexInterface> neighborList;
    Map<VertexInterface,Integer> edgeMap;
    ArrayList<EdgeInterface> edgeList;


    boolean visited;

    public Vertex(String label, int data){
        this.data = data;
        this.label = label;
        this.neighborList = new ArrayList<>();
        this.edgeList = new ArrayList<>();
        this.edgeMap = new HashMap<>();
        this.visited = false;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public void visit(){
        visited = true;
    }

    public void unvisit(){
        visited = false;
    }
    public boolean isVisited(){
        if(visited){
            return true;
        }
        return false;
    }

    @Override
    public VertexInterface getUnvisitedNeighbor() {
        for(int i = 0; i < neighborList.size(); i++){
            VertexInterface cur = neighborList.get(i);
            System.out.println("Checking if " + cur.toString() + " is visited");
            if(!cur.isVisited()){
                return cur;
            }
        }
        return null;
    }

    public boolean hasUnvisitedNeighbor(){
        if(neighborList.size() == 0){
            return false;
        }
        for(VertexInterface v : neighborList){
            if(v.isVisited()) {
                return false;
            }
        }
        return true;
    }

    public void addNeighborDirected (VertexInterface neighbor){
        EdgeInterface newEdge = new DirectedEdge(this,neighbor);
        edgeMap.put(neighbor,0);

    }

    public void addNeighbor(VertexInterface neighbor){
        neighborList.add(neighbor);
    }

    public void addNeighborDirected (VertexInterface neighbor,int weight){
        EdgeInterface newEdge = new DirectedEdge(this,neighbor,weight);
        edgeMap.put(neighbor,weight);
        edgeList.add(newEdge);

    }

    public void addNeighborUndirected(VertexInterface neighbor, int weight){
        EdgeInterface newEdge = new UndirectedEdge(this, neighbor, weight);
        edgeMap.put(neighbor, weight);
        edgeList.add(newEdge);
    }

    public List<EdgeInterface> getEdgeList(){
        return edgeList;
    }

    public void printNeighbors(){
        System.out.print("Vertex: " + this.toString() + " | ");
        for(VertexInterface v : neighborList){

            if(neighborList.indexOf(v) < neighborList.size() -1){
                System.out.print("(" + v + "," + this.getCostTo(v) + ")");
                System.out.print(", ");
            }
            else{
                System.out.print("(" + v + "," + this.getCostTo(v) + ")");
            }
        }
        if(neighborList.size() == 0){
            System.out.println("");
        }

    }
    public ArrayList<VertexInterface> getNeighbors(){
        return neighborList;
    }

    public String toString(){
        return this.label;
    }

    public int getCostTo(VertexInterface v){
        int cost = edgeMap.get(v);
        return cost;
    }



}
