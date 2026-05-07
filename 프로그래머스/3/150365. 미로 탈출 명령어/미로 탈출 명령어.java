class Solution {

    private static final int[] DR = {1, 0, 0, -1};
    private static final int[] DC = {0, -1, 1, 0};
    private static final char[] CMD = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int minDist = getDistance(x, y, r, c);

        if (minDist > k || (k - minDist) % 2 != 0) {
            return "impossible";
        }

        StringBuilder answer = new StringBuilder();

        int row = x;
        int col = y;

        for (int move = 0; move < k; move++) {
            for (int dir = 0; dir < 4; dir++) {
                int nextRow = row + DR[dir];
                int nextCol = col + DC[dir];

                if (!isInRange(nextRow, nextCol, n, m)) {
                    continue;
                }

                int remain = k - move - 1;

                if (canReach(nextRow, nextCol, r, c, remain)) {
                    row = nextRow;
                    col = nextCol;
                    answer.append(CMD[dir]);
                    break;
                }
            }
        }

        return answer.toString();
    }

    private int getDistance(int row1, int col1, int row2, int col2) {
        return Math.abs(row1 - row2) + Math.abs(col1 - col2);
    }

    private boolean canReach(int row, int col, int targetRow, int targetCol, int remain) {
        int dist = getDistance(row, col, targetRow, targetCol);
        return dist <= remain && (remain - dist) % 2 == 0;
    }

    private boolean isInRange(int row, int col, int n, int m) {
        return 1 <= row && row <= n && 1 <= col && col <= m;
    }
}