package federico.benassi.queue;


import java.util.Objects;

//FIFO
public class GenericQueueWithLinkedListImplementation<T> implements Queue<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    @Override
    public void enqueue(T value){
        if(Objects.isNull(head)) {
            var node = new Node<>(value, null);
            head = node;
            tail = node;
        } else {
            tail.nextNode = new Node<>(value, null);
            tail = tail.nextNode;
        }
        size++;
    }

    @Override
    public T front(){
        return this.head.value;
    }

    @Override
    public T dequeue(){
        var node = head;
        head = head.nextNode;
        node.nextNode = null;
        size--;
        return node.value;
    }

    @Override
    public boolean isEmpty(){
        return Objects.isNull(head);
    }


    @Override
    public long getSize(){
        return size;
    }

    private static class Node<T>{
        T value;
        Node<T> nextNode;

        public Node(T value, Node<T> nextNode){
            this.value = value;
            this.nextNode = nextNode;
        }
    }
}
