class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        var maxRank = 0;        
        var roadsMap = new HashMap<Integer, HashSet<Integer>>();
        
        for (var road : roads) {            
            var set = roadsMap.computeIfAbsent(road[0], k -> new HashSet<Integer>());
            set.add(road[1]);
            
            set = roadsMap.computeIfAbsent(road[1], k -> new HashSet<Integer>());
            set.add(road[0]);
        }
        
        for (var i = 0; i < n; ++i) {
            for (var j = i + 1; j < n; ++j) {
                var rank = getRank(i, j, roadsMap);
                maxRank = Math.max(maxRank, rank);
            }
        }
        
        return maxRank;
    }
    
    private static int getRank(int f, int s, HashMap<Integer, HashSet<Integer>> roads) {
        var roadsF = roads.get(f);
        var roadsS = roads.get(s);
        
        var res = (roadsF != null ? roadsF.size() : 0) + (roadsS != null ? roadsS.size() : 0);
        if (roadsF != null && roadsF.contains(s) && roadsS != null && roadsS.contains(f)) {
            --res;
        }
        
        return res;
    }
}