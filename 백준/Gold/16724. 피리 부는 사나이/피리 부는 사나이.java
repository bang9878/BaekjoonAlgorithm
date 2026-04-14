import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;
    static int[][] groupIDArr;
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();

        int groupID = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (groupIDArr[i][j] == 0) {
                    search(i, j, ++groupID);
                }
            }
        }

        System.out.println(answer);

    }

    static void search(int r, int c, int markNo) {
        int curR = r;
        int curC =c;
        while (true) {

            if (groupIDArr[curR][curC] > 0 && groupIDArr[curR][curC] == markNo) {
                // 자기 자신 싸이클 발견
                answer++;
                break;
            } else if (groupIDArr[curR][curC] > 0 && groupIDArr[curR][curC] != markNo) {
                break;
            }


            groupIDArr[curR][curC] = markNo;
            int dirIdx = getDirIdx(map[curR][curC]);
            curR = curR + dirR[dirIdx];
            curC = curC + dirC[dirIdx];
        }

    }

    static int getDirIdx(char cmd) {
        switch (cmd) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            default:
                return 3;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        groupIDArr = new int[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

    }
}