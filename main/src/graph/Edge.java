package graph;

public class Edge implements EdgeInterface{
    VertexInterface vertexOne;
    VertexInterface vertexTwo;

    public Edge(VertexInterface vertexOne, VertexInterface vertexTwo){
        this.vertexOne = vertexOne;
        this.vertexTwo = vertexTwo;
        vertexOne.addNeighbor(vertexTwo);
        vertexTwo.addNeighbor(vertexOne);
    }
}
