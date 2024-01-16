import java.util.*;

class Solution {    
    static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        double getDistance(Point p) {
            int dx = this.x - p.x;
            int dy = this.y - p.y;
            
            // return Math.pow(dx, 2) + Math.pow(dy, 2);
            return Math.abs(dx) + Math.abs(dy);
        }
    }
    
    static String RIGHT = "R";
    static String LEFT = "L";
    
    static Point[] points;
    static Point leftP = new Point(0, 3);
    static Point rightP = new Point(2, 3);
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        points = new Point[10];
        points[1] = new Point(0, 0);
        points[2] = new Point(1, 0);
        points[3] = new Point(2, 0);
        points[4] = new Point(0, 1);
        points[5] = new Point(1, 1);
        points[6] = new Point(2, 1);
        points[7] = new Point(0, 2);
        points[8] = new Point(1, 2);
        points[9] = new Point(2, 2);
        points[0] = new Point(1, 3);
        
        for (int n : numbers) {
            switch(n) {
                case 1:
                case 4:
                case 7: {
                    leftP = points[n];
                    answer.append(LEFT);
                    break;
                }
                case 3:
                case 6:
                case 9: {
                    rightP = points[n];
                    answer.append(RIGHT);
                    break;
                }
                default: {
                    answer.append(press(n, hand));
                }
            }
        }
        
        return answer.toString();
    }
    
    static String press(int n, String hand) {
        double lDistance = points[n].getDistance(leftP);
        double rDistance = points[n].getDistance(rightP);
        
        if (lDistance == rDistance) {
            if (hand.equals("right")) {
                rightP = points[n];
                return RIGHT;
            } else {
                leftP = points[n];
                return LEFT;
            }
        } else if (lDistance < rDistance) {
            leftP = points[n];
            return LEFT;
        } else {
            rightP = points[n];
            return RIGHT;
        }
    }
}