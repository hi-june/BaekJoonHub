import java.util.*;

class Solution {
    private static class Road {
        int fromX, fromY;
        int toX, toY;
        
        private Road(int fromX, int fromY, int toX, int toY) {
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }
        
        @Override
        public boolean equals(Object o) {
            Road r = (Road) o;
            
            return (this.fromX == r.fromX && this.fromY == r.fromY && this.toX == r.toX && this.toY == r.toY) ||
                (this.fromX == r.toX && this.fromY == r.toY && this.toX == r.fromX && this.toY == r.fromY);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash();
        }
    }
    
    public int solution(String dirs) {
        Map<String, List<Integer>> directions = new HashMap<>();
        directions.put("U", List.of(0, 1));
        directions.put("D", List.of(0, -1));
        directions.put("R", List.of(1, 0));
        directions.put("L", List.of(-1, 0));
        
        Set<Road> visited = new HashSet<>();
        
        // start point
        int x = 0;
        int y = 0;
        
        for (String d : dirs.split("")) {
            List<Integer> direction = directions.get(d);
            
            int dx = x + direction.get(0);
            int dy = y + direction.get(1);
            
            if (dx < -5 || dx > 5 || dy < -5 || dy > 5) continue;
            
            visited.add(new Road(x, y, dx, dy));
            
            x = dx;
            y = dy;
        }
        
        return visited.size();
    }
}