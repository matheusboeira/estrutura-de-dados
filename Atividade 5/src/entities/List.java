package entities;

public interface List<T> {
    public void addFirst(T element);
    public void addLast(T element);
    public boolean isEmpty();
    public boolean remove(T element);
    public int size();
}
