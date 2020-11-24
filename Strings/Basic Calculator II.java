class Solution {
    public int calculate(String s) {        
        var expression = parse(s);
        return solve(expression);
    }
    
    private static ArrayList<Op> parse(String s) {
        var expression = new ArrayList<Op>();
        var operations = new Stack<Op>();     
        var i = 0;
        
        while (i < s.length()) {
            var c = s.charAt(i);
            
            if (c == ' ') {
                ++i;
                continue;
            }
            
            if (c >= '0' && c <= '9') {
                var num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    ++i;
                }
                
                expression.add(new Op(num));
                continue;
            }
            
            var op = new Op(c);
            
            while (operations.size() > 0 && op.priority <= operations.peek().priority) {                
                expression.add(operations.pop()); 
            }
            
            operations.push(new Op(c));
            ++i;            
        }
                
        while (operations.size() > 0) {
            expression.add(operations.pop());
        }
        
        return expression;
    }
                
    private static int solve(ArrayList<Op> expression) {
        if (expression.size() == 0) {
            return 0;
        }
        
        var operands = new Stack<Integer>();
        
        for (var op : expression) {
            if (!op.isOperation) {
                operands.push(op.value);
                continue;
            }
            
            var s = operands.pop();
            var f = operands.pop();
            
            switch (op.operation) {
                case '+': operands.push(f + s); break;
                case '-': operands.push(f - s); break;
                case '*': operands.push(f * s); break;
                case '/': operands.push(f / s); break;
            }
        }
        
        return operands.pop();
    }
    
    private static final class Op {
        public final int value;
        public final char operation;
        public final boolean isOperation;
        public final int priority;
        
        public Op(int value) {
            this.value = value;
            this.operation = 0;
            this.isOperation = false;
            this.priority = -1;
        }
           
        public Op(char operation) {
            this.value = 0;
            this.operation = operation;
            this.isOperation = true;
            this.priority = operation == '+' || operation == '-' ? 0 : 1;
        }
    }
}