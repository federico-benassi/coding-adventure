package federico.benassi.linked_list;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> test = new LinkedList<>();
        Integer[] arr = new Integer[100_000_000];
        Arrays.fill(arr, 10);
        List<Integer> from = Arrays.asList(arr);
        Stopwatch stopwatch = Stopwatch.createStarted();
        test.addAll(from);
        System.out.println(stopwatch.elapsed());
        stopwatch.stop();
        /*
        List<Integer> test1 = new ArrayList<>();
        stopwatch = Stopwatch.createStarted();
        test1.addAll(from);
        System.out.println(stopwatch.elapsed());
        stopwatch.stop();
        */
    }
}
