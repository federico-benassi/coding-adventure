package federico.benassi.sort_algorithm;

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


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        StringBuilder sb = new StringBuilder();
        shuffle(arr);
        sb.append("[");

        for(Integer i : arr)
            sb.append(i).append(", ");

        sb.delete(sb.length() - 2, sb.length()).append("]");

        System.out.println(sb.toString());
    }
}
