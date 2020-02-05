package federico.benassi.union_find;

import org.junit.Assert;
import org.junit.Test;

public class QuickUnionFindTests {

    @Test
    public void givenQuickUnionFindUnionElementsShouldReturnTrueIfConnected(){
        QuickUnionFind quickUnionFind = new QuickUnionFind(1000);

        quickUnionFind.union(10, 20);
        quickUnionFind.union(20, 30);
        Assert.assertTrue(quickUnionFind.connected(10, 30));
    }
}
