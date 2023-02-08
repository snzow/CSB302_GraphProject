package graph;

import java.util.ArrayList;
import java.util.Stack;

public class Vertex<T> implements VertexInterface{
    T data;
    ArrayList<VertexInterface> neighborList;


    boolean visited;

    public Vertex(T data){
        this.data = data;
        this.neighborList = new ArrayList<>();
        this.visited = false;
    }

    public T getData(){
        return data;
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
        for(VertexInterface v : neighborList){
            if(!v.isVisited()){
                return v;
            }
        }
        return null;
    }

    public boolean hasUnvisitedNeighbor(){
        for(VertexInterface v : neighborList){
            if(!visited) {
                return true;
            }
        }
        return false;
    }

}
