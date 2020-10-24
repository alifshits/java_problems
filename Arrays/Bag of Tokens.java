class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        var score = 0;
        var nextToken = 0;
        var lastToken = tokens.length - 1;
        
        Arrays.sort(tokens);
        
        while (nextToken <= lastToken) {
            if (tokens[nextToken] <= P) {
                P -= tokens[nextToken];
                ++nextToken;
                ++score;
                continue;
            }
            
            if (score > 0 && lastToken != nextToken && P + tokens[lastToken] >= tokens[nextToken]) {
                P += tokens[lastToken];
                --lastToken;
                --score;
                continue;
            }
            
            break;
        }
        
        return score;
    }
}