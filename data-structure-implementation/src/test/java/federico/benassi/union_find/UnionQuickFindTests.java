package federico.benassi.union_find;

import org.junit.Assert;
import org.junit.Test;

public class UnionQuickFindTests {

    @Test
    public void givenUnionQuickFindUnionShouldUnionTwoElement(){
        UnionQuickFind unionQuickFind = new UnionQuickFind(100);
        unionQuickFind.union(10, 20);
        unionQuickFind.union(20, 30);
        Assert.assertTrue(unionQuickFind.connected(10, 20));
        Assert.assertTrue(unionQuickFind.connected(10, 30));
    }
}
