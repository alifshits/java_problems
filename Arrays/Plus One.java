class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return new int[] { 1 };
        
        digits[digits.length - 1] += 1;
        
        var hasCarry = false;
        
        for (var i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 10) break;
            
            digits[i] = 0;
            if (i - 1 >= 0)
                digits[i - 1] += 1;
            else
              hasCarry = true;  
        }
        
        if (hasCarry) {
            var res = new int[digits.length + 1];
            res[0] = 1;
            
            for (var i = 1; i < res.length; ++i)
                res[i] = digits[i - 1];
            
            return res;
        }
        
        return digits;
    }
}