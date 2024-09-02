import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int ladderCnt;
    static int snakeCnt;
    static int[][] ladder;
    static int[][] snake;
    static int[] dice = { 6, 5, 4, 3, 2, 1 };
    static boolean[] visited = new boolean[101];
    static int result;
    static boolean isLadder;
    static boolean isSnake;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ladderCnt = Integer.parseInt(st.nextToken());
        snakeCnt = Integer.parseInt(st.nextToken());

        ladder = new int[ladderCnt][2];
        snake = new int[snakeCnt][2];

        for (int i = 0; i < ladderCnt; i++) {
            st = new StringTokenizer(br.readLine());

            ladder[i][0] = Integer.parseInt(st.nextToken());
            ladder[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < snakeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            snake[i][0] = Integer.parseInt(st.nextToken());
            snake[i][1] = Integer.parseInt(st.nextToken());
        }

        bfs(1);

        System.out.println(result);
    }

    private static void bfs(int start) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pos tmp = q.poll();
            if (tmp.pos == 100) {
                result = tmp.diceCnt;
            }
            for (int i = 0; i < 6; i++) {
                int nextPos = tmp.pos + dice[i];
                int diceCnt = tmp.diceCnt;

                if (nextPos > 100 || visited[nextPos]) {
                    continue;
                }

                for (int j = 0; j < ladderCnt; j++) {
                    if (nextPos == ladder[j][0] && !visited[ladder[j][0]]) {
                        visited[ladder[j][0]] = true;
                        q.add(new Pos(ladder[j][1], diceCnt + 1));
                    }
                }

                for (int j = 0; j < snakeCnt; j++) {
                    if (nextPos == snake[j][0] && !visited[snake[j][0]]) {
                        visited[snake[j][0]] = true;
                        q.add(new Pos(snake[j][1], diceCnt + 1));
                    }
                }

                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    q.add(new Pos(nextPos, diceCnt + 1));
                }
            }
        }
    }
}

class Pos {
    int pos;
    int diceCnt = 0;

    Pos(int pos, int diceCnt) {
        this.pos = pos;
        this.diceCnt = diceCnt;
    }
}
