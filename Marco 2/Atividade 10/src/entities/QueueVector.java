package entities;

public class QueueVector<T> implements Queue<T> {
    private int first;
    private int last;
    private int control;
    private Object[] queue;

    public QueueVector(int size) {
        queue = new Object[size];
    }

    @Override
    public boolean add(T element) throws QueueException {
        if (isFull())
            throw new QueueException("Capacidade esgotada!");
 
        queue[(first + last) % queue.length] = element;
        last++;
        control++;
        return true;
    }

    @Override
    public boolean remove() throws QueueException {
        if (isEmpty()) 
            throw new QueueException("A fila está vazia.");
        
        queue[first] = null;
        this.first = (this.first + 1) % queue.length;
        last--;
        control--;
        return true;
    }

    @Override
    public boolean isFull() {
        return control == queue.length;
    }

    @Override
    public boolean isEmpty() {
        return queue[first] == null && queue[last] == null;
    }

    @Override
    public int size() {
        return queue.length;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder("[");

        for (int i = 0; i < queue.length; i++) {
            if (i < queue.length - 1) 
                builder.append(queue[i]).append(", "); 
            else
                builder.append(queue[i]).append("");         
        }
        return builder.append("]").toString();
    }
}
