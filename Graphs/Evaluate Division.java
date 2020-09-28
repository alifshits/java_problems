class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var res = new double[queries.size()];
        var variables = new HashSet<String>();
        
         for (var i = 0; i < equations.size(); ++i) {
            var eq = equations.get(i);
            variables.add(eq.get(0));
            variables.add(eq.get(1));
        }
        
        for (var i = 0; i < queries.size(); ++i) {
            res[i] = calcEquationInternal(equations, values, queries.get(i), variables);
        }
        
        return res;
    }
    
    private static double calcEquationInternal(
        List<List<String>> equations, double[] values, List<String> query, HashSet<String> variables) {
        
        String from = query.get(0), to = query.get(1);
        
        if (!variables.contains(from) || !variables.contains(to)) {
            return -1.0;
        }
        
        var q = new LinkedList<Pair<String, Double>>();
        var visited = new HashSet<String>();
        
        q.offer(new Pair(from, 1.0));
        visited.add(from);
        
        while (q.size() > 0) {
            var pair = q.pop();
            var key = pair.getKey();
            var value = pair.getValue();
            if (key.equals(to)) {
                return value;
            }
            
           for (var i = 0; i < equations.size(); ++i) {
               var eq = equations.get(i);
               var first = eq.get(0);
               var second = eq.get(1);
               
               if (first.equals(key) && !visited.contains(second)) {
                   visited.add(second);
                   q.offer(new Pair(second, value * values[i]));
               }
               
               if (second.equals(key) && !visited.contains(first)) {
                   visited.add(second);
                   q.offer(new Pair(first, value / values[i]));
               }
           }                
        }
        
        return -1.0;
    }
}