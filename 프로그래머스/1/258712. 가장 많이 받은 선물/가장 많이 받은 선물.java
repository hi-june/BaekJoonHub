import java.util.*;

class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private Map<String, Integer> history = new HashMap<>();
    private Map<String, List<Integer>> status = new HashMap<>();
    private int[][] board;
    
    public int solution(String[] friends, String[] gifts) {
        board = new int[friends.length][friends.length];
        
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
            board[i][i] = -1;
        }
        
        for (String g : gifts) {
            int from = map.get(g.split(" ")[0]);
            int to = map.get(g.split(" ")[1]);
            
            board[from][to] += 1;
        }
        
        for (String f : friends) {
            int idx = map.get(f);
            
            int give = 0;
            for (int i = 0; i < friends.length; i++) {
                if (i == idx) continue;
                
                give += board[idx][i];
            }
            
            int get = 0;
            for (int i = 0; i < friends.length; i++) {
                if (i == idx) continue;
                
                get += board[i][idx];
            }
            
            List<Integer> list = new ArrayList<>();
            list.add(give); list.add(get); list.add(give - get);
            
            status.put(f, list);
        }
        
        for (int i = 0; i < friends.length; i++) {
            String f = friends[i];
            
            for (int j = 0; j < friends.length; j++) {
                if (j == i) continue;
                
                // 주고 받은 적이 없거나 같으면
                if ((board[i][j] == 0 && board[j][i] == 0) || board[i][j] == board[j][i]) {
                    if (status.get(f).get(2) > status.get(friends[j]).get(2)) {
                        history.put(f, history.getOrDefault(f, 0) + 1);
                    }
                } else {    // 주고 받은 적이 있으면
                    if (board[i][j] > board[j][i]) {
                        history.put(f, history.getOrDefault(f, 0) + 1);
                    }
                }
            }
        }
        
        if (history.size() == 0) return 0;
        
        return Collections.max(history.values());
    }
}