class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxH = health;
        
        health -= attacks[0][1];
        if (health <= 0) return -1;
        
        for (int i = 1; i < attacks.length; i++) {
            // heal
            int diff = attacks[i][0] - attacks[i - 1][0] - 1;
            
            health += (bandage[1] * diff) + ((diff / bandage[0]) * bandage[2]);
            health = Math.min(maxH, health);
            
            // attack
            health -= attacks[i][1];
            if (health <= 0) break;
        }
        
        return (health <= 0) ? -1 : health;
    }
}