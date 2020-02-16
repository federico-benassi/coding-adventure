package federico.benassi.algorithm.sort;

import java.util.Random;

import static federico.benassi.ComparableUtils.*;

public class Shuffle<T extends Comparable<T>> implements Sort<T>{

    @Override
    public void sort(Comparable<T>[] array) {
        int n = array.length;
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < n; i++){
            int r = random.nextInt(i + 1);
            exchange(array, i, r);
        }
    }
}
