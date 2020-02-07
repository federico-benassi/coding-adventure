package federico.benassi.algorithm.sort;

import java.util.Random;

import static federico.benassi.ComparableUtils.*;

public class Shuffle {

    public static void shuffle(Comparable[] a){
        int n = a.length;
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < n; i++){
            int r = random.nextInt(i + 1);
            exchange(a, i, r);
        }
    }
}
