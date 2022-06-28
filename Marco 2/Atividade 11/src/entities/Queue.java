package entities;

public interface Queue<T> {
    public boolean add(T element);
    public boolean remove();
    public boolean isEmpty();
    public int size();
}
