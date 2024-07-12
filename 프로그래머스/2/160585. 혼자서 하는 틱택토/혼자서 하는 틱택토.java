class Solution {
    private int oCount = 0;
    private int xCount = 0;
    private String[][] map = new String[3][3];
    
    public int solution(String[] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String c = board[i].substring(j, j + 1);
                
                if (c.equals("X")) xCount++;
                else if (c.equals("O")) oCount++;
                
                map[i][j] = c;
            }
        }
        
        if (oCount == xCount + 1) {
            if (isStraight("XXX")) return 0;
            return 1;
        } else if (oCount == xCount) {
            if (isStraight("OOO")) return 0;
            return 1;
        } else {
            return 0;
        }
    }
    
    private boolean isStraight(String target) {
        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < 3; j++) {
                sb.append(map[i][j]);
            }
            
            // string builder에서 동등 비교 시 toString으로 문자열로 바꾼 뒤 비교할 것!
            if (sb.toString().equals(target)) return true;
        }
        
        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < 3; j++) {
                sb.append(map[j][i]);
            }
            
            if (sb.toString().equals(target)) return true;
        }
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb1.append(map[i][i]);
            sb2.append(map[i][2 - i]);
        }
        if (sb1.toString().equals(target)) return true;
        if (sb2.toString().equals(target)) return true;
        
        return false;
    }
}