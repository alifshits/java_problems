class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var result = new ArrayList<Integer>(numCourses);
        var state = new int[numCourses];
        var map = new HashMap<Integer, ArrayList<Integer>>();
        
        for (var pair : prerequisites) {
            var list = map.get(pair[1]);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(pair[1], list);
            }
            
            list.add(pair[0]);
        }        
        
        for (var i = 0; i < numCourses; ++i) {
            if (!Explore(i, map, state, result)) 
                return new int[0];
        }
        
        var arr = new int[numCourses];      
        for (var i = 0; i < numCourses; ++i) {
            arr[i] = result.get(i);
        }
        
        return arr;
    }
    
    private static boolean Explore(
        int course, 
        HashMap<Integer, 
        ArrayList<Integer>> map, 
        int[] state, 
        ArrayList<Integer> result) {
        
        if (state[course] == 2) return true;
        
        if (state[course] == 1) return false;
        
        state[course] = 1;
        
        var list = map.get(course);
        if (list != null) {
            for (var c : list) {
                if (!Explore(c, map, state, result)) 
                    return false;
            }
        }
        
        state[course] = 2;
        
        result.add(0, course);
        
        return true;
    }
}