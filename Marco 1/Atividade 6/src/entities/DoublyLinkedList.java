package entities;

public class DoublyLinkedList<T> implements List<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Adds an element in the end of the list.
     * 
     * @param element the element to be added
     */
    public void add(T element) {
        addEnd(element);
    }

    /**
     * Adds an element in the start (head) of the list.
     * 
     * @param element the element to be added
     */
    @Override
    public void addStart(T element) {
        Node<T> node = new Node<>(element);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head.setPrevious(node);
            this.head = node;
        }
        size++;
    }

    @Override
    public void addEnd(T element) {
        Node<T> node = new Node<>(element);

        if (this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.setPrevious(this.tail);
            this.tail.setNext(node);
            this.tail = node;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public boolean remove(T element) {
        Node<T> search = head;

        while (search != null && search.getElement() != element) {
            search = search.getNext();
        }
        if (search == null) return false;

        if (search.getPrevious() == null) {
            head = search.getNext();
            head.setPrevious(null);
        } else if (search.getNext() == null) {
            search.getPrevious().setNext(null);
            tail = search.getPrevious();
        } else {
            search.getPrevious().setNext(search.getNext());
            search.getNext().setPrevious(search.getPrevious());
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    public String endToStart() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> node = this.tail;

        while (node != null) {
            builder.append(node.getElement());
            node = node.getPrevious();
            builder.append(node != null ? ", " : "");
        }
        return builder.append("]").toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> node = this.head;

        while (node != null) {
            builder.append(node.getElement());
            node = node.getNext();
            builder.append(node != null ? ", " : "");
        }
        return builder.append("]").toString();
    }
}
