import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int APPLE = 1;

    // 보드크기, 사과의 개수, 변화 횟수
    static int N, K, L;
    static int[][] map;
    static Snake[][] infoMap;
    static Snake head = null;
    static Snake tail = null;
    static int time;

    static Map<Integer, Character> cmd;

    // 상, 우, 하, 좌 -> 0, 1, 2, 3
    static int[] dirR = {-1, 0, 1, 0};
    static int[] dirC = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        input();
        simulation();
        System.out.println(++time);
    }

    private static void simulation() {
        while (true) {

            // 일단 이동
            int nhr = head.r + dirR[head.dir];
            int nhc = head.c + dirC[head.dir];

            // 자기자신이거나 벽이면 게임 종료
            if (!isIn(nhr, nhc) || Objects.nonNull(infoMap[nhr][nhc])) {
                return;
            }

            // 전진
            head = new Snake(nhr, nhc, head.dir);
            infoMap[nhr][nhc] = head;

            // 사과가 없다면
            if (map[nhr][nhc] != APPLE) {
                // 꼬리 당기기
                infoMap[tail.r][tail.c] = null;
                int ntr = tail.r + dirR[tail.dir];
                int ntc = tail.c + dirC[tail.dir];

                tail = infoMap[ntr][ntc];
            } else {
                map[nhr][nhc] = 0;
            }

            ++time;

            if (cmd.containsKey(time)) {
                Character c = cmd.get(time);
                if (c == 'D') {
                    head.dir = (head.dir + 1) % 4;
                } else if (c == 'L') {
                    head.dir = (head.dir + 3) % 4;
                }
            }

        }
    }

    private static boolean isIn(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < N;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        cmd = new HashMap<>();
        map = new int[N][N];
        infoMap = new Snake[N][N];

        head = new Snake(0, 0, 1);
        tail = new Snake(0, 0, 1);
        infoMap[0][0] = new Snake(0, 0, 1);

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = APPLE;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            cmd.put(t, c);
        }
    }
}

class Snake {
    int r;
    int c;
    int dir;

    public Snake(int r, int c, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
    }

}