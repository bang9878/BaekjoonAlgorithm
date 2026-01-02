import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // arrows[h] = 높이 h에서 "다음 풍선"을 기다리는 화살 개수
        // (즉, 지금 높이 h 풍선을 맞출 수 있는 화살 개수)
        // 풍선을 맞추면 화살은 h-1을 기다리게 됨.
        int[] arrows = new int[1_000_002]; // 높이는 <= 1,000,000

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());

            if (arrows[h] > 0) {        // 기존 화살이 h를 기다리고 있으면 사용
                arrows[h]--;
            } else {                    // 없으면 새 화살 발사
                answer++;
            }

            arrows[h - 1]++;            // 맞춘 후 화살은 h-1을 기다림
        }

        System.out.println(answer);
    }
}
