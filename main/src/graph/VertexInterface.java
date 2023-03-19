package graph;

import java.util.ArrayList;

public interface VertexInterface<T> {

    public T getData();

    public void visit();

    public void unvisit();

    public boolean isVisited();

    public VertexInterface<T> getUnvisitedNeighbor();


    public boolean hasUnvisitedNeighbor();

    public void printNeighbors();

    public void addNeighborDirected(VertexInterface neighbor);

    public void addNeighborDirected(VertexInterface neighbor,int weight);

    public void addNeighbor(VertexInterface neighbor);
    public ArrayList<VertexInterface> getNeighbors();

    public int getCostTo(VertexInterface neighbor);

}
