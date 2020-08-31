class StreamChecker {

    private final Trie trie;
    
    private final StringBuilder query;
    
    public StreamChecker(String[] words) {
        trie = new Trie();
        
        for (var w : words) {
            trie.add(w, w.length() - 1);
        }
        
        query = new StringBuilder();
    }
    
    public boolean query(char letter) {
        query.insert(0, letter);
        return trie.contains(query, 0);
    }
    
    private final class Trie {
        private final Trie[] tries = new Trie[26];
        
        private boolean isEnd;
        
        public void add(String word, int i) {
            if (isEnd) {
                return;
            }
            
            if (i == -1) {
                isEnd = true;
                return;
            }
            
            var c = word.charAt(i);
            
            if (tries[c - 'a'] == null) {
                tries[c - 'a'] = new Trie();
            }

            tries[c - 'a'].add(word, i - 1);
        }
        
        public boolean contains(StringBuilder query, int i) {
            if (i == query.length()) {
                return isEnd;
            }
            
            var c = query.charAt(i);
            if (tries[c - 'a'] == null) {
                return false;
            }
            
            if (tries[c - 'a'].isEnd) {
                return true;
            }
            
            return tries[c - 'a'].contains(query, i + 1);
        }
    }
}
