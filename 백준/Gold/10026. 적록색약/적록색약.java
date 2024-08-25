import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static char[][] normalMap;
    static char[][] abnormalMap;
    static boolean[][] visited;

    static int[] dirX = { -1, 1, 0, 0 };
    static int[] dirY = { 0, 0, -1, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {

        n = Integer.parseInt(br.readLine());

        normalMap = new char[n][n];
        abnormalMap = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String tmpStr = br.readLine();
            for (int j = 0; j < n; j++) {
                char tmpChar = tmpStr.charAt(j);
                normalMap[i][j] = tmpChar;
                if (tmpChar == 'G') {
                    abnormalMap[i][j] = 'R';
                    continue;
                }
                abnormalMap[i][j] = tmpChar;
            }
        }

        int normalCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    normalbfs(i, j);
                    normalCnt++;
                }
            }
        }

        visited = new boolean[n][n];

        int abnormalCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    abnormalbfs(i, j);
                    abnormalCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + abnormalCnt);
    }

    private static void normalbfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = tmp.x + dirX[k];
                int nextY = tmp.y + dirY[k];

                if (range(nextX, nextY) && !visited[nextX][nextY] && normalMap[tmp.x][tmp.y] == normalMap[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.add(new Node(nextX, nextY));
                }
            }
        }

    }

    private static void abnormalbfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = tmp.x + dirX[k];
                int nextY = tmp.y + dirY[k];

                if (range(nextX, nextY) && !visited[nextX][nextY] && abnormalMap[tmp.x][tmp.y] == abnormalMap[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.add(new Node(nextX, nextY));
                }
            }
        }

    }

    static boolean range(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < n);
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}