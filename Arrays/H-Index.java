class Solution {
    public int hIndex(int[] citations) { 
        Arrays.sort(citations);
                
        for (var i = citations.length; i >= 1; --i)
        {
            var h = i;
            var greaterOrEqualCnt = i;
            var lessOrEqualCnt = citations.length - h;
            
            if (citations[citations.length - greaterOrEqualCnt] >= h && 
                (lessOrEqualCnt == 0 || citations[lessOrEqualCnt - 1] <= h))
            {
                return h;
            }         
        }
        
        return 0;
    }
}