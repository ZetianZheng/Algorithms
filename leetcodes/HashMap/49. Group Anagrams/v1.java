class v1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 所有的字符串都转换为字典序，然后用hashmap来进行分组
        Map<String, List<String>> map = new TreeMap<>();
        // Map<String, List<String>> map = new HashMap<>();
        
        // List<List<String>> ret = new ArrayList<>();
        
        for (String str : strs) { // O(m)
            char[] chrs = str.toCharArray();
            Arrays.sort(chrs); // O(nlogn)
            String key = String.valueOf(chrs); // char array -> string
            if (!map.containsKey(key)) // hashMap: O(1), TreeMap: O(logm)
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        
        // for (String key : map.keySet()) {
        //     ret.add(map.get(key));
        // }
        
        return new ArrayList<>(map.values());
    }
}