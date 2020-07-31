class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        
        var t = 0;       
        var groupedTasks = groupTasks(tasks);
        var pq = new PriorityQueue<Character>(
            groupedTasks.length, 
            (t1, t2) -> groupedTasks[t2 - 'A'] - groupedTasks[t1 - 'A'] );
        
        for (var i = 0; i < groupedTasks.length; ++i) {
            if (groupedTasks[i] > 0) {
                pq.offer((char)('A' + i));
            }            
        }
        
        var times = new HashMap<Character, Integer>();
        var tmpTasks = new ArrayList<Character>(groupedTasks.length);
        
        while (pq.size() > 0) {
            
            tmpTasks.clear();
            
            while (pq.size() > 0) {
                var task = pq.poll();
                var prevTime = times.get(task);

                if (prevTime == null || t - prevTime > n) {
                    groupedTasks[task - 'A'] -= 1;
                    if (groupedTasks[task - 'A'] > 0) {
                        pq.offer(task);
                    }              
                    times.put(task, t);
                    break;
                } else {
                    tmpTasks.add(task);
                }
            }
            
            for (var tmp : tmpTasks) {
                pq.offer(tmp);
            }
            
            ++t;
        }
    
        return t;
    }
    
    private static int[] groupTasks(char[] tasks) {
        var counts = new int[26];
        
        for (var t : tasks) {
            counts[t - 'A'] += 1;
        }
        
        return counts;
    }
}