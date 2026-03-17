import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] classes = new char[5][5];
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        input();
        combination(0, 0, 0, 0);
        System.out.println(ans);
    }

    // start: 시작 인덱스
    // depth: 선택된 개수
    // yCnt: Y 개수
    // mask: 선택된 상태 (비트마스크)
    static void combination(int start, int depth, int yCnt, int mask) {
        // 가지치기
        if (yCnt > 3) return;

        // 7개 선택 완료
        if (depth == 7) {
            if (isConnected(mask)) {
                ans++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;

            if (classes[r][c] == 'Y') {
                combination(i + 1, depth + 1, yCnt + 1, mask | (1 << i));
            } else {
                combination(i + 1, depth + 1, yCnt, mask | (1 << i));
            }
        }
    }

    // 연결 여부 확인 (BFS)
    static boolean isConnected(int mask) {
        boolean[] visited = new boolean[25];
        Queue<Integer> q = new LinkedList<>();

        // 시작점 찾기 (첫 번째 선택된 노드)
        for (int i = 0; i < 25; i++) {
            if ((mask & (1 << i)) != 0) {
                q.add(i);
                visited[i] = true;
                break;
            }
        }

        int cnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int r = cur / 5;
            int c = cur % 5;

            for (int d = 0; d < 4; d++) {
                int nr = r + dirR[d];
                int nc = c + dirC[d];

                if (!isIn(nr, nc)) continue;

                int next = nr * 5 + nc;

                // 선택된 칸이 아니면 skip
                if ((mask & (1 << next)) == 0) continue;

                // 이미 방문했으면 skip
                if (visited[next]) continue;

                visited[next] = true;
                q.add(next);
                cnt++;
            }
        }

        return cnt == 7;
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < 5 && 0 <= c && c < 5;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                classes[i][j] = line.charAt(j);
            }
        }
    }
}