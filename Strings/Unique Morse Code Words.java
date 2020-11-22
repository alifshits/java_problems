class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        var map = new String[] {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
            "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        
        var set = new HashSet<String>(words.length);
        var sb = new StringBuilder(12);
        
        for (var w : words) {
            for (var i = 0; i < w.length(); ++i) {
                sb.append(map[w.charAt(i) - 'a']);
            }
            
            set.add(sb.toString());
            sb.setLength(0);
        }
        
        return set.size();
    }
}