package federico.benassi;

import federico.benassi.array_list.ArrayListTests;
import federico.benassi.doubly_linked_list.DoublyLinkedListTests;
import federico.benassi.hash_table.HashTableTests;
import federico.benassi.linked_list.LinkedListTests;
import federico.benassi.queue.QueueTests;
import federico.benassi.stack.StackTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ArrayListTests.class,
        DoublyLinkedListTests.class,
        HashTableTests.class,
        LinkedListTests.class,
        QueueTests.class,
        StackTests.class
})
public class TestSuite {
}
