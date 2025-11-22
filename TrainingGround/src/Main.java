import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class SimpleHashTable<K,V>{
    private static final int DEFAULT_CAPACITY = 100;
    private List<List<Entry<K,V>>> table;

    public SimpleHashTable() {
        table = new ArrayList<>(DEFAULT_CAPACITY);
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table.add(new ArrayList<>());
        }
    }

    private int hash(K key){
        int hash = Math.abs(Objects.hashCode(key));
        return hash%DEFAULT_CAPACITY;
    }

    public void put(K key, V value){
        int hash = hash(key);
        List<Entry<K,V>> chain = table.get(hash);
        for (Entry<K,V> e:chain){
            if(e.key.equals(key)){
                e.value = value; // чтобы дупликаты не закидывать
                return;
            }

        }
        chain.add(new Entry<>(key,value));
    }

    public V get(K key){
        int hash = hash(key);
        List<Entry<K,V>> chain = table.get(hash);
        for (Entry<K,V> e:chain){
            if(e.key.equals(key)){
                return e.value;
            }

        }
        return null;
    }

    public static class Entry<K,V> {
        K key;
        V value;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return key + " = " +value;
        }


    }
}

public class Main {

    public static void main(String[] args) {
        SimpleHashTable<String,Integer> table = new SimpleHashTable<>();
        table.put("banana",1);
        table.put("banana1",2);
        table.put("banana2",3);
        System.out.println(table.get("banana"));
        System.out.println(table.get("apple"));
    }
}