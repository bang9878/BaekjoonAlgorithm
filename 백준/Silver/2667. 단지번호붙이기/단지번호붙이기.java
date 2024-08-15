import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int cnt = 0;
    static int areaCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j);
                    result.add(cnt);
                    areaCnt++;
                }
                cnt =0;
            }
        }

        bw.write(String.valueOf(areaCnt) + '\n');

        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            bw.write(String.valueOf(result.get(i)) + '\n');
        }

        bw.flush();

    }

    private static void bfs(int row, int col) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col));
        visited[row][col] = true;
        cnt++;

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = tmp.row + dirY[i];
                int nextCol = tmp.col + dirX[i];

                if (range(nextRow, nextCol) && map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    q.add(new Node(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                    cnt++;
                }
            }
        }
    }

    static boolean range(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }
}

class Node{
    int row;
    int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}