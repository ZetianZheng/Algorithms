class TrieNode {
    // trie node 主要记录node的孩子信息 和是否该节点是一个单词的结尾
    // https://leetcode.com/problems/implement-trie-prefix-tree/solution/
    private TrieNode[] children;
    
    private final int R = 26;
    
    private boolean isEnd; // 该节点是否是一个word的结尾
    
    public TrieNode() {
        children = new TrieNode[R]; // 构建孩子列表
    }
    
    // 是否有这个char的孩子
    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }
    
    // 获得这个孩子节点
    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }
    
    // 生成这个孩子节点
    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(); // 生成一个新的树根。
    }
    
    /** Inserts a word into the trie. time: O(M), M is the key length, space: O(M)*/
    public void insert(String word) {
        TrieNode node = root;
        for (char ch:word.toCharArray()) { 
            if (!node.containsKey(ch)) { // 对每一个字符如果没有孩子节点，那么则创建它。
                TrieNode child = new TrieNode();
                node.put(ch, child);
            }
            
            node = node.get(ch); // 切换到这个孩子
        }
        
        node.setEnd(); // word最后一个字符设置为end
    }
    
    
    public TrieNode searchPrefix(String word) { // 搜索是否有这个前缀。
        TrieNode node = root;
        for (char ch:word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        
        return node;
    }
    /** Returns if the word is in the trie. time complexity: O(M) M is the key length.*/
    public boolean search(String word) {
        TrieNode cur = searchPrefix(word);
        return cur != null && cur.isEnd(); // 有这个前缀且是end，那么字典树存放这个word。
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */