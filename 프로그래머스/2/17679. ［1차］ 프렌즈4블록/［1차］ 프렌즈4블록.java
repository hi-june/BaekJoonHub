import java.util.*;
import java.util.stream.*;

class Solution {
    private static class Point {
        int col, row;

        private Point(int col, int row) {
            this.col = col;
            this.row = row;
        }

        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;

            return p.col == this.col && p.row == this.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.col, this.row);
        }
    }

    private char[][] map;

    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int count = 0;
        while (true) {
            // check
            // int tmpCount = 0;
            Set<Point> points = new HashSet<>();
            for (int col = 0; col < m - 1; col++) {
                for (int row = 0; row < n - 1; row++) {
                    if (map[col][row] == '-') continue;

                    check(col, row, points);
                }
            }

            for (Point point : points) {
                map[point.col][point.row] = '-';
            }

            // remove
            if (points.size() > 0) {
                removeBlocks(m, n);
                count += points.size();
            } else {
                break;
            }
        }

        return count;
    }

    private boolean check(int col, int row, Set<Point> p) {
        char val = map[col][row];

        for (int c = col; c < col + 2; c++) {
            for (int r = row; r < row + 2; r++) {
                if (map[c][r] != val) return false;
            }
        }

        for (int c = col; c < col + 2; c++) {
            for (int r = row; r < row + 2; r++) {
                p.add(new Point(c, r));
            }
        }

        return true;
    }

    private void removeBlocks(int c, int r) {
        for (int row = 0; row < r; row++) {
            Stack<Character> stack = new Stack<>();

            for (int col = 0; col < c; col++) {
                if (map[col][row] != '-') {
                    stack.push(map[col][row]);
                }
            }

            for (int col = c - 1; col >= 0; col--) {
                if (!stack.isEmpty()) {
                    map[col][row] = stack.pop();
                } else {
                    map[col][row] = '-';
                }
            }
        }
    }
}