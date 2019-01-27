import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        String res = "";

        if (treeMap != null) {
            Integer n = treeMap.floorKey(timestamp);
            if (n != null) {
                res = treeMap.get(n);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TimeMap kv = new TimeMap();
        kv.set("love", "high", 10); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
        kv.set("love", "low", 20); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
        System.out.println(kv.get("love", 5));
        System.out.println(kv.get("love", 10));
        System.out.println(kv.get("love", 15));
        System.out.println(kv.get("love", 20));
        System.out.println(kv.get("love", 25));
    }
}