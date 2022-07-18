package entities;

public interface Stack<T> {
    public abstract boolean push(T element);
    public abstract T pop();
    public abstract T top();
    public abstract boolean isEmpty();
    public abstract int size();
}
