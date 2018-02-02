package dong.suanfa;

import java.util.Iterator;

/**
 * @author Created by xzd on 2018/1/26.
 * @Description
 */
public interface VertexInterface<T> {
    public T getLabel();

    public void visit();

    public void unVisit();

    public boolean isVisited();

    public boolean connect(VertexInterface<T> endVertex, double edgeWeight);

    public boolean connect(VertexInterface<T> endVertex);

    public Iterator<VertexInterface<T>> getNeighborInterator();

    public Iterator getWeightIterator();

    public boolean hasNeighbor();

    public VertexInterface<T> getUnvisitedNeighbor();

    public void setPredecessor(VertexInterface<T> predecessor);

    public VertexInterface<T> getPredecessor();

    public boolean hasPredecessor();

    public void setCost(double newCost);

    public double getCost();
}
