package federico.benassi.stack;

import org.junit.Assert;
import org.junit.Test;

public class GenericStackWithArrayImplementationTests {

    @Test
    public void givenStackIsEmptyMethodShouldReturnTrueIfEmpty(){
        Stack<String> genericStack = new GenericStackWithArrayImplementation<>(20);

        Assert.assertTrue(genericStack.isEmpty());
    }

    @Test
    public void givenStackGetSizeMethodShouldReturnTheSizeOfTheQueue(){
        Stack<String> genericStack = new GenericStackWithArrayImplementation<>(20);

        genericStack.push("Federico");
        genericStack.push("Benassi");
        genericStack.push("Alice");
        genericStack.push("Gaghi");
        Assert.assertEquals(4, genericStack.getSize());
    }

    @Test
    public void givenStackPushMethodShouldAddTheValueAsFirstElement(){
        Stack<String> genericStack =new GenericStackWithArrayImplementation<>(20);

        genericStack.push("Federico");
        genericStack.push("Benassi");
        genericStack.push("Alice");
        genericStack.push("Gaghi");
        Assert.assertEquals("Gaghi", genericStack.top());
    }

    @Test
    public void givenStackTopMethodShouldReturnTheLastValueInserted(){
        Stack<String> genericStack = new GenericStackWithArrayImplementation<>(20);

        genericStack.push("Federico");
        genericStack.push("Benassi");
        genericStack.push("Alice");
        genericStack.push("Gaghi");
        Assert.assertNotEquals("Federico", genericStack.top());
    }

    @Test
    public void givenStackPopMethodShouldReturnTheLastValueInsertedAndDeleteFrom(){
        Stack<String> genericStack = new GenericStackWithArrayImplementation<>(20);

        genericStack.push("Federico");
        genericStack.push("Benassi");
        genericStack.push("Alice");
        genericStack.push("Gaghi");
        Assert.assertEquals("Gaghi", genericStack.pop());
        Assert.assertNotEquals("Gaghi", genericStack.pop());
    }
}
