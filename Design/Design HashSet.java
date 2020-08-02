class MyHashSet {

    private final Bucket[] buckets = new Bucket[10000];
    
    /** Initialize your data structure here. */
    public MyHashSet() {        
    }
    
    public void add(int key) {
        var bucketIdx = key % buckets.length;
        if (buckets[bucketIdx] == null) {
            buckets[bucketIdx] = new Bucket();
        }
        buckets[bucketIdx].add(key);
    }
    
    public void remove(int key) {
        var bucketIdx = key % buckets.length;
        if (buckets[bucketIdx] == null) {
            return;
        }
        buckets[bucketIdx].remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        var bucketIdx = key % buckets.length;
        if (buckets[bucketIdx] == null) {
            return false;
        }
        return buckets[bucketIdx].contains(key);
    }
    
    private class Bucket {
        private final ArrayList<Integer> keys = new ArrayList<Integer>();
        
        public void add(int key) {
            if (!contains(key)) {
                keys.add(key);
            }
        }
        
        public void remove(int key) {
            keys.remove(Integer.valueOf(key));
        }
        
        public boolean contains(int key) {
            return keys.contains(key);
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */