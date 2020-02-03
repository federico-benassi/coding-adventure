package federico.benassi.tree;

import java.util.List;

public class Tree<T> {

    Node<T> root;


    public void add(T value){
        if(root == null) this.root = new Node<>(value, null, null);

    }


    private static class Node<T>{
        private T value;
        private Node<T> parentNode;
        private List<Node<T>> children;

        public Node(T value, Node<T> parentNode, List<Node<T>> children){
            this.value = value;
            this.parentNode = parentNode;
            this.children = children;
        }
    }
}
