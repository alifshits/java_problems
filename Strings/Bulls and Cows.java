class Solution {
    public String getHint(String secret, String guess) {
        var b = 0;
        var c = 0;
        var map = new HashMap<Character, ArrayList<Integer>>();
        
        for (var i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++b;
            } else {
                var list = map.computeIfAbsent(secret.charAt(i), k -> new ArrayList<Integer>());
                list.add(i);
            }
        }
        
        for (var i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) != guess.charAt(i)) {
                var list = map.get(guess.charAt(i));
                if (list != null && list.size() > 0) {
                    ++c;
                    
                    if (list.size() > 1) {
                        list.remove(list.size() - 1); 
                    } 
                    else {
                        map.remove(guess.charAt(i));
                    }
                }
            }
        }
        
        return b + "A" + c + "B";
    }
}