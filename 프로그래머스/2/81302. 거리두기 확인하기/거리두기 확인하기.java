class Solution {
    private static final int[][] one = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int[][] two = {{2, 0, 1, 0}, {0, 2, 0, 1}, {-2, 0, -1, 0}, {0, -2, 0, -1}};
    private static final int[][] dg = {{-1, -1, -1, 0, 0, -1}, {1, -1, 0, -1, 1, 0}, {1, 1, 1, 0, 0, 1}, {-1, 1, -1, 0, 0, 1}};
    
    public int[] solution(String[][] places) {        
        int[] results = new int[places.length];
        int idx = 0;
        
        for (String[] place : places) {
            // setting
            String[][] rooms = new String[5][5];
            
            for (int i = 0; i < place.length; i++) {
                rooms[i] = place[i].split("");
            }
            
            // check
            if (check(rooms)) {
                results[idx++] = 1;
            } else {
                results[idx++] = 0;
            }
        }
        
        return results;
    }
    
    private boolean check(String[][] rooms) {
        for (int col = 0; col < rooms.length; col++) {
            for (int row = 0; row < rooms[0].length; row++) {
                if (rooms[col][row].equals("P")) {  // 사람 발견
                    // 1. 거리 1 체크
                    if (!checkOne(rooms, col, row)) return false;
                    
                    // 2-1. 거리 2 체크
                    if (!checkTwo(rooms, col, row)) return false;
                    
                    // 2-2. 대각 체크
                    if (!checkDG(rooms, col, row)) return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean checkOne(String[][] rooms, int col, int row) {
        for (int[] d : one) {
            int compCol = col + d[0];
            int compRow = row + d[1];
            
            if (compCol < 0 || compCol >= 5 || compRow < 0 || compRow >= 5) continue;
            
            if (rooms[compCol][compRow].equals("P")) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean checkTwo(String[][] rooms, int col, int row) {
        for (int[] d : two) {
            int compCol = col + d[0];
            int compRow = row + d[1];
            
            if (compCol < 0 || compCol >= 5 || compRow < 0 || compRow >= 5) continue;
            
            if (rooms[compCol][compRow].equals("P")) {
                int checkCol = col + d[2];
                int checkRow = row + d[3];
                
                if (!rooms[checkCol][checkRow].equals("X")) {   // 파티션이 아니면
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean checkDG(String[][] rooms, int col, int row) {
        for (int[] d : dg) {
            int compCol = col + d[0];
            int compRow = row + d[1];
            
            if (compCol < 0 || compCol >= 5 || compRow < 0 || compRow >= 5) continue;
            
            if (rooms[compCol][compRow].equals("P")) {
                int checkCol1 = col + d[2];
                int checkRow1 = row + d[3];
                
                int checkCol2 = col + d[4];
                int checkRow2 = row + d[5];
                
                if (!(rooms[checkCol1][checkRow1].equals("X") && rooms[checkCol2][checkRow2].equals("X"))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}