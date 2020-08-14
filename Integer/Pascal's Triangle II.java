class Solution {
    public List<Integer> getRow(int rowIndex) {
        var row = new ArrayList<Integer>();
        row.add(1);
        
        for (var i = 1; i <= rowIndex; ++i) {
            var next = new ArrayList<Integer>();
            next.add(1);
            
            for (var j = 0; j < i - 1; ++j) {
                next.add(row.get(j) + row.get(j + 1));
            }
                
            next.add(1);
            
            row = next;
        }
        
        return row;
    }
}