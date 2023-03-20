package graph;

public interface EdgeInterface {
    public void relax();
    public void unRelax();
    public boolean isRelaxed();
    public VertexInterface getStart();
    public VertexInterface getEnd();
    public String toString();
}
