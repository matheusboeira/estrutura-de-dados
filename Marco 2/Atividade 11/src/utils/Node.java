package utils;

public class Node<T> {
    private T info;
    private Node<T> next;

    public Node(T info) {
        this.info = info;
        this.next = null;
    }

    /**
     * Get the info of the node.
     * @return the information inside the node
     */
    public T getInfo() {
        return info;
    }

    /**
     * Get the next node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Set the "pointer" to the next node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
