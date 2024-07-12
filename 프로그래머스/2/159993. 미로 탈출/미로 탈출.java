class Solution {
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] map1;
    private int[][] map2;
    private int[] sPoint = new int[2];
    private int[] lPoint = new int[2];
    private int[] ePoint = new int[2];

    public int solution(String[] maps) {
        map1 = new int[maps.length][];
        map2 = new int[maps.length][];

        for (int i = 0; i < maps.length; i++) {
            map1[i] = new int[maps[0].length()];
            map2[i] = new int[maps[0].length()];

            for (int j = 0; j < maps[0].length(); j++) {
                switch (maps[i].charAt(j)) {
                    case 'S': {
                        sPoint[0] = i;
                        sPoint[1] = j;
                        break;
                    }
                    case 'E': {
                        ePoint[0] = i;
                        ePoint[1] = j;
                        break;
                    }
                    case 'L': {
                        lPoint[0] = i;
                        lPoint[1] = j;
                        break;
                    }
                }

                if (maps[i].charAt(j) == 'X') {
                    map1[i][j] = -1;
                    map2[i][j] = -1;
                }
            }
        }

        dfs(sPoint[0], sPoint[1], map1, sPoint, lPoint);
        if (map1[lPoint[0]][lPoint[1]] == 0) {
            return -1;
        }

        dfs(lPoint[0], lPoint[1], map2, lPoint, ePoint);
        if (map2[ePoint[0]][ePoint[1]] == 0) {
            return -1;
        }

        return map1[lPoint[0]][lPoint[1]] + map2[ePoint[0]][ePoint[1]];
    }

    private void dfs(int col, int row, int[][] map, int[] start, int[] end) {
        if (col == end[0] && row == end[1]) {
            return;
        }

        for (int[] d : directions) {
            int dCol = col + d[0];
            int dRow = row + d[1];

            if (dCol < 0 || dCol >= map.length || dRow < 0 || dRow >= map[0].length) continue;
            if (map[dCol][dRow] == -1) continue;
            if (dCol == start[0] && dRow == start[1]) continue;

            if (map[dCol][dRow] == 0 || map[dCol][dRow] > map[col][row] + 1) {
                map[dCol][dRow] = map[col][row] + 1;
                dfs(dCol, dRow, map, start, end);
            }
        }
    }
}