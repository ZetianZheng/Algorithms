class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
         this.map = new HashMap<>();
    }
    
    // O(1)
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    // O(logn)
    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        TreeMap<Integer, String> timeMap = map.get(key);
        Integer latestTime = timeMap.floorKey(timestamp);
        if (latestTime == null)
            return "";

        return timeMap.get(latestTime);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */public class v2 {
     
 }
 