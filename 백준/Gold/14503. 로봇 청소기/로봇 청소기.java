import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] room;
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {-1, 0, 1, 0};
    static boolean[][] isClean;
    static int cleanCnt = 0;
    static int[] lookDir = {0, 1, 2, 3}; // 북동남서

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        isClean = new boolean[N][M];

        int r, c, d;

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        input();

        bfs(new Robot(r, c, d));
        System.out.println(cleanCnt);

    }

    private static void bfs(Robot robot) {
        Queue<Robot> queue = new LinkedList<>();
        queue.add(robot);




        while (!queue.isEmpty()) {
            Robot cur = queue.poll();
            boolean isCleanable = false;

            if (!isClean[cur.r][cur.c]) {
                isClean[cur.r][cur.c] = true;
                cleanCnt++;
            }


            for (int i = 0; i < 4; i++) {
                int nextD = cur.d - i;
                if (nextD < 0) {
                    nextD = nextD + 4;
                }
                int nextC = cur.c + dirX[nextD];
                int nextR = cur.r + dirY[nextD];


                if (range(nextR, nextC) && room[nextR][nextC] == 0 && !isClean[nextR][nextC]) {
                    isCleanable = true;
                    break;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextD = cur.d - i - 1;
                if (nextD < 0) {
                    nextD = nextD + 4;
                }
                int nextC = cur.c + dirX[nextD];
                int nextR = cur.r + dirY[nextD];


                if (range(nextR, nextC) && room[nextR][nextC] == 0 && !isClean[nextR][nextC]) {
                    queue.add(new Robot(nextR, nextC, nextD));
                    break;
                }
            }



            if (!isCleanable) {
                backMove(cur.d, cur);
                if (room[cur.r][cur.c] != 1) {
                    queue.add(new Robot(cur.r, cur.c, cur.d));
                }
            }
        }

    }

    private static void backMove(int d, Robot cur) {
        if (d == 0 && range(cur.r + 1, cur.c)) {
            cur.setR(cur.r + 1);
        } else if (d == 1 && range(cur.r, cur.c - 1)) {
            cur.setC(cur.c - 1);
        } else if (d == 2 && range(cur.r - 1, cur.c)) {
            cur.setR(cur.r - 1);
        } else if (d == 3 && range(cur.r, cur.c + 1)) {
            cur.setC(cur.c + 1);
        }
    }

    private static boolean range(int nextR, int nextC) {
        return (nextR >= 0 && nextR < N) && (nextC >= 0 && nextC < M);
    }

    private static void input() throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

class Robot {

    int r;
    int c;
    int d;


    public Robot(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setD(int d) {
        this.d = d;
    }
}
