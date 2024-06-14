import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }
        
        int[] answer = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int sCol = query[0] - 1;
            int sRow = query[1] - 1;
            int eCol = query[2] - 1;
            int eRow = query[3] - 1;
            // int sRow = query[0] - 1;
            // int sCol = query[1] - 1;
            // int eRow = query[2] - 1;
            // int eCol = query[3] - 1;
            
            List<Integer> tmp = new ArrayList<>();
            for (int i = sRow; i < eRow; i++) {
                tmp.add(map[sCol][i]);
            }
            for (int i = sCol; i < eCol; i++) {
                tmp.add(map[i][eRow]);
            }
            for (int i = eRow; i > sRow; i--) {
                tmp.add(map[eCol][i]);
            }
            for (int i = eCol; i > sCol; i--) {
                tmp.add(map[i][sRow]);
            }
            
            answer[idx++] = Collections.min(tmp);
            
            tmp.add(0, tmp.get(tmp.size() - 1));
            tmp.remove(tmp.size() - 1);
            
            int index = 0;
            for (int i = sRow; i < eRow; i++) {
                map[sCol][i] = tmp.get(index++);
            }
            for (int i = sCol; i < eCol; i++) {
                map[i][eRow] = tmp.get(index++);
            }
            for (int i = eRow; i > sRow; i--) {
                map[eCol][i] = tmp.get(index++);
            }
            for (int i = eCol; i > sCol; i--) {
                map[i][sRow] = tmp.get(index++);
            }
        }
        
        return answer;
    }
}