package graph;

public class UndirectedEdge implements EdgeInterface {
    VertexInterface one;
    VertexInterface two;

    boolean relaxed;

    int weight;

    public UndirectedEdge(VertexInterface start, VertexInterface end, int weight){
        this.one= start;
        this.two = end;
        this.weight = weight;
        start.addNeighbor(end);
        end.addNeighbor(start);
        relaxed = false;

    }
    public UndirectedEdge(VertexInterface start, VertexInterface end){
        this.one = start;
        this.two  = end;
        this.weight = 0;
        start.addNeighbor(end);
        end.addNeighbor(start);
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
        return one;
    }

    public VertexInterface getEnd(){
        return two;
    }
    public String toString(){
        return one + " - " + two;
    }
}
