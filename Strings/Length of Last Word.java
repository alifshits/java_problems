class Solution {
    public int lengthOfLastWord(String s) {
        var spaceIdx = -1;
        var lastLetterIdx = -1;
        for (var i = s.length() - 1; i >= 0; --i) {
            var ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                if (lastLetterIdx == -1) {
                    lastLetterIdx = i;
                }
                continue;
            }
            
            if (lastLetterIdx != -1) {
                spaceIdx = i;
                break;
            }
        }
        
        if (lastLetterIdx == -1) {
            return 0;
        }
        
        if (spaceIdx > lastLetterIdx) {
            return lastLetterIdx;
        }
        
        return spaceIdx == -1 ? lastLetterIdx + 1 : lastLetterIdx - spaceIdx;
    }
}