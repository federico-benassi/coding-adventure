package federico.benassi.union_find;

import org.junit.Assert;
import org.junit.Test;

public class WeightPathCompressionUnionFindTests {
    @Test
    public void givenWeightUnionFindUnionElementsShouldReturnTrueIfConnected(){
        WeightPathCompressionUnionFind quickUnionFind = new WeightPathCompressionUnionFind(1000);

        quickUnionFind.union(10, 20);
        quickUnionFind.union(20, 30);
        Assert.assertTrue(quickUnionFind.connected(10, 30));
    }
}
