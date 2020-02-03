package federico.benassi.array_list;

import java.util.Arrays;
import java.util.Collection;

public class ArrayList<T> {
    private T[] internalArray;
    private final int DEFAULT_SIZE = 2;
    private int actualSize;
    private int index;

    public ArrayList(){
        this.internalArray = (T[]) new Object[DEFAULT_SIZE];
        this.actualSize = DEFAULT_SIZE - 1;
        this.index = 0;
    }

    public ArrayList(int initialSize){
        this.internalArray = (T[]) new Object[initialSize];
        this.actualSize = initialSize - 1;
        this.index = 0;
    }

    public T get(int index){
        if(index < 0 || index > this.actualSize - 1) throw new IndexOutOfBoundsException();
        return this.internalArray[index];
    }

    public void add(T value){
        this.testForResize();
        this.internalArray[this.index] = value;
        this.index++;
    }

    public void add(int index, T value){
        this.testForResize();
        if(index < 0 || index > actualSize) throw new IndexOutOfBoundsException();
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
            this.add(i + this.index, arr[i]);
        }
    }

    public void addAll(int index, Collection<T> c){
        T[] arr = (T[]) c.toArray();
        for(int i = 0; i < arr.length; i++){
            this.add(i + index, arr[i]);
        }
    }

    private void testForResize(){
        if(this.index == actualSize){
            this.grow();
        } else if (this.index == actualSize / 2 && actualSize > DEFAULT_SIZE - 1){
            this.shrink();
        }
    }

    private void grow(){
        actualSize *= 2;
        this.internalArray = Arrays.copyOf(this.internalArray, actualSize);
    }

    private void shrink(){
        actualSize /= 2;
        this.internalArray = Arrays.copyOfRange(this.internalArray, 0, actualSize);
    }
}
