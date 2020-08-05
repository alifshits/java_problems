class WordDictionary {
    private final Trie trie = new Trie();

    public WordDictionary() {
    }
    
    public void addWord(String word) {
        trie.add(word, 0);
    }
    
    public boolean search(String word) {
        return trie.search(word, 0);
    }
    
    class Trie {
        private final Trie[] tries = new Trie[26];
        
        private boolean isEnd;
        
        public void add(String word, int i) {
            if (i == word.length()) {
                isEnd = true;
                return;
            }
            
            var idx = word.charAt(i) - 'a';
            if (tries[idx] == null) {
                tries[idx] = new Trie();
            }
            
            tries[idx].add(word, i + 1);
        }
        
        public boolean search(String word, int i) {
            if (i == word.length()) {
                return isEnd;
            }
            
            var letter = word.charAt(i);
            if (letter == '.') {
                for (var t : tries) {
                    if (t != null) {
                        var res = t.search(word, i + 1);
                        if (res) return res;
                    }
                }
                
                return false;
            } else {
                var t = tries[letter - 'a'];
                if (t == null) return false;
                
                return t.search(word, i + 1);
            }
        }
    }
}