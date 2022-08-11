package utils;

public class ABB<Type extends Comparable<Type>> {
    private NodeTree<Type> root;

    public ABB() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    @SuppressWarnings("unchecked")
    public void add(Type ...elements) {
        for (Type element : elements) {
            add(element);
        }
    }

    public NodeTree<Type> getRoot() {
        return root;
    }

    public NodeTree<Type> search(Type element) {
        return search(this.root, element);
    }

    private NodeTree<Type> search(NodeTree<Type> node, Type key) {
        if (node == null) 
            return null;

        if (key == node.getValue()) {
            return node;
        }
        if (key.compareTo(node.getValue()) < 0) {
            return search(node.getLeft(), key);
        }
        return search(node.getRight(), key);
    }

    public void add(Type element) {       
        if (isEmpty()) {
            root = new NodeTree<Type>(element);
            return;
        }
        NodeTree<Type> aux = root;
        
        while (aux != null) {
            if (element.compareTo(aux.getValue()) < 0) {
                if (aux.getLeft() == null) {
                    NodeTree<Type> newNode = new NodeTree<>(element);
                    aux.setLeft(newNode);
                    aux.setParent(aux);
                    return;
                }
                aux = aux.getLeft();
            } else {
                if (aux.getRight() == null) {
                    NodeTree<Type> newNode = new NodeTree<>(element);
                    aux.setRight(newNode);
                    aux.setParent(aux);
                    return;
                }
                aux = aux.getRight();
            }
        }
    }

    public String inOrder() {
        var builder = new StringBuilder("[");
        inOrder(this.root, builder);
        return builder.substring(0, builder.toString().length() - 2) + "]";
    }
    
    private void inOrder(NodeTree<Type> node, StringBuilder builder) {
        if (node != null) {
            inOrder(node.getLeft(), builder);
            builder.append(node.getValue()).append(", ");
            inOrder(node.getRight(), builder);
        }
    }

    public String toString() {
        return inOrder();
    }
}