package entities;

import java.util.Iterator;

import utils.Node;

public class ListQueue<T> implements Queue<T>, Iterable<T> {
    private Node<T> begin;
    private Node<T> end;
    private int size;

    public ListQueue() {
        this.begin = null;
        this.begin = null;
        size = 0;
    }

    public T getBegin() {
        return begin.getInfo();
    }

    public T getEnd() {
        return end.getInfo();
    }

    @Override
    public boolean add(T element) {
        Node<T> node = new Node<>(element);

        if (isEmpty()) begin = node;
        else end.setNext(node);
        
        end = node;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public boolean add(T... elements) {
        for (T element : elements) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean remove() {
        if (!isEmpty()) {
            if (begin == end) {
                begin = null;
                end = null;
            } else
                begin = begin.getNext();
            
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return begin == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = begin;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = current.getInfo();
                    current = current.getNext();
                    return data;
                }
                return null;
            }
        };
    }

    @Override
    public String toString() {
        var builder = new StringBuilder("[");

        for (Node<T> node = begin; node != null; node = node.getNext()) {
            if (node.getNext() != null) 
                builder.append(node.getInfo()).append(", "); 
            else
                builder.append(node.getInfo()).append("");         
        }
        return builder.append("]").toString();
    }
}
