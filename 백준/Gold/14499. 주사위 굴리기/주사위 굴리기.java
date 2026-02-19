import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int R, C, K;
    static int startR, startC;
    static int[][] map;
    static int[] dice = new int[6];
    static int[] tmpDice = new int[6];
    static int[] dirR = {0, 0, -1, 1};
    static int[] dirC = {1, -1, 0, 0};
    static Queue<Integer> commands = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        simulate();
    }

    public static void simulate() {
        StringBuilder sb = new StringBuilder();
        int curR = startR;
        int curC = startC;
        while (!commands.isEmpty()) {
            int cmd = commands.poll();
            int nextR = curR + dirR[cmd];
            int nextC = curC + dirC[cmd];

            if(!isIn(nextR, nextC)) continue;

            switch (cmd) {
                case 0:
                    turnRight();
                    break;
                case 1:
                    turnLeft();
                    break;
                case 2:
                    turnUp();
                    break;
                case 3:
                    turnDown();
                    break;
            }

            if (map[nextR][nextC] == 0) {
                map[nextR][nextC] = dice[0];
            } else {
                dice[0] = map[nextR][nextC];
                map[nextR][nextC] = 0;
            }

            curR = nextR;
            curC = nextC;


            sb.append(dice[5])
                    .append('\n');
        }
        System.out.print(sb);
    }

    public static void turnRight() {
        tmpDice[0] = dice[2];
        tmpDice[2] = dice[5];
        tmpDice[5] = dice[3];
        tmpDice[3] = dice[0];
        tmpDice[1] = dice[1];
        tmpDice[4] = dice[4];

        copyValue();
    }

    public static void turnLeft() {
        tmpDice[0] = dice[3];
        tmpDice[3] = dice[5];
        tmpDice[5] = dice[2];
        tmpDice[2] = dice[0];
        tmpDice[1] = dice[1];
        tmpDice[4] = dice[4];

        copyValue();
    }

    public static void turnUp() {
        tmpDice[0] = dice[1];
        tmpDice[1] = dice[5];
        tmpDice[5] = dice[4];
        tmpDice[4] = dice[0];
        tmpDice[2] = dice[2];
        tmpDice[3] = dice[3];

        copyValue();
    }

    public static void turnDown() {
        tmpDice[0] = dice[4];
        tmpDice[4] = dice[5];
        tmpDice[5] = dice[1];
        tmpDice[1] = dice[0];
        tmpDice[2] = dice[2];
        tmpDice[3] = dice[3];

        copyValue();
    }

    public static void copyValue() {
        for (int i = 0; i < 6; i++) {
            dice[i] = tmpDice[i];
        }
    }

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            commands.add(Integer.parseInt(st.nextToken()) - 1);
        }
    }

}
