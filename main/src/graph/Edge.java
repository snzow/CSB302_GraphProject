package graph;

public class Edge implements EdgeInterface{
    VertexInterface start;
    VertexInterface end;

    int weight;

    public Edge(VertexInterface start, VertexInterface end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
        start.addNeighbor(end);

    }
    public Edge(VertexInterface start, VertexInterface end){
        this.start = start;
        this.end = end;
        this.weight = 0;
        start.addNeighbor(end);


    }
}
