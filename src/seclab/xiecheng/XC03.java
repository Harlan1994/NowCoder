package seclab.xiecheng;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/4
 * Time: 19:34
 * Description:
 */
public class XC03 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        LRU<String, Integer> lru = new LRU<>(capacity);
        while (scanner.hasNextLine()) {
            String ops[] = scanner.nextLine().split(" ");
            if (ops[0].equals("p")) {
                String key = ops[1];
                Integer value = Integer.parseInt(ops[2]);
                lru.put(key.toString(), value);
            } else {
                String key = ops[1];
                Integer value = lru.get(key.toString());
                if (value == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(value);
                }
            }
        }
    }

    public static class LRU<K, V> {

        private LinkedHashMap<K, V> map;
        private int cacheSize;

        public LRU(int cacheSize) {
            this.cacheSize = cacheSize;
            map = new LinkedHashMap<K, V>(cacheSize, 1f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > LRU.this.cacheSize;
                }
            };
        }

        public V get(K key) {
            return map.get(key);
        }

        public void put(K key, V value) throws NoSuchFieldException, IllegalAccessException {
            if (map.containsKey(key)) { // 如果存在，那么不算一次access

//                Field accessOrder = map.getClass().getDeclaredField("accessOrder");
                Field accessOrder = LinkedHashMap.class.getDeclaredField("accessOrder");
//                Field modifier = Field.class.getDeclaredField("modifiers");
//                modifier.setAccessible(true);
//                modifier.set(accessOrder, accessOrder.getModifiers() & ~FINAL);

                if (!accessOrder.isAccessible()) {
                    accessOrder.setAccessible(true);
                }
                Boolean newValue = new Boolean(false);
                accessOrder.set(map, newValue);
                map.put(key, value);
                Boolean oldValue = new Boolean(false);
                accessOrder.set(map, oldValue);
            } else {
                map.put(key, value);
            }
        }
    }
}
