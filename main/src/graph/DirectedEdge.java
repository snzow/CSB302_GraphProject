package graph;

public class DirectedEdge implements EdgeInterface{
    VertexInterface start;
    VertexInterface end;

    boolean relaxed;

    int weight;

    public DirectedEdge(VertexInterface start, VertexInterface end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
        start.addNeighbor(end);
        relaxed = false;

    }
    public DirectedEdge(VertexInterface start, VertexInterface end){
        this.start = start;
        this.end = end;
        this.weight = 0;
        start.addNeighbor(end);
        relaxed = false;


    }

    public void relax(){
        relaxed = true;
    }

    public boolean isRelaxed(){
        return relaxed;
    }

    public void unRelax(){
        relaxed = false;
    }

    public VertexInterface getStart(){
        return start;
    }

    public VertexInterface getEnd(){
        return end;
    }
}
