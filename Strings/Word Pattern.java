class Solution {
    public boolean wordPattern(String pattern, String str) {
        var letterToWords = new HashMap<Character, String>();
        var wordsToLetters = new HashMap<String, Character>();
        var words = str.split("\\s");
        var currentWord = 0;
        
        if (words.length != pattern.length()) {
            return false;
        }
        
        for (var i = 0; i < pattern.length(); ++i) {
            if (currentWord == words.length) {
                return false;
            }
            
            var letter = pattern.charAt(i);
            var word = words[currentWord];     
            
            var assignedLetter = wordsToLetters.get(word);
            if (assignedLetter == null) {
                wordsToLetters.put(word, letter);
            }
            else if (assignedLetter != letter) {
                return false;
            }            
  
            var assignedWord = letterToWords.get(letter);
            if (assignedWord == null) {
                letterToWords.put(letter, word);
            }
            else if (!assignedWord.equals(word)) {
                return false;
            }
            
            ++currentWord;
        }
        
        return true;
    }
}