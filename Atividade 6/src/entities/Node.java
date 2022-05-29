package entities;

/**
 * Class that represents an array to store objects.
 * 
 * @author Matheus Boeira Dias
 */
public class Node<T> {
    private T element;
    private Node<T> previous;
    private Node<T> next;

    public Node(T element) {
        this.element = element;
        this.previous = null;
        this.next = null;
    }

    public Node(T element, Node<T> previous, Node<T> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
