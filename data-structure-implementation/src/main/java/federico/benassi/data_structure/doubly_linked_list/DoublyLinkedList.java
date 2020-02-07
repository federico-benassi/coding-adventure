package federico.benassi.data_structure.doubly_linked_list;

import java.util.Collection;
import java.util.Objects;

public class DoublyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private long size = 0;

    public boolean isEmpty(){
        return Objects.isNull(this.head);
    }

    public long size() { return size; }

    public void addFirst(T value){
        this.head = new Node<T>(value, this.head, null);
        if(Objects.isNull(this.head.nextNode)) this.tail = this.head;
        this.size++;
    }

    public void removeFirst(){
        if(Objects.isNull(this.head)) return;
        else if(Objects.isNull(this.head.nextNode)) {
            this.head = null;
            this.tail = null;
        }
        else {
            var previousHead = this.head;
            this.head = this.head.nextNode;
            this.head.previousNode = null;
            previousHead.nextNode = null;
        }
        this.size--;
    }

    public void add(long index, T value){
        if(this.isEmpty()) throw new IndexOutOfBoundsException();
        else if(index == 0) this.addFirst(value);
        else if(index == this.size) this.addLast(value);
        else {
            var nodeBeforeChosenIndex = this.getNodeAtIndex(index - 1);
            var nodeAtChosenIndex = nodeBeforeChosenIndex.nextNode;
            nodeBeforeChosenIndex.nextNode = new Node<>(value, nodeAtChosenIndex, nodeBeforeChosenIndex);
        }
        this.size++;
    }

    public void addLast(T value){
        if(this.isEmpty()) {
            this.addFirst(value);
            return;
        }
        var lastNode = this.getNodeAtIndex(this.size - 1);
        lastNode.nextNode = new Node<>(value, null, lastNode);
        this.tail = lastNode.nextNode;
        this.size++;
    }

    public void removeLast(){
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }
        var nodeBeforeLastOne = this.getNodeAtIndex(this.size() - 2);
        nodeBeforeLastOne.nextNode.previousNode = null;
        nodeBeforeLastOne.nextNode = null;
        this.tail = nodeBeforeLastOne;
        this.size--;
    }


    public void addAll(Collection<T> c){
        this.addAllAtIndex(0, c);
    }

    public void addAllAtIndex(long index, Collection<T> c){
        T[] a = (T[]) c.toArray();
        if(a.length == 0) return;

        Node<T> firstNode = new Node<>(a[0], null, null);
        Node<T> currentNode= firstNode;
        this.size++;
        for(int i = 1; i < a.length; i++){
            currentNode.nextNode = new Node<>(a[i], null, currentNode);
            currentNode = currentNode.nextNode;
            this.size++;
        }

        if(this.isEmpty()){
            this.head = firstNode;
            this.tail = currentNode;
        } else if(index == 0) {
            var previousHead = this.head;
            this.head = firstNode;
            currentNode.nextNode = previousHead;
            previousHead.previousNode = currentNode;
        } else if(index == this.size - 1){
            var previousTail = this.tail;
            this.tail = currentNode;
            previousTail.nextNode = firstNode;
            firstNode.previousNode = previousTail;
        } else {
                var nodeBeforeChosenIndex = this.getNodeAtIndex(index - 1);
                var nodeAtChosenIndex = nodeBeforeChosenIndex.nextNode;

                nodeBeforeChosenIndex.nextNode = firstNode;
                firstNode.previousNode = nodeBeforeChosenIndex;

                currentNode.nextNode = nodeAtChosenIndex;
                nodeAtChosenIndex.previousNode = currentNode;
            }
        }

    public void clear(){
        if(Objects.isNull(this.head)) return;

        var currentNode = this.head;
        this.head = null;
        this.size--;
        while(!Objects.isNull(currentNode.nextNode)){
            var nextNode = currentNode.nextNode;
            currentNode.nextNode = null;
            currentNode.previousNode = null;
            currentNode = nextNode;
            this.size--;
        }
    }

    public T get(long index){
        return this.getNodeAtIndex(index).value;
    }

    private Node<T> getNodeAtIndex(long index){
        if(this.isEmpty()) throw new IndexOutOfBoundsException();
        if(index == 0) return this.head;
        if(index == this.size - 1) return this.tail;

        if(index > (this.size - 1) / 2){
            return this.getNodeFromTail(index);
        } else {
            return this.getNodeFromHead(index);
        }
    }

    private Node<T> getNodeFromHead(long index){
        var currentNode = this.head;
        var counter = 0L;

        while(!Objects.isNull(currentNode)){
            if(counter == index){
                return currentNode;
            } else {
                counter++;
                currentNode = currentNode.nextNode;
            }
        }

        throw new IndexOutOfBoundsException();
    }

    private Node<T> getNodeFromTail(long index){
        var currentNode = this.tail;
        var counter = this.size - 1;

        while(!Objects.isNull(currentNode)){
            if(counter == index){
                return currentNode;
            } else {
                counter--;
                currentNode = currentNode.previousNode;
            }
        }

        throw new IndexOutOfBoundsException();
    }

    private static class Node<T> {
        private T value;
        private Node<T> nextNode;
        private Node<T> previousNode;

        public Node(T value, Node<T> nextNode, Node<T> previousNode){
            this.value = value;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinkedList{");

        var currentNode = this.head;
        while(!Objects.isNull(currentNode.nextNode)){
            sb.append(currentNode.value);
            sb.append(", ");
            currentNode = currentNode.nextNode;
        }
        sb.append(currentNode.value);
        sb.append("}");
        return sb.toString();
    }
}
