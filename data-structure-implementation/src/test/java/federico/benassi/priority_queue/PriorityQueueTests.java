package federico.benassi.priority_queue;

import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTests {

    @Test
    public void givenEmptyMaxPriorityQueueIsEmptyShouldReturnTrue(){
        MaxPriorityQueue<String> priorityQueue = new MaxPriorityQueue<>();

        Assert.assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void givenMaxPriorityQueueInsertShouldInsertValue(){
        MaxPriorityQueue<String> priorityQueue = new MaxPriorityQueue<>();

        priorityQueue.insert("Federico");

        Assert.assertTrue(!priorityQueue.isEmpty());
    }

    @Test
    public void givenMaxPriorityQueueALotOfInsertShouldKeepTheMaximumValueAtTheStart(){
        MaxPriorityQueue<String> priorityQueue = new MaxPriorityQueue<>();

        priorityQueue.insert("Federico");
        priorityQueue.insert("Gandalf");
        priorityQueue.insert("Zebra");
        priorityQueue.insert("Andrea");

        Assert.assertTrue(!priorityQueue.isEmpty());
        Assert.assertEquals("Zebra", priorityQueue.delete());
    }
}
