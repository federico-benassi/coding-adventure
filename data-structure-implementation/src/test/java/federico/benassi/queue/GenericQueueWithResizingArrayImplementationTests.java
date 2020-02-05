package federico.benassi.queue;

import org.junit.Assert;
import org.junit.Test;

public class GenericQueueWithResizingArrayImplementationTests {

    @Test
    public void givenQueueIsEmptyMethodShouldReturnTrueIfEmpty(){
        Queue<String> genericQueue = new GenericQueueWithResizingArrayImplementation<>();

        Assert.assertTrue(genericQueue.isEmpty());
    }

    @Test
    public void givenQueueGetSizeMethodShouldReturnTheSizeOfTheQueue(){
        Queue<String> genericQueue = new GenericQueueWithResizingArrayImplementation<>();

        genericQueue.enqueue("Federico");
        genericQueue.enqueue("Benassi");
        genericQueue.enqueue("Alice");
        genericQueue.enqueue("Gaghi");
        Assert.assertEquals(4, genericQueue.getSize());
    }

    @Test
    public void givenQueueEnqueueMethodShouldAddTheValueAsLastElement(){
        Queue<String> genericQueue = new GenericQueueWithResizingArrayImplementation<>();

        genericQueue.enqueue("Federico");
        Assert.assertEquals("Federico", genericQueue.front());
    }

    @Test
    public void givenQueueFrontMethodShouldReturnTheFirstValueInserted(){
        Queue<String> genericQueue = new GenericQueueWithResizingArrayImplementation<>();

        genericQueue.enqueue("Federico");
        genericQueue.enqueue("Benassi");
        genericQueue.enqueue("Alice");
        genericQueue.enqueue("Gaghi");
        Assert.assertEquals("Federico", genericQueue.front());
    }

    @Test
    public void givenQueueDequeueMethodShouldReturnTheFirstValueInsertedAndDeleteFrom(){
        Queue<String> genericQueue = new GenericQueueWithResizingArrayImplementation<>();

        genericQueue.enqueue("Federico");
        genericQueue.enqueue("Benassi");
        genericQueue.enqueue("Alice");
        genericQueue.enqueue("Gaghi");
        Assert.assertEquals("Federico", genericQueue.dequeue());
        Assert.assertNotEquals("Federico", genericQueue.dequeue());
    }
}
