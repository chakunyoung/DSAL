package B_Hash;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashMap<K, V> {
    LinkedList<MyEntry<K,V>>[] bucket;
    int bucketSize = 30;

    class MyEntry<K, V>{
        K key;
        V value;
        public MyEntry(K k, V v){
            this.key = k;
            this.value = v;
        }

        @Override
        public String toString() {
            return  "[ key=" + key +
                    ", value=" + value + " ]";
        }
    }

    public MyHashMap() {
         bucket = new LinkedList[bucketSize];
         for(int i = 0; i<bucketSize; i++)
             bucket[i] = new LinkedList<>();
    }

    public void put(K k, V v){
        int index = k.hashCode() % bucketSize;
        LinkedList<MyEntry<K, V>> list = bucket[index];

        boolean newKey = true;
        for(MyEntry me : list){
            if(me.key.equals(k)) {
                me.value = v;
                newKey = false;
                break;
            }
        }
        if(newKey)
            list.add(new MyEntry<K,V>(k, v));
    }

    public boolean containsKey(K k){
        int index = k.hashCode() % bucketSize;
        LinkedList<MyEntry<K, V>> list = bucket[index];

        for(MyEntry me : list) {
            if(me.key.equals(k)){
                return true;
            }
        }
        return false;
    }

    public void remove(K k){
        int index = k.hashCode() % bucketSize;
        LinkedList<MyEntry<K, V>> list = bucket[index];

        for(MyEntry me : list){
            if(me.key.equals(k)){
                list.remove(me);
            }
        }
    }


    @Override
    public String toString() {
        return "MyHashMap{" +
                "bucket=" + Arrays.toString(bucket) +
                ", bucketSize=" + bucketSize +
                '}';
    }
}
