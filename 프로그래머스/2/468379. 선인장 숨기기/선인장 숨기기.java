import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int INF = drops.length + 1;
        int[][] rain = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(rain[i], INF);
        }

        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];

            rain[r][c] = i + 1;
        }

        int newN = n - w + 1;
        int[][] rowMin = new int[m][newN];

        // 가로 슬라이딩 하기
        for (int r = 0; r < m; r++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int c = 0; c < n; c++) {

                // 현재 c열의 값보다 큰 값들은 의미 없음
                while (!dq.isEmpty() && rain[r][dq.peekLast()] >= rain[r][c]) {
                    dq.pollLast();
                }

                dq.offerLast(c);

                // 인덱스 위치 벗어나면 빼야함
                if (!dq.isEmpty() && dq.peekFirst() <= c - w) {
                    dq.pollFirst();
                }

                // 슬라이딩 구역이 만들어지면 최솟값 저장
                if (!dq.isEmpty() && c >= w - 1) {
                    rowMin[r][c - w + 1] = rain[r][dq.peekFirst()];
                }
            }
        }

        int bestTime = -1;
        int bestR = 0;
        int bestC = 1;

        for (int c = 0; c < newN; c++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int r = 0; r < m; r++) {

                // 현재 값보다 작은 값이 아닐 경우
                while (!dq.isEmpty() && rowMin[dq.peekLast()][c] >= rowMin[r][c]) {
                    dq.pollLast();
                }

                dq.offerLast(r);

                // 윈도우 벗어난 idx는 삭제
                if (!dq.isEmpty() && dq.peekFirst() <= r - h) {
                    dq.pollFirst();
                }

                if (!dq.isEmpty() && r >= h - 1) {
                    int cur = rowMin[dq.peekFirst()][c];
                    int sr = r - h + 1;

                    if (cur > bestTime ||
                            (cur == bestTime && (sr < bestR || (sr == bestR && c < bestC)))) {
                        bestTime = cur;
                        bestR = sr;
                        bestC = c;
                    }
                }
            }
        }

        return new int[]{bestR, bestC};
    }
}