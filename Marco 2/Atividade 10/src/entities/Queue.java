package entities;

public interface Queue<T> {
    public boolean add(T element) throws QueueException;
    public boolean remove() throws QueueException;
    public boolean isFull();
    public boolean isEmpty();
    public int size();
}
