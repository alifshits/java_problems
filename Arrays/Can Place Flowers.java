class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        var prevOne = -2;
        for (var i = 0; i < flowerbed.length && n > 0; ++i) {
            if (flowerbed[i] == 1) {
                prevOne = i;
            }
            else if (i - prevOne == 2 && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
                --n;
                prevOne = i;
            }
        }
        
        return n == 0;
    }
}