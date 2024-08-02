import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    static int N;
    static int M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];


        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j);
                if (campus[i][j] == 'I') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        bfs(startRow, startCol);

        if (cnt == 0)
            System.out.println("TT");
        else
            System.out.println(cnt);
    }

    static void bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()) {

            Node tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = tmp.x + dirX[i];
                int nextY = tmp.y + dirY[i];
                if (range(nextX, nextY) && campus[nextX][nextY] != 'X' && !visited[nextX][nextY]) {
                    if(campus[nextX][nextY] == 'P')cnt++;
                    visited[nextX][nextY] = true;
                    q.add(new Node(nextX, nextY));
                }
            }
        }
    }

    static boolean range(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
