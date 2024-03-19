import java.util.*;

class Solution {
    // Ax + By + E = 0
    // Cx + Dy + F = 0
    private static class Point {
        public int x;
        public int y;
        
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            
            return this.x == p.x && this.y == p.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }
    
    public String[] solution(int[][] line) {
        int n = line.length;
        
        Set<Point> points = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(i, j, line)) {
                    points.add(getPoints(i, j, line));
                }
            }
        }
        
        return draw(points);
        
        // return new String[]{""};
    }
    
    private boolean check(int ori, int comp, int[][] line) {
        long a = line[ori][0];
        long b = line[ori][1];
        long e = line[ori][2];
        
        long c = line[comp][0];
        long d = line[comp][1];
        long f = line[comp][2];
        
        if (a*d - b*c == 0) {
            return false;
        }
        
        return (b*f - e*d) % (a*d - b*c) == 0 && (e*c - a*f) % (a*d - b*c) == 0;
    }
    
    private Point getPoints(int ori, int comp, int[][] line) {        
        long a = line[ori][0];
        long b = line[ori][1];
        long e = line[ori][2];
        
        long c = line[comp][0];
        long d = line[comp][1];
        long f = line[comp][2];
        
        long x = (b*f - e*d) / (a*d - b*c);
        long y = (e*c - a*f) / (a*d - b*c);
        
        return new Point((int)x, (int)y);
    }
    
    private String[] draw(Set<Point> points) {
        if (points.size() == 1) return new String[]{"*"};
        
        List<Integer> xPoints = new ArrayList<>();
        List<Integer> yPoints = new ArrayList<>();
        
        for (Point p : points) {
            xPoints.add(p.x);
            yPoints.add(p.y);
        }
        
        int minX = Collections.min(xPoints);    // -4
        int maxX = Collections.max(xPoints);    // 4
        int minY = Collections.min(yPoints);    // -4
        int maxY = Collections.max(yPoints);    // 4
        
        // (8, 3)
        int[][] map = new int[Math.abs(minY - maxY) + 1][Math.abs(minX - maxX) + 1];
        
        for (Point p : points) {
            int newX = Math.abs(minX - p.x);
            int newY = Math.abs(maxY - p.y);
            
            map[newY][newX] = 1;
        }
        
        List<String> result = new ArrayList<>();
        for (int[] line : map) {
            StringBuilder sb = new StringBuilder();
            for (int i : line) {
                if (i == 0) {
                    sb.append(".");
                } else if (i == 1) {
                    sb.append("*");
                }
            }
            result.add(sb.toString());
        }
        
        return result.stream().toArray(String[]::new);
    }
}