class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // hashmap + two pointers
        // using size of hashmap to control two distinct char
        HashMap<Character, Integer> map = new HashMap<>(); // char : most right index
        int l = 0, r = 0;
        int ans = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.size() <= 2) {
                map.put(c, r++);
            }       
            
            if (map.size() > 2) { // remove extra ele, if size bigger than 2.
                int left = s.length();
                for (int ind : map.values()) {
                    left = Math.min(ind, left); // find left most extra element
                }
                
                map.remove(chars[left]); // remove extra element in map.
                l = left + 1; // update l, sliding window
            }

            ans = Math.max(ans, r - l);
        }
        
        return ans;
    }
}