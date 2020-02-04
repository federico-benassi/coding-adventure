package federico.benassi.stack;

import org.junit.Assert;
import org.junit.Test;

public class StackTests {

    @Test
    public void givenStackIsEmptyMethodShouldReturnTrueIfEmpty(){
        Stack<String> stack = new Stack<>();

        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void givenStackGetSizeMethodShouldReturnTheSizeOfTheQueue(){
        Stack<String> stack = new Stack<>();

        stack.push("Federico");
        stack.push("Benassi");
        stack.push("Alice");
        stack.push("Gaghi");
        Assert.assertEquals(4, stack.getSize());
    }

    @Test
    public void givenStackPushMethodShouldAddTheValueAsFirstElement(){
        Stack<String> stack = new Stack<>();

        stack.push("Federico");
        stack.push("Benassi");
        stack.push("Alice");
        stack.push("Gaghi");
        Assert.assertEquals("Gaghi", stack.top());
    }

    @Test
    public void givenStackTopMethodShouldReturnTheLastValueInserted(){
        Stack<String> stack = new Stack<>();

        stack.push("Federico");
        stack.push("Benassi");
        stack.push("Alice");
        stack.push("Gaghi");
        Assert.assertNotEquals("Federico", stack.top());
    }

    @Test
    public void givenStackPopMethodShouldReturnTheLastValueInsertedAndDeleteFrom(){
        Stack<String> stack = new Stack<>();

        stack.push("Federico");
        stack.push("Benassi");
        stack.push("Alice");
        stack.push("Gaghi");
        Assert.assertEquals("Gaghi", stack.pop());
        Assert.assertNotEquals("Gaghi", stack.pop());
    }
}
