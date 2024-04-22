import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> ranking = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }
        
        for (String player : callings) {
            int playerRanking = ranking.get(player);
            String targetPlayer = players[playerRanking - 1];
            
            players[playerRanking - 1] = player;
            players[playerRanking] = targetPlayer;
            
            ranking.replace(player, playerRanking - 1);
            ranking.replace(targetPlayer, playerRanking);
        }
        
        return players;
    }
}