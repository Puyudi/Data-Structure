package lab8;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    public Node root;             // root of BST

    private class Node {
        private K key;           // sorted by key
        private V val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BSTMap() {
    }

    // @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("Well, you asked me to throw.");   
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    // @Override
    public boolean isEmpty() {
        return size() == 0;
    }


	/** Removes all of the mappings from this map. */
    // @Override
    public void clear() {
    	root = null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    // @Override
    public boolean containsKey(K key) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        return get(key) != null;
    }
    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. 
     */
    // @Override
    public V get(K key) {
    	return get(root, key);
    }

    private V get(Node x, K key) {
    	if (x == null) return null;
    	int cmp = key.compareTo(x.key);
    	if 		(cmp < 0) return get(x.left, key);
    	else if (cmp > 0) return get(x.right, key);
    	else 			  return x.val;
    }

    /* Returns the number of key-value mappings in this map. */
    // @Override
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
    /* Associates the specified value with the specified key in this map. */
    // @Override
    public void put(K key, V value) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        if (value == null) {
        	this.remove(key);
        	return;
        }
    	root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {
    	if (x == null) return new Node(key, value, 1);
    	int cmp = key.compareTo(x.key);
    	if 		(cmp < 0) x.left = put(x.left, key, value);
    	else if (cmp > 0) x.right = put(x.right, key, value);
    	else 			  x.val = value;
    	x.size = 1 + size(x.left) + size(x.right);
    	return x;
    }	

    /* Returns a Set view of the keys contained in this map. */
    // @Override
    public Set<K> keySet() {
    	throw new UnsupportedOperationException("Well, you asked me to throw.");
    }   

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an 
     * UnsupportedOperationException. */
    // @Override
    public V remove(K key) {
    	throw new UnsupportedOperationException("Well, you asked me to throw.");
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    // @Override
    public V remove(K key, V value) {
    	throw new UnsupportedOperationException("Well, you asked me to throw.");
    }

    // public void printInOrder() {

    // }
}
