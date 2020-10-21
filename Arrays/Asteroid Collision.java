class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        var i = asteroids.length - 1;
        var stack = new Stack<Pair<Integer, Integer>>();
        var dead = 0;
        
        while (i >= 0) {
            if (asteroids[i] > 0) {
                if (stack.size() == 0) {
                    --i;
                    continue;
                }
                var a = stack.peek();
                if (asteroids[i] == a.getKey()) {
                    stack.pop();
                    asteroids[i] = 0;
                    asteroids[a.getValue()] = 0;
                    dead += 2;
                    --i;
                }
                else if (asteroids[i] > a.getKey()) {
                    stack.pop();
                    asteroids[a.getValue()] = 0;   
                    ++dead;
                }
                else {
                    asteroids[i] = 0;
                     ++dead;
                    --i;
                }
            }
            else {
                stack.push(new Pair<>(-1 * asteroids[i], i));
                --i;
            }
        }        
        
        var res = new int[asteroids.length - dead];
        var j = 0;
        for (var a : asteroids) {
            if (a != 0) {
                res[j++] = a;
            }
        }
        
        return res;
    }
}