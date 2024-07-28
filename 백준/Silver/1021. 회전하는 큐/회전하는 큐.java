import java.io.*;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    static int N;
    static int M;

    static Deque<Integer> dq;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] pos;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pos = new int[M];
        dq = new ArrayDeque<>(N);

        for (int i = 0; i < N; i++) {
            arr.add(i + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {
            // 이 경우는 앞으로 뺄거임
            if (findPos(pos[i]) + 1 <= (N / 2) + 1) {

                while (true) {
                    if (arr.get(0) == pos[i]) {
                        arr.remove(0);
                        break;
                    }
                    arr.add(arr.get(0));
                    arr.remove(0);
                    cnt++;
                }
            }

            else if (findPos(pos[i]) + 1 > (N / 2) + 1) {
                while (true) {
                    if (arr.get(0) == pos[i]) {
                        arr.remove(0);
                        break;
                    }
                    arr.add(0, arr.remove(N-1));
                    cnt++;
                }
            }
            N--;
        }

        System.out.println(cnt);
    }

    private static int findPos(int pos) {
        return arr.indexOf(pos);
    }
}

