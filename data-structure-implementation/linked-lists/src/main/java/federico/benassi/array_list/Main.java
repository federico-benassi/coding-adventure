package federico.benassi.array_list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(100);

        arrayList.add(1, "Second");
        arrayList.addAll(0, List.of("First", "Third"));
        System.out.println(arrayList);
    }
}
