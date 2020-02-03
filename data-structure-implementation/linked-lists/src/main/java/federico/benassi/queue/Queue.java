package federico.benassi.queue;

import federico.benassi.doubly_linked_list.DoublyLinkedList;

public class Queue<T> {
    private DoublyLinkedList<T> implementation;

    public Queue(){
        this.implementation = new DoublyLinkedList<>();
    }

    public void enqueue(T value){
        this.implementation.addLast(value);
    }

    public T front(){
        return this.implementation.get(0);
    }

    public T dequeue(){
        var toReturn = this.implementation.get(0);
        this.implementation.removeFirst();
        return toReturn;
    }

    public boolean isEmpty(){
        return this.implementation.isEmpty();
    }

    public boolean isFull(){
        return false;
    }

    public long getSize(){
        return this.implementation.size();
    }
}
