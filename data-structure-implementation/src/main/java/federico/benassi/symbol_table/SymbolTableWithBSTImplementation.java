package federico.benassi.symbol_table;

public class SymbolTableWithBSTImplementation<K extends Comparable<K>, V> implements SymbolTable<K, V> {

    private Node<K, V> root;

    @Override
    public void put(K key, V value) {
        // Recursive
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> x, K key, V value){
        if(x == null) return new Node(key, value, null, null);
        if(key.compareTo(x.key) < 0) x.leftChild = put(x.leftChild, key, value);
        else if(key.compareTo(x.key) > 0) x.rightChild = put(x.rightChild, key, value);
        else if(key.compareTo(x.key) == 0) x.value = value;
        return x;
    }

    @Override
    public V get(K key) {
        var node = getNode(key);
        if(node != null) return node.value;
        else return null;
    }

    private Node<K, V> getNode(K key){
        var currentNode = root;
        while(currentNode != null) {
            if (currentNode.key.compareTo(key) < 0) {
                currentNode = currentNode.leftChild;
            } else if (currentNode.key.compareTo(key) > 0) {
                currentNode = currentNode.rightChild;
            } else {
                return currentNode;
            }
        }
        return null;
    }

    @Override
    public void delete(K key) {
        getNode(key).value = null;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<K> key() {
        return null;
    }

    private class Node<K, V>{
        private K key;
        private V value;
        private Node<K, V> leftChild;
        private Node<K, V> rightChild;

        public Node(K key, V value, Node<K, V> leftChild, Node<K, V> rightChild) {
            this.key = key;
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
