package federico.benassi.algorithm.sort;

import static federico.benassi.ComparableUtils.*;

public class InsertionSort <T extends Comparable<T>> implements Sort<T>{

        @Override
        public void sort(Comparable<T>[] array) {
            for(int i = 0; i < array.length; i++){
                for(int j = i; j > 0; j--){
                    if(less(array[j], array[j - 1])){
                        exchange(array, j, j - 1);
                    } else {
                        break;
                    }
                }
            }
        }

}
