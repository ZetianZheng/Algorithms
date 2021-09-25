class TrieNode {
    Map<Character, TrieNode> childrens = new HashMap<>(); // childrens of trie tree, key is the character, value is another TrieNode.
    boolean isWord = false; // isWord true means that a word ends by this character.
    public TrieNode(){}
}
class WordDictionary { // 构建一个树
    // 字典树 tire tree
    TrieNode trie;
    
    public WordDictionary() {
        trie = new TrieNode(); // 生成一个空字典树。    
    }
    
    public void addWord(String word) { // 字典树创建函数, time complexity: O(M) M is the length of key
        TrieNode node = trie;
        for (char ch : word.toCharArray()) {
            if (!node.childrens.containsKey(ch)) {
                node.childrens.put(ch, new TrieNode());
            } 
                
            node = node.childrens.get(ch); // 下一个子节点
        }
        
        node.isWord = true; // 在结束的时候说明这是一个字的尾部，将其设为true
    }

    // dfs 
    public boolean searchInTrie(String word, TrieNode node) { // 寻找字典树，输入当前的word和当前的node
        for (int i = 0; i < word.length(); i++) { // 找word里的每一个字母
            char ch = word.charAt(i);
            if (!node.childrens.containsKey(ch)) { // 如果childrens不包含这个字母，那么看它是否是.
                if (ch == '.') { // 如果是dots，那么遍历当前层的所有可能，这一步最多26次。（因为只有26个字母）
                    //
                    for (char x : node.childrens.keySet()) {
                        TrieNode child = node.childrens.get(x);
                        if (searchInTrie(word.substring(i+1), child)) { // dfs下一层
                            return true;
                        }
                    }
                }
                
                return false; // 如果不是点又于当前match不上则false
            } else {
                node = node.childrens.get(ch);
            }
        }
        
        return node.isWord;
    }
    
    public boolean search(String word) {
        return searchInTrie(word, trie);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
