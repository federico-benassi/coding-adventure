package federico.benassi.hash_table;

import java.util.ArrayList;

public class HashTable<K, V> {

    ArrayList<ArrayList<Entry<K, V>>> buckets = new ArrayList<>(100);

    public HashTable(){
        for(int i = 0; i < 100; i++)
            this.buckets.add(new ArrayList<>());
    }
    public V get(K key){
        var toTest = this.buckets.get(getIndex(key)).stream().filter(item -> item.key.equals(key)).findFirst();
        return toTest.map(kvEntry -> kvEntry.value).orElse(null);
    }

    public void put(K key, V value){
        var toTest = this.buckets.get(getIndex(key));
        if (toTest == null) {
            toTest = new ArrayList<Entry<K, V>>();
        }
        toTest.add(new Entry<>(key, value));
    }

    public void remove(K key){
        var bucket = this.buckets.get(getIndex(key));
        bucket.removeIf(toTest -> toTest.key.equals(key));
    }

    private int getIndex(K key){
        return this.hash(key) % buckets.size();
    }
    private int hash(K key){
        return key.hashCode();
    }

    private static class Entry<K, V>{
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
