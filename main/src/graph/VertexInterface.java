package graph;

public interface VertexInterface<T> {

    public T getData();

    public void visit();

    public void unvisit();

    public boolean isVisited();

    public VertexInterface<T> getUnvisitedNeighbor();


    public boolean hasUnvisitedNeighbor();
}
