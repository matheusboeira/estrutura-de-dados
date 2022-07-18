package entities;

import utils.App;
import utils.Node;
import utils.enums.Color;

public class ListStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    public ListStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean push(T element) {
        var newNode = new Node<T>(element);

        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public boolean push(T... elements) {
        for (T element : elements) {
            push(element);
        }
        return true;
    }

    @Override
    public T pop() {
        T element = null;

        if (!isEmpty()) {
            element = top.getInfo();
            top = top.getNext();
            size--;
        }
        return element;
    }

    @Override
    public T top() {
        return top.getInfo();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }

    public void reverse() {
        var queue = new ListQueue<T>();
        
        while (!isEmpty()) {
            queue.add(pop());
        }

        while (!queue.isEmpty()) {
            push(queue.getBegin());
            queue.remove();
        }
    }

    public void printReverse() {
        var queue = new ListQueue<T>();
        
        App.printf(Color.PURPLE, "\n[ADICIONANDO À FILA USANDO A PILHA]\n\n");

        while (!isEmpty()) {
            queue.add(pop());
            App.printf(Color.CYAN, queue + "\n");
        }
        App.printf(Color.YELLOW, queue + " <-- Resultado!\n");
        App.printf(Color.PURPLE, "\n[READICIONANDO À PILHA USANDO A FILA]\n\n");

        while (!queue.isEmpty()) {
            push(queue.getBegin());
            queue.remove();
            App.printf(Color.GREEN, this + "\n");
        }
        App.printf(Color.YELLOW, this + " <-- Resultado!\n");
    }
    
    @Override
    public String toString() {
        var builder = new StringBuilder("[");

        for (Node<T> node = top; node != null; node = node.getNext()) {
            if (node.getNext() != null) 
                builder.append(node.getInfo()).append(", "); 
            else
                builder.append(node.getInfo()).append("");         
        }
        return builder.append("]").toString();
    }
}
