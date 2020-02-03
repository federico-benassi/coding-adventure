package federico.benassi.array_list;

import org.junit.Assert;
import org.junit.Test;

public class ArrayListTests {

    @Test
    public void GivenEmptyArrayListAddMethodShouldAddToTheFirstPosition(){
        ArrayList<String> testArrayList = new ArrayList<>();

        testArrayList.add("FirstItem");
        Assert.assertEquals("FirstItem", testArrayList.get(0));
    }

    @Test
    public void GivenEmptyArrayListAddMethodMoreThanTwoTimesShouldGrowTheCapacity(){
        ArrayList<String> testArrayList = new ArrayList<>();

        testArrayList.add("FirstItem");
        Assert.assertEquals("FirstItem", testArrayList.get(0));
        testArrayList.add("SecondItem");
        Assert.assertEquals("SecondItem", testArrayList.get(1));
        testArrayList.add("ThirdItem");
        Assert.assertEquals("ThirdItem", testArrayList.get(2));

        Assert.assertEquals("FirstItem", testArrayList.get(0));
        Assert.assertEquals("SecondItem", testArrayList.get(1));
        Assert.assertEquals("ThirdItem", testArrayList.get(2));
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
}
