import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static int N;

    static Queue<Integer> zero = new LinkedList<>();

    static Queue<Info> remain = new LinkedList<>();

    static int[] problems = new int[200001];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int wrongCnt = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                wrongCnt += num;
            }

            if (num == 0) {
                zero.add(i + 1);
                continue;
            }

            remain.add(new Info(i + 1, num));
        }

        if (N - 1 != wrongCnt) {
            System.out.println("-1");
            return;
        }

        solution();
        System.out.println(sb);
    }

    private static void solution() {

        char pre = 'o';
        Integer first = zero.poll();
        if (first == null) {
            System.out.println("-1");
            return;
        }
        sb.append(first)
                .append('\n');

        int deletedCnt = 1;
        while (true) {

            if (deletedCnt == N) {
                return;
            }

            // 전에 것이 맞았던 것이였을 때
            if (pre == 'o') {
                // x 여러개 있는 얘 중에서 하나 빼기
                // 근데 x 여러 개 있는 얘가 없으면
                if (remain.isEmpty()) {
                    System.out.println("-1");
                    return;
                }

                Info peek = remain.peek();
                // xo 패턴인 경우 그냥 이거 뱉으면 됨.
                if (peek.xCnt == 1) {
                    remain.poll();
                    deletedCnt++;
                    sb.append(peek.number).append('\n').append(peek.number).append('\n');
                } else {
                    peek.xCnt--;
                    pre = 'x';
                    sb.append(peek.number).append('\n');
                }

            } else {    // 틀렸던 것이였을 때
                if (zero.isEmpty()) { // 만약 o인 것이 없을 경우
                    System.out.println("-1");
                    return;
                }
                // o를 제출하면 됨.
                int num = zero.poll();
                deletedCnt++;
                pre = 'o';
                sb.append(num).append('\n');
            }

        }

    }
}

class Info {

    int number;
    int xCnt;

    public Info(int number, int xCnt) {
        this.number = number;
        this.xCnt = xCnt;
    }

}