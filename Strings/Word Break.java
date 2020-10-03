class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        var trie = new Trie();
        var cache = new HashSet<Integer>();
        
        for (var w : wordDict) {
            trie.add(w, 0);
        }
        
        return wordBreak(s, 0, trie, trie, cache);
    }
    
    private static boolean wordBreak(String s, int i, 
        Trie main, Trie current, 
        HashSet<Integer> cache) {
        
        if (i == s.length()) {
            return true;
        }

        if (cache.contains(i)) {
            return false;
        }
        
        while (i < s.length()) {
            current = current.get(s.charAt(i));
            if (current == null) {
                return false;
            }
            
            if (current.getIsEndOfWord()) {
                if (wordBreak(s, i + 1, main, main, cache)) {
                    return true;
                }
                else {
                    cache.add(i + 1);
                }
            }
            
            ++i;
        }
        
        return false;
    }
    
    private static final class Trie {
        private Trie[] tries = new Trie[26];    
        private boolean isEndOfWord = false;
        
        public void add(String s, int i) {
            if (i == s.length()) {
                isEndOfWord = true;
                return;
            }
            
            var idx = s.charAt(i) - 'a';
            if (tries[idx] == null) {
                tries[idx] = new Trie();
            }
            
            tries[idx].add(s, i + 1);
        }
        
        public Trie get(Character c) {
            return tries[c - 'a'];
        }
        
        public boolean getIsEndOfWord() {
            return isEndOfWord;
        }
    }
}