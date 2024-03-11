import java.util.*;

class Solution {
    public long solution(String expression) {
        String[][] cal = {
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*-+".split(""),
            "*+-".split("")
        };
        
        long[] result = new long[6];
        
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(expression, String.join("", cal[i]), true);
            List<String> tokens = new ArrayList<>();
            
            while (st.hasMoreTokens()) {
                tokens.add(st.nextToken());
            }
            
            for (String c : cal[i]) {
                while (tokens.indexOf(c) != -1) {
                    int idx = tokens.indexOf(c);
                    String num = String.valueOf(calculate(tokens.get(idx - 1), tokens.get(idx + 1), c));
                    
                    tokens.remove(idx - 1);
                    tokens.remove(idx - 1);
                    
                    tokens.set(idx - 1, num);
                }
                
                result[i] = Math.abs(Long.parseLong(tokens.get(0)));
            }
        }
        
        return Arrays.stream(result).max().getAsLong();
    }
    
    public static long calculate(String x, String y, String o) {
        switch (o) {
            case "+":
                return Long.parseLong(x) + Long.parseLong(y);
            case "-":
                return Long.parseLong(x) - Long.parseLong(y);
            case "*":
                return Long.parseLong(x) * Long.parseLong(y);
            default:
                return 0;
        }
    }
}