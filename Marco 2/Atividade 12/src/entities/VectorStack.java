package entities;

public class VectorStack<T> implements Stack<T> {
    private Object[] stack; 
    private int elements;

    public VectorStack(int size) {
        stack = new Object[size];
        elements = 0;
    }

    @Override
    public boolean push(T element) {
        if (this.elements == stack.length) {
            return false;
        }
        this.stack[this.elements] = element;
        this.elements++;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        Object element = null;

        if (isEmpty())
            return null;

        element = this.stack[elements - 1];
        this.stack[elements - 1] = null;
        this.elements--;
        return (T) element;
    }

    /**
     * Verificando se um texto é um palíndromo utilizando uma
     * pilha.
     */
    public boolean isPalindrome(String text) {
        var stack = new VectorStack<Character>(text.length());

        for (var character : text.toCharArray()) {
            stack.push(character);
        }

        for (var i = 0; i < text.length(); i++) {
            if (stack.pop() != text.charAt(i))
                return false;
        }
        return true;
    }
    

    @Override
    @SuppressWarnings("unchecked")
    public T top() {
        return (T) this.stack[elements];
    }

    @Override
    public boolean isEmpty() {
        return elements == 0;
    }

    @Override
    public int size() {
        return stack.length;
    }
    
    @Override
    public String toString() {
        var builder = new StringBuilder("[");

        for (int i = 0; i < size(); i++) {
            if (i < size() - 1) 
                builder.append(stack[i]).append(", "); 
            else
                builder.append(stack[i]).append("");         
        }
        return builder.append("]").toString();
    }
}
