package federico.benassi.data_structure.tree;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>> {

    Node<T> root;

    public void add(T value){
        if(Objects.isNull(this.root)){
            this.root = new Node<>(value, null, null, null);
            return;
        }

        var currentNode = this.root;
        while(!Objects.isNull(currentNode)){
            if(currentNode.value.equals(value)) return;
            else if(currentNode.value.compareTo(value) > 0){
                if(Objects.isNull(currentNode.leftNode)) currentNode.leftNode = new Node<>(value, currentNode, null, null);
                else{
                    currentNode = currentNode.leftNode;
                }
            }
            else if(currentNode.value.compareTo(value) < 0) {
                if(Objects.isNull(currentNode.rightNode)) currentNode.rightNode = new Node<>(value, currentNode, null, null);
                else{
                    currentNode = currentNode.rightNode;
                }
            }
        }

    }

    public void delete(T value){
        Node<T> node = this.findNode(value);
        if(Objects.isNull(node)) return;
        if(Objects.isNull(node.rightNode) && Objects.isNull(node.leftNode)) this.deletionWithNoChild(node);
        if(Objects.isNull(node.rightNode) && !Objects.isNull(node.leftNode)) this.deletionWithOneChild(node);
        if(!Objects.isNull(node.rightNode) && Objects.isNull(node.leftNode)) this.deletionWithOneChild(node);
        if(!Objects.isNull(node.rightNode) && !Objects.isNull(node.leftNode)) this.deletionWithTwoChild(node);
    }

    private void deletionWithNoChild(Node<T> node){
        var parentNode = node.parentNode;
        if(Objects.isNull(parentNode)) this.root = null;
        else {
            boolean isLeft = parentNode.leftNode == node;
            if(isLeft) parentNode.leftNode = null;
            else parentNode.rightNode = null;
        }
    }

    private void deletionWithOneChild(Node<T> node){
        var parentNode = node.parentNode;
        if(Objects.isNull(parentNode)) this.root = Objects.isNull(node.rightNode) ? node.leftNode : node.rightNode;
        else {
            boolean isLeft = parentNode.leftNode == node;
            if(isLeft) parentNode.leftNode = Objects.isNull(node.rightNode) ? node.leftNode : node.rightNode;
            else parentNode.rightNode = Objects.isNull(node.rightNode) ? node.leftNode : node.rightNode;
        }
    }

    private void deletionWithTwoChild(Node<T> node) {
        T valueToBeReplaced = findTheMinimumInTheRightSubtree(node);
        this.delete(valueToBeReplaced);
        node.value = valueToBeReplaced;
    }

    private T  findTheMinimumInTheRightSubtree(Node<T> node){
        Node<T> currentNode = node.rightNode;
        while(currentNode.leftNode != null){
            currentNode = currentNode.leftNode;
        }
        return currentNode.value;
    }

    public boolean search(T value){
        if(Objects.isNull(this.findNode(value))) return false;
        else return true;
    }

    private Node<T> findNode(T value){
        var currentNode = this.root;
        while(!Objects.isNull(currentNode)){
            if(currentNode.value.equals(value)) return currentNode;
            else if(currentNode.value.compareTo(value) > 0) currentNode = currentNode.leftNode;
            else if(currentNode.value.compareTo(value) < 0) currentNode = currentNode.rightNode;
        }

        return null;
    }


    private static class Node<T>{
        private T value;
        private Node<T> parentNode;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T value, Node<T> parentNode, Node<T> leftNode, Node<T> rightNode){
            this.value = value;
            this.parentNode = parentNode;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
