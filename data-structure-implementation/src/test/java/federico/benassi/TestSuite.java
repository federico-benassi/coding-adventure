package federico.benassi;

import federico.benassi.array_list.ArrayListTests;
import federico.benassi.doubly_linked_list.DoublyLinkedListTests;
import federico.benassi.hash_table.HashTableTests;
import federico.benassi.linked_list.LinkedListTests;
import federico.benassi.queue.*;
import federico.benassi.stack.GenericStackWithLinkedListImplementationTests;
import federico.benassi.stack.GenericStackWithArrayImplementationTests;
import federico.benassi.stack.GenericStackWithResizingArrayImplementionTests;
import federico.benassi.tree.BinarySearchTreeTests;
import federico.benassi.union_find.UnionQuickFindTests;
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
        BinarySearchTreeTests.class,
        UnionQuickFindTests.class
})
public class TestSuite {
}
