package entities;

public class LinkedList<T> implements List<T> {
    private int size;
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    @Override
    public void addFirst(T element) {
        Node<T> node = new Node<>(element);

        if (this.head == null) { 
            this.head = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        Node<T> node = new Node<>(element);

        if (this.head == null) { 
            this.head = node;
        } else {
            Node<T> last = null;

            for (Node<T> i = head; i != null; i = i.getNext()) {
                last = i;
            }
            last.setNext(node);
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean remove(T element) {
        Node<T> previous = null, n;
        n = head;

        if (n == null) return false;

        while (n != null && n.getElement() != element) {
            previous = n;
            n = n.getNext();
        }
        if (previous == null) head = n.getNext(); 
        else previous.setNext(n.getNext()); 
         
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
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
