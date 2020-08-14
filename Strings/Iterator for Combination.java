class CombinationIterator {

    private final ArrayList<String> list = new ArrayList<String>();
    private int idx = 0;
    
    public CombinationIterator(String characters, int combinationLength) {
        var top = (int)Math.pow(2, characters.length()) - 1;
        var sb = new StringBuilder(combinationLength);

        for (var i = top; i >= 1; --i) {
            if (Integer.bitCount(i) == combinationLength) {
                sb.setLength(0);

                for (var j = characters.length() - 1; j >= 0; --j) {
                    if ((i & (1 << j)) != 0) {
                        sb.append(characters.charAt(characters.length() - 1 - j));
                    }
                }

                list.add(sb.toString());
            }
        }
    }
    
    public String next() {
        return list.get(idx++);
    }
    
    public boolean hasNext() {
        return idx < list.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */