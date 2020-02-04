package federico.benassi.stack;

import federico.benassi.linked_list.LinkedList;

public class Stack<T> {
    private LinkedList<T> implementation;

    public Stack(){
        this.implementation = new LinkedList<>();
    }

    public void push(T value){
        this.implementation.addFirst(value);
    }

    public T top(){
        return this.implementation.get(0);
    }

    public T pop(){
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
