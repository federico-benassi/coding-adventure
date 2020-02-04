package federico.benassi.linked_list;

import java.util.Collection;
import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head = null;
    private long size = 0;

    public boolean isEmpty(){
        return Objects.isNull(this.head);
    }

    public long size() { return size; }

    public void addFirst(T value){
        this.head = new Node<T>(value, this.head);
        this.size++;
    }

    public void removeFirst(){
        if(Objects.isNull(this.head)) return;
        else if(Objects.isNull(this.head.nextNode)) this.head = null;
        else {
            var previousHead = this.head;
            this.head = this.head.nextNode;
            previousHead.nextNode = null;
        }
        this.size--;
    }

    public void add(long index, T value){
        if(this.isEmpty()) throw new IndexOutOfBoundsException();
        else if(index == 0) this.addFirst(value);
        else {
            var nodeBeforeChosenIndex = this.getNodeAtIndex(index - 1);
            var nodeAtChosenIndex = nodeBeforeChosenIndex.nextNode;
            nodeBeforeChosenIndex.nextNode = new Node<>(value, nodeAtChosenIndex);
        }
        this.size++;
    }

    public void addLast(T value){
        if(this.isEmpty()) {
            this.head = new Node<T>(value, null);
            this.size++;
            return;
        }
        var lastNode = this.getNodeAtIndex(this.size - 1);
        lastNode.nextNode = new Node<>(value, null);
        this.size++;
    }

    public void removeLast(){
        var nodeBeforeLastOne = this.getNodeAtIndex(this.size() - 2);
        nodeBeforeLastOne.nextNode = null;
        this.size--;
    }


    public void addAll(Collection<T> c){
        this.addAllAtIndex(0, c);
    }

    public void addAllAtIndex(long index, Collection<T> c){
        T[] a = (T[]) c.toArray();
        if(a.length == 0) return;

        Node<T> firstNode = new Node<>(a[0], null);
        Node<T> currentNode= firstNode;
        this.size++;
        for(int i = 1; i < a.length; i++){
            currentNode.nextNode = new Node<>(a[i], null);
            currentNode = currentNode.nextNode;
            this.size++;
        }

        if(this.isEmpty()){
            this.head = firstNode;
        } else {
            var nodeBeforeChosenIndex = this.getNodeAtIndex(index - 1);
            var nodeAtChosenIndex = nodeBeforeChosenIndex.nextNode;
            nodeBeforeChosenIndex.nextNode = firstNode;
            currentNode.nextNode = nodeAtChosenIndex;
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

    private static class Node<T> {
        private T value;
        private Node<T> nextNode;

        public Node(T value, Node nextNode){
            this.value = value;
            this.nextNode = nextNode;
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
