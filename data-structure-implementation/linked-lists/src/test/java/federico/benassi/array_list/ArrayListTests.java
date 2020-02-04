package federico.benassi.array_list;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArrayListTests {

    @Test
    public void givenEmptyArrayListIsEmptyMethodShouldReturnTrue(){
        ArrayList<String> arrayList = new ArrayList<>();

        Assert.assertTrue(arrayList.isEmpty());
    }

    @Test
    public void givenFullArrayListContainsShouldReturnTrueIfTheSpecifiedElementIsPresent(){
        ArrayList<String> arrayList = new ArrayList<>(List.of("Federico", "Benassi"));

        Assert.assertTrue(arrayList.contains("Federico"));
    }

    @Test
    public void givenFullArrayListIndexOfShouldReturnTheElementIndex(){
        ArrayList<String> arrayList = new ArrayList<>(List.of("Federico", "Benassi"));

        Assert.assertEquals(1, arrayList.indexOf("Benassi"));
    }

    @Test
    public void givenFullArrayListLastIndexOfShouldReturnTheLastElementIndexThatMatch(){
        ArrayList<String> arrayList = new ArrayList<>(List.of("Federico", "Benassi", "Benassi", "Benassi"));

        Assert.assertEquals(3, arrayList.lastIndexOf("Benassi"));
    }

    @Test
    public void givenEmptyArrayListConstructorWithCollectionShouldAddAllTheItems(){
        ArrayList<String> arrayList = new ArrayList<>(List.of("Federico", "Benassi"));

        Assert.assertEquals("Federico", arrayList.get(0));
        Assert.assertEquals("Benassi", arrayList.get(1));
    }

    @Test
    public void GivenEmptyArrayListAddMethodShouldAddToTheFirstPosition(){
        ArrayList<String> testArrayList = new ArrayList<>();

        testArrayList.add("FirstItem");
        Assert.assertEquals("FirstItem", testArrayList.get(0));
    }

    @Test
    public void GivenEmptyArrayListSetMethodShouldReplaceAnElementAtSpecifiedIndex(){
        ArrayList<String> testArrayList = new ArrayList<>();

        testArrayList.add("FirstItem");
        testArrayList.set(0, "ReplacedItem");
        Assert.assertEquals("ReplacedItem", testArrayList.get(0));
    }

    @Test
    public void GivenEmptyArrayListAddMethodMoreThanTenTimesShouldGrowTheCapacity(){
        ArrayList<String> testArrayList = new ArrayList<>(List.of(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"
        ));

        Assert.assertEquals("11", testArrayList.get(10));
    }

    @Test
    public void GivenArrayListAddShouldThrowIndexOutOfBoundException(){
        ArrayList<String> testArrayList = new ArrayList<>();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
           testArrayList.add(2, "Error");
        });
    }

    @Test
    public void GivenArrayListAddShouldAddAtSpecificIndexAndShiftTheElementsIfIsTheCase(){
        ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.add("SecondItem");
        testArrayList.add("ThirdItem");

        testArrayList.add(0, "FirstItem");
        Assert.assertEquals("FirstItem", testArrayList.get(0));
        Assert.assertEquals("SecondItem", testArrayList.get(1));
        Assert.assertEquals("ThirdItem", testArrayList.get(2));
    }

    @Test
    public void GivenEmptyArrayListAddAllShouldAddAllTheItems(){
        ArrayList<String> testArrayList = new ArrayList<>();
        java.util.ArrayList<String> from = new java.util.ArrayList<>();
        from.add("First");
        from.add("Second");
        from.add("Third");
        testArrayList.addAll(from);

        Assert.assertEquals("First", testArrayList.get(0));
        Assert.assertEquals("Second", testArrayList.get(1));
        Assert.assertEquals("Third", testArrayList.get(2));
    }

    @Test
    public void givenFullArrayRemoveShouldRemoveAndShiftTheRigthElements(){
        ArrayList<String> testArrayList = new ArrayList<>();
        java.util.ArrayList<String> from = new java.util.ArrayList<>();
        from.add("First");
        from.add("Second");
        from.add("Third");
        testArrayList.addAll(from);

        testArrayList.remove(0);

        Assert.assertEquals("Second", testArrayList.get(0));
    }

    @Test
    public void givenFullArrayAddAllAtSpecifiedIndexShouldShiftAllTheElementsToTheRight(){
        ArrayList<String> testArrayList = new ArrayList<>();
        java.util.ArrayList<String> from = new java.util.ArrayList<>();
        from.add("First");
        from.add("Second");
        from.add("Third");
        testArrayList.addAll(from);

        testArrayList.addAll(0, List.of("Fourth", "Fifth"));

        Assert.assertEquals("Fourth", testArrayList.get(0));
        Assert.assertEquals("First", testArrayList.get(2));
    }
}
