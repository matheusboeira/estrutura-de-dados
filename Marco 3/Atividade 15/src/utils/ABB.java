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

    public boolean remove(Type value) {
        NodeTree<Type> current = this.root;
        NodeTree<Type> currentParent = null;

        while(current != null) {
            if (current.getValue().equals(value)) {
                break;                
            } else if (value.compareTo(current.getValue()) == -1) { 
                /**
                 * Valor procurado é menor que o atual.
                 */
                currentParent = current;
                current = current.getLeft();
            } else {
                currentParent = current;
                current = current.getRight();
            }
        }

        /**
         * Verifica se existe o elemento.
         */
        if (current != null) {
            if (current.getRight() != null){
                NodeTree<Type> substitute = current.getRight();
                NodeTree<Type> parentSubstitute = current;

                while(substitute.getLeft() != null){
                    parentSubstitute = substitute;
                    substitute = substitute.getLeft();
                }
                substitute.setLeft(current.getLeft());

                if (currentParent != null) {
                    if (current.getValue().compareTo(currentParent.getValue()) == -1) {
                        currentParent.setLeft(substitute);
                    }else {
                        currentParent.setRight(substitute);
                    }
                /**
                 * Se não tem pai atual, então é a raiz.
                 */
                } else {
                    this.root = substitute;
                    parentSubstitute.setLeft(null);
                    this.root.setRight(parentSubstitute);
                    this.root.setLeft(current.getLeft());
                }
                
                /**
                 * Removeu o elemento da árvore.
                 */
                if (substitute.getValue().compareTo(parentSubstitute.getValue()) == -1) {
                    parentSubstitute.setLeft(null);
                } else {
                    parentSubstitute.setRight(null);
                }
            } else if (current.getLeft() != null) {
                /**
                 * Tem filho apenas à esquerda.
                 */
                NodeTree<Type> substitute = current.getLeft();
                NodeTree<Type> parentSubstitute = current;

                while(substitute.getRight() != null) {
                    parentSubstitute = substitute;
                    substitute = substitute.getRight();
                }

                if (currentParent != null) {
                    if (current.getValue().compareTo(currentParent.getValue()) == -1) { //current < currentParent
                        currentParent.setLeft(substitute);
                    } else {
                        currentParent.setRight(substitute);
                    }
                } else {
                    this.root = substitute;
                }
                
                /**
                 * Removeu o elemento da árvore.
                 */
                if (substitute.getValue().compareTo(parentSubstitute.getValue()) == -1) {
                    parentSubstitute.setLeft(null);
                } else {
                    parentSubstitute.setRight(null);
                }
            } else {
                /**
                 * Não tem filho.
                 */
                if (currentParent != null) {
                    if (current.getValue().compareTo(currentParent.getValue()) == -1) { 
                        currentParent.setLeft(null);
                    } else {
                        currentParent.setRight(null);
                    }
                } else {
                    /**
                     * É a raíz.
                     */
                    this.root = null;
                }
            }
            return true;
        }
        return false;        
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