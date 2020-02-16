package federico.benassi.data_structure.array_list;

import java.util.Arrays;
import java.util.Collection;


public class ArrayList<T> {
    private final int DEFAULT_SIZE = 10;

    private T[] internalArray;
    private int index = 0;

    public ArrayList(){
        this.internalArray = (T[]) new Object[DEFAULT_SIZE];
    }

    public ArrayList(int initialSize){
        this.internalArray = (T[]) new Object[initialSize];
    }

    public ArrayList(Collection<T> c){
        this.internalArray = (T[]) new Object[DEFAULT_SIZE];
        this.addAll(c);
    }

    public int size(){
        return this.index;
    }

    public boolean isEmpty(){
        return index == 0;
    }

    public boolean contains(T value){
        for(int i = 0; i < index; i++)
            if(internalArray[i].equals(value)) return true;

        return false;
    }

    public int indexOf(T value){
        for(int i = 0; i < index; i++)
            if(internalArray[i].equals(value)) return i;

        return -1;
    }

    public int lastIndexOf(T value){
        int lastIndexOf = -1;
        for(int i = 0; i < index; i++)
            if(internalArray[i].equals(value)) lastIndexOf = i;

        return lastIndexOf;
    }

    public T get(int index){
        this.checkForIndexOutOfBoundException(index);
        return this.internalArray[index];
    }

    public void set(int index, T value){
        this.checkForIndexOutOfBoundException(index);
        this.internalArray[index] = value;
    }

    public void add(T value){
        this.testForResize();
        this.internalArray[this.index] = value;
        this.index++;
    }

    public void remove(int index){
        this.checkForIndexOutOfBoundException(index);
        for(int i = index; i < this.size() - 1; i++){
            this.internalArray[i] = this.internalArray[i + 1];
        }
        this.internalArray[internalArray.length - 1] = null;
    }

    public void add(int index, T value){
        this.testForResize();
        this.checkForIndexOutOfBoundException(index);

        if(index >= this.index) this.internalArray[this.index] = value;
        else {
            T temp = internalArray[index];
            internalArray[index] = value;
            for(int i = index + 1; i <= this.index; i++){
                internalArray[i + 1] = internalArray[i];
                internalArray[i] = temp;
                temp = internalArray[i + 1];
            }
        }
        this.index++;
    }

    public void addAll(Collection<T> c){
        T[] arr = (T[]) c.toArray();
        for(int i = 0; i < arr.length; i++){
            this.add(this.index, arr[i]);
        }
    }

    public void addAll(int index, Collection<T> c){
        this.checkForIndexOutOfBoundException(index);
        T[] arr = (T[]) c.toArray();
        for(int i = 0; i < arr.length; i++){
            this.add(i + index, arr[i]);
        }
    }

    private void testForResize(){
        if(this.index == internalArray.length - 1){
            this.grow();
        } else if (index == internalArray.length / 4 && internalArray.length > DEFAULT_SIZE - 1){
            this.shrink();
        }
    }

    private void grow(){
        this.internalArray = Arrays.copyOf(this.internalArray, internalArray.length * 2);
    }

    private void shrink(){
        this.internalArray = Arrays.copyOfRange(this.internalArray, 0, internalArray.length / 2);
    }

    private void checkForIndexOutOfBoundException(int index){
        if(index < 0 || index > this.index) throw new IndexOutOfBoundsException();
    }
}
