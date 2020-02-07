package federico.benassi.data_structure.stack;

import java.util.Objects;

//LIFO
public class GenericStackWithLinkedListImplementation<T> implements Stack<T> {

    Node<T> head = null;
    long size = 0;

    @Override
    public void push(T value){
        if(Objects.isNull(head)) head = new Node<>(value, null);
        else head = new Node<>(value, head);
        size++;
    }

    @Override
    public T top(){
        return this.head.value;
    }

    @Override
    public T pop(){
        var value = head.value;
        var nextNode = head.nextNode;
        head.nextNode = null;
        head = nextNode;
        size--;
        return value;
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
