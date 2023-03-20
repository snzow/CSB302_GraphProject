package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Graph implements GraphInterface {
    ArrayList<VertexInterface> vertexList;
    public Graph(){
        vertexList = new ArrayList<VertexInterface>();
    }

    @Override
    public boolean addVertex(VertexInterface v) {
        vertexList.add(v);
        if(vertexList.contains(v)){
            return true;
        }
        return false;
    }

    public boolean resetVisitedFlags(){
        for(VertexInterface v : vertexList){
            v.unvisit();
        }
        return true;
    }

    public void printGraph(){
        for(VertexInterface v : vertexList){
            System.out.println("");
            v.printNeighbors();
        }
    }

    public ArrayList<VertexInterface> getVertices(){
        return vertexList;
    }

}
