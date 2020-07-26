class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var maxFreq = 0;
        var intToFreq = new HashMap<Integer, Integer>();
        var freqToInt = new HashMap<Integer, ArrayList<Integer>>();
        var res = new int[k];
        var i = 0;
        
        for (var num : nums) {
            var freq = intToFreq.getOrDefault(num, 0) + 1;
            intToFreq.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        
        for (var entry : intToFreq.entrySet()) {
            var list = freqToInt.get(entry.getValue());
            if (list == null) {
                list = new ArrayList<Integer>();
                freqToInt.put(entry.getValue(), list);
            }
            
            list.add(entry.getKey());
        }
        
        for (var f = maxFreq; f > 0; --f) {
            if (i == k) break;
            
            var list = freqToInt.get(f);
            if (list == null) continue;
            
            for (var num : list) {
                if (i == k) break;
                res[i++] = num;
            }
        }
        
        return res;
    }
}