import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static int[] arr;

    public static void solve() throws IOException {
        input();
        printAns();
    }

    private static void printAns() {
        int[] result = new int[N];

        // "아직 왼쪽에서 더 큰(또는 조건 만족) 값을 못 만난" 인덱스들을 담는 스택
        int[] stack = new int[N];
        int top = -1;

        // 오른쪽 -> 왼쪽으로 진행
        for (int i = N - 1; i >= 0; i--) {
            // 현재 arr[i]가 stack에 있는 애들보다 크거나 같으면,
            // 그 애들은 "왼쪽에서 처음 만난 큰 값"이 i가 됨.
            while (top >= 0 && arr[stack[top]] <= arr[i]) {
                int idx = stack[top--];
                result[idx] = i + 1; // 문제 출력이 1-based 인덱스라면 i+1
            }
            // i는 아직 왼쪽에서 더 큰 값을 못 만났으니 스택에 대기
            stack[++top] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
