package graph;

import java.util.ArrayList;

public class Vertex<T> implements VertexInterface{
    T data;
    ArrayList<Vertex> edgeList;

    boolean visited;

    public Vertex(T data){
        this.data = data;
        this.edgeList = new ArrayList<>();
        this.visited = false;
    }

    public boolean isVisited(){
        if(visited){
            return true;
        }
        return false;
    }

    public boolean hasUnvisitedNeighbor(){
        for(Vertex v : edgeList){
            if(!visited) {
                return true;
            }
        }
        return false;
    }
}
