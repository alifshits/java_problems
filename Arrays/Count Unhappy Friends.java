class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        var cnt = 0;
        var fToP = new int[n];
        
        for (var i = 0; i < pairs.length; ++i) {
            fToP[pairs[i][0]] = i;
            fToP[pairs[i][1]] = i;
        }
        
        for (var i = 0; i < n; ++i) {
            var pair = pairs[fToP[i]];
            var partner = pair[0] != i ? pair[0] : pair[1];
            
            for (var j = 0; j < preferences[i].length; ++j) {
                if (preferences[i][j] == partner) {
                    break;
                }
                
                var partnerPair = pairs[fToP[preferences[i][j]]];
                var partnerPartner = partnerPair[0] != preferences[i][j] ? partnerPair[0] : partnerPair[1];
                
                var unhappy = false;
                
                for (var k = 0; k < preferences[preferences[i][j]].length; ++k) {
                    if (preferences[preferences[i][j]][k] == partnerPartner) {
                        break;
                    }
                    
                    if (preferences[preferences[i][j]][k] == i) {
                        unhappy = true;
                        break;
                    }
                }
                
                if (unhappy) {
                    ++cnt;
                    break;
                }
            }
        }
        
        return cnt;
    }
}