package federico.benassi.linked_list;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LinkedListTests {

    @Test
    public void givenEmptyLinkedListIsEmptyMethodShouldReturnTrue(){
        var emptyLinkedList = new LinkedList<String>();
        Assert.assertTrue(emptyLinkedList.isEmpty());
    }

    @Test
    public void givenNonEmptyLinkedListSizeMethodShouldReturnNumber(){
        var nonEmptyLinkedList = new LinkedList<String>();
        nonEmptyLinkedList.addFirst("firstValue");
        Assert.assertEquals(1, nonEmptyLinkedList.size());
    }

    @Test
    public void givenLinkedListAddFirstShouldAddTheValueInTheFirstNode(){
        var linkedList = new LinkedList<String>();
        String testValue = "FirstValue";
        linkedList.addFirst(testValue);
        Assert.assertEquals(testValue, linkedList.get(0));
    }

    @Test
    public void givenLinkedListRemoveFirstShouldRemoveTheValueInTheFirstNode(){
        var linkedList = new LinkedList<String>();
        String firstNode = "FirstValue";
        String secondNode = "SecondValue";
        linkedList.addFirst(firstNode);
        linkedList.addLast(secondNode);

        linkedList.removeFirst();
        Assert.assertEquals(secondNode, linkedList.get(0));
    }

    @Test
    public void givenLinkedListAddMethodShouldAddAtSpecificIndex(){
        var linkedList = new LinkedList<String>();
        String firstNode = "FirstValue";
        String secondNode = "SecondValue";
        String midNode = "MidValue";
        linkedList.addFirst(firstNode);
        linkedList.addLast(secondNode);

        linkedList.add(1, midNode);

        Assert.assertEquals(firstNode, linkedList.get(0));
        Assert.assertEquals(midNode, linkedList.get(1));
        Assert.assertEquals(secondNode, linkedList.get(2));
    }

    @Test
    public void givenLinkedListAddLastShouldAddTheValueInTheLastNode(){
        var linkedList = new LinkedList<String>();
        String lastValue = "lastValue";
        linkedList.addLast(lastValue);
        Assert.assertEquals(1L, linkedList.size());
        Assert.assertEquals(lastValue, linkedList.get(linkedList.size() - 1));
    }

    @Test
    public void givenLinkedListRemoveLastShouldRemoveLastNode(){
        var linkedList = new LinkedList<String>();
        String firstNode = "FirstValue";
        String secondNode = "SecondValue";
        String midNode = "MidValue";
        linkedList.addFirst(firstNode);
        linkedList.addLast(secondNode);
        linkedList.add(1, midNode);

        linkedList.removeLast();
        Assert.assertEquals(2, linkedList.size());
    }

    @Test
    public void givenEmptyLinkedListAddAllMethodShouldAddAllItems(){
        var linkedList = new LinkedList<String>();
        linkedList.addAll(List.of("Federico", "Benassi", "Spacca!!"));

        Assert.assertEquals(3, linkedList.size());
        Assert.assertEquals("Federico", linkedList.get(0));
        Assert.assertEquals("Benassi", linkedList.get(1));
        Assert.assertEquals("Spacca!!", linkedList.get(2));
    }

    @Test
    public void givenNonEmptyLinkedListAddAllAtIndexMethodShouldAddAllItemsAtSpecificIndex(){
        var linkedList = new LinkedList<String>();
        linkedList.addAll(List.of("Federico", "Benassi", "Spacca!!"));

        linkedList.addAllAtIndex(2, List.of(", ", "il migliore", ", "));
        Assert.assertEquals(6, linkedList.size());
        Assert.assertEquals(", ", linkedList.get(2));
        Assert.assertEquals("il migliore", linkedList.get(3));
        Assert.assertEquals(", ", linkedList.get(4));
    }

    @Test
    public void givenNonEmptyLinkedListClearShouldClearAllTheNodes(){
        List<Integer> integers = List.of(1, 2, 3, 4);
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.addAll(integers);

        integerLinkedList.clear();
        Assert.assertEquals(0, integerLinkedList.size());
    }

    @Test
    public void givenLinkedListGetShouldThrowErrorIfIndexIsNegative(){
        var linkedList = new LinkedList<String>();
        Exception exception = Assert.assertThrows(IndexOutOfBoundsException.class, () ->{
            linkedList.get(-1);
        });
    }

    @Test
    public void givenLinkedListGetShouldThrowErrorIfIndexIsGreaterThanNumberOfElements(){
        var linkedList = new LinkedList<String>();
        Exception exception = Assert.assertThrows(IndexOutOfBoundsException.class, () ->{
            linkedList.get(Long.MAX_VALUE);
        });
    }
}
