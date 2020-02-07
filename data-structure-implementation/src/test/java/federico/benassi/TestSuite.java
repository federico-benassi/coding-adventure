package federico.benassi;

import federico.benassi.algorithm.search.BinarySearchTests;
import federico.benassi.algorithm.search.JumpSearchTests;
import federico.benassi.algorithm.search.LinearSearchTests;
import federico.benassi.algorithm.sort.*;
import federico.benassi.data_structure.array_list.ArrayListTests;
import federico.benassi.data_structure.doubly_linked_list.DoublyLinkedListTests;
import federico.benassi.data_structure.hash_table.HashTableTests;
import federico.benassi.data_structure.linked_list.LinkedListTests;
import federico.benassi.data_structure.priority_queue.PriorityQueueTests;
import federico.benassi.data_structure.queue.*;
import federico.benassi.data_structure.stack.GenericStackWithLinkedListImplementationTests;
import federico.benassi.data_structure.stack.GenericStackWithArrayImplementationTests;
import federico.benassi.data_structure.stack.GenericStackWithResizingArrayImplementionTests;
import federico.benassi.data_structure.tree.BinarySearchTreeTests;
import federico.benassi.data_structure.union_find.UnionQuickFindTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ArrayListTests.class,
        DoublyLinkedListTests.class,
        HashTableTests.class,
        LinkedListTests.class,
        GenericQueueWithLinkedListImplementationTests.class,
        GenericQueueWithArrayImplementationTests.class,
        GenericQueueWithResizingArrayImplementationTests.class,
        GenericStackWithLinkedListImplementationTests.class,
        GenericStackWithArrayImplementationTests.class,
        GenericStackWithResizingArrayImplementionTests.class,
        PriorityQueueTests.class,
        BinarySearchTreeTests.class,
        UnionQuickFindTests.class,
        BinarySearchTests.class,
        JumpSearchTests.class,
        LinearSearchTests.class,
        BubbleSortTests.class,
        CountingSortTests.class,
        InsertionSortTests.class,
        MergeSortTests.class,
        QuickSortTests.class,
        SelectionSortTests.class,
        ShellSortTests.class,
        ShuffleTests.class,
})
public class TestSuite {
}
