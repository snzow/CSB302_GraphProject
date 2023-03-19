package graph;

import java.util.ArrayList;

public interface GraphInterface {

    public boolean addVertex(VertexInterface v);

    public boolean resetVisitedFlags();

    public void printGraph();

    public ArrayList<VertexInterface> getVertices();
}
