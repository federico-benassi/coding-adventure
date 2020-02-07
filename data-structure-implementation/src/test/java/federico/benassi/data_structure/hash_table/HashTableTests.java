package federico.benassi.data_structure.hash_table;

import org.junit.Assert;
import org.junit.Test;

public class HashTableTests {

    @Test
    public void givenHashTableAddMethodShouldAddAnItemAndAKey(){
        HashTable<String, String> hashTable = new HashTable<>();

        hashTable.put("TestKey", "Federico");

        Assert.assertEquals("Federico", hashTable.get("TestKey"));
    }
}
