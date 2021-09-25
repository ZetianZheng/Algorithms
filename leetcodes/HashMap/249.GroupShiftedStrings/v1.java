class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        // 时间复杂度： O(n * len)
        // 空间复杂度：O(n)
        // 使用hashmap， 将每一个字符串开头第一个shift到'a'开头的字符串之后用hashmap来记录。
        Map<String, List<String>> map = new TreeMap<>(); // 使用treeMap 来记录所有的可以shift的字符串（保留字典序）
        for(String str : strings) {
            int x = str.charAt(0) - 'a'; // 首字符向左平移量
            String tmp = "";
            for (int j = 0; j < str.length(); j++) { // count all shift for all character
                char c = (char)(str.charAt(j) - x);
                c = c < 'a' ? (char)(c + 26) : c; // 修正左移后小于a的情况。
                tmp += c;
            }
            
            if (!map.containsKey(tmp))
                map.put(tmp, new ArrayList<String>());
            map.get(tmp).add(str);
        }
        List<List<String>> ret = new ArrayList<>();
        for(String key : map.keySet()) {
            ret.add(map.get(key));
        }
        
        return ret;
    }
}
