package federico.benassi.array_list;

import java.util.Arrays;
import java.util.Collection;

public class ArrayList<T> {
    private final int DEFAULT_SIZE = 10;

    private T[] internalArray;
    private int size;
    private int freeSpaceIndex = 0;

    public ArrayList(){
        this.internalArray = (T[]) new Object[DEFAULT_SIZE];
        this.size = DEFAULT_SIZE - 1;
    }

    public ArrayList(int initialSize){
        this.internalArray = (T[]) new Object[initialSize];
        this.size = initialSize - 1;
    }

    public ArrayList(Collection<T> c){
        this.internalArray = (T[]) new Object[DEFAULT_SIZE];
        this.size = DEFAULT_SIZE - 1;
        this.addAll(c);
    }

    public int size(){
        return this.freeSpaceIndex;
    }

    public boolean isEmpty(){
        return freeSpaceIndex == 0;
    }

    public boolean contains(T value){
        return Arrays.stream(this.internalArray).filter(item -> item.equals(value)).findFirst().isPresent();
    }

    public int indexOf(T value){
        for(int i = 0; i < freeSpaceIndex; i++)
            if(internalArray[i].equals(value)) return i;

        return -1;
    }

    public int lastIndexOf(T value){
        int lastIndexOf = -1;
        for(int i = 0; i < freeSpaceIndex; i++)
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
        this.internalArray[this.freeSpaceIndex] = value;
        this.freeSpaceIndex++;
    }

    public void remove(int index){
        this.checkForIndexOutOfBoundException(index);
        for(int i = index; i < this.size() - 1; i++){
            this.internalArray[i] = this.internalArray[i + 1];
        }
        this.internalArray[this.size - 1] = null;
    }

    public void add(int index, T value){
        this.testForResize();
        this.checkForIndexOutOfBoundException(index);

        if(index >= this.freeSpaceIndex) this.internalArray[this.freeSpaceIndex] = value;
        else {
            T temp = internalArray[index];
            internalArray[index] = value;
            for(int i = index + 1; i <= this.freeSpaceIndex; i++){
                internalArray[i + 1] = internalArray[i];
                internalArray[i] = temp;
                temp = internalArray[i + 1];
            }
        }
        this.freeSpaceIndex++;
    }

    public void addAll(Collection<T> c){
        T[] arr = (T[]) c.toArray();
        for(int i = 0; i < arr.length; i++){
            this.add(this.freeSpaceIndex, arr[i]);
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
        if(this.freeSpaceIndex == size){
            this.grow();
        } else if (this.freeSpaceIndex == size / 2 && size > DEFAULT_SIZE - 1){
            this.shrink();
        }
    }

    private void grow(){
        size *= 2;
        this.internalArray = Arrays.copyOf(this.internalArray, size);
    }

    private void shrink(){
        size /= 2;
        this.internalArray = Arrays.copyOfRange(this.internalArray, 0, size);
    }

    private void checkForIndexOutOfBoundException(int index){
        if(index < 0 || index > this.freeSpaceIndex) throw new IndexOutOfBoundsException();
    }
}
