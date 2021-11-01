class Data {
    int timestamp;
    String value;
    public Data(int time, String v) {
        this.timestamp = time;
        this.value = v;
    }
}

class TimeMap {
    Map<String, List<Data>> keyTimeMap;
    /** Initialize your data structure here. */
    public TimeMap() {
        this.keyTimeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Data timeValue = new Data(timestamp, value);
        // if (!keyTimeMap.containsKey(key))
        //     keyTimeMap.put(key, new ArrayList<>());
        keyTimeMap.putIfAbsent(key, new ArrayList<>());
        keyTimeMap.get(key).add(timeValue);
    }
    
    public String get(String key, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            return new String("");
        }
        // if keyTimeMap has this key, then just use binary search to find the lastest timestamp.
        String value = binarySearch(keyTimeMap.get(key), timestamp);
        return value;
    }
    
    private String binarySearch(List<Data> list, int timestamp) {
        if (list == null) {
            return "";
        }
        
        int start = 0, end = list.size() - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (list.get(mid).timestamp < timestamp) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (list.get(end).timestamp <= timestamp) {
            return list.get(end).value;
        }
        if (list.get(start).timestamp <= timestamp) {
            return list.get(start).value;
        }
        
        return "";  
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */