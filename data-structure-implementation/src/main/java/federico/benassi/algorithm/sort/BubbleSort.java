package federico.benassi.algorithm.sort;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    public void sort(Comparable[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j].compareTo(array[j + 1]) > 0){
                    var temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
