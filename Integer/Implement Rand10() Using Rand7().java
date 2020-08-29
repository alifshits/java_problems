/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            var r = rand7();
            var c = rand7();
            
            var x = (r - 1) * 7 + c;
            
            if (x > 40) continue;
        
            return ((x - 1) % 10) + 1;
        }
    }
}