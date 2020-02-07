package federico.benassi.data_structure.tree;

public class Main {
    public static void main(String[] args) {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>();
        binaryHeap.add(1);
        binaryHeap.add(4);
        binaryHeap.add(2);
        binaryHeap.add(3);

        System.out.println(binaryHeap);
        System.out.println(binaryHeap.extract());
        System.out.println(binaryHeap);
    }
}
