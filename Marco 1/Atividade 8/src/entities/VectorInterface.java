package entities;

public interface VectorInterface<T> {
    public boolean add(T element);
    public int size();
    public boolean contains(T element);
    public boolean isFull();
    public boolean remove(T element);
}
