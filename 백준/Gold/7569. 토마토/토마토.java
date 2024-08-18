import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int H;
    static int N;
    static int M;
    static int[][][] graph;
    static boolean[][][] visited;
    static Queue<NodeInfo> q = new LinkedList<>();
    static int[] dirX = {1, -1, 0, 0, 0, 0};
    static int[] dirY = {0, 0, 1, -1, 0, 0};
    static int[] dirZ = {0, 0, 0, 0, 1, -1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        graph = new int[H][N][M];
        visited = new boolean[H][N][M];

        boolean start = false;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if (graph[i][j][k] == 1) {
                        pushQueue(i, j, k);
                        start = true;
                    }
                }
            }
        }

        if (!start) {
            System.out.println("-1");
            return;
        }

        bfs();


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[i][j][k] == 0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(result);


    }

    private static void bfs() {
        while (!q.isEmpty()) {
            NodeInfo tmp = q.poll();
            for (int i = 0; i < 6; i++) {
                int nextX = tmp.x + dirX[i];
                int nextY = tmp.y + dirY[i];
                int nextZ = tmp.z + dirZ[i];
                int nextDay = tmp.day + 1;

                if (range(nextX, nextY, nextZ) && graph[nextZ][nextY][nextX] == 0 && !visited[nextZ][nextY][nextX]) {
                    visited[nextZ][nextY][nextX] = true;
                    graph[nextZ][nextY][nextX] = 1;
                    q.add(new NodeInfo(nextZ, nextY, nextX, nextDay));
                }

            }
            result = tmp.day;
        }

    }

    static boolean range(int x, int y, int z) {
        return ((x >= 0) && (x < M)) && ((y >= 0) && (y < N)) && ((z >= 0) && (z < H));
    }

    private static void pushQueue(int i, int j, int k) {
        q.add(new NodeInfo(i, j, k, 0));
        visited[i][j][k] = true;
    }
}


class NodeInfo {
    int z;
    int y;
    int x;
    int day;

    public NodeInfo(int z, int y, int x, int day) {
        this.z = z;
        this.y = y;
        this.x = x;
        this.day = day;
    }
}