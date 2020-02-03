package federico.benassi.queue;

import org.junit.Assert;
import org.junit.Test;

public class QueueTests {

    @Test
    public void givenQueueIsEmptyMethodShouldReturnTrueIfEmpty(){
        Queue<String> queue = new Queue<>();

        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void givenQueueGetSizeMethodShouldReturnTheSizeOfTheQueue(){
        Queue<String> queue = new Queue<>();

        queue.enqueue("Federico");
        queue.enqueue("Benassi");
        queue.enqueue("Alice");
        queue.enqueue("Gaghi");
        Assert.assertEquals(4, queue.getSize());
    }

    @Test
    public void givenQueueEnqueueMethodShouldAddTheValueAsLastElement(){
        Queue<String> queue = new Queue<>();

        queue.enqueue("Federico");
        Assert.assertEquals("Federico", queue.front());
    }

    @Test
    public void givenQueueFrontMethodShouldReturnTheFirstValueInserted(){
        Queue<String> queue = new Queue<>();

        queue.enqueue("Federico");
        queue.enqueue("Benassi");
        queue.enqueue("Alice");
        queue.enqueue("Gaghi");
        Assert.assertEquals("Federico", queue.front());
    }

    @Test
    public void givenQueueDequeueMethodShouldReturnTheFirstValueInsertedAndDeleteFrom(){
        Queue<String> queue = new Queue<>();

        queue.enqueue("Federico");
        queue.enqueue("Benassi");
        queue.enqueue("Alice");
        queue.enqueue("Gaghi");
        Assert.assertEquals("Federico", queue.dequeue());
        Assert.assertNotEquals("Federico", queue.dequeue());
    }
}
