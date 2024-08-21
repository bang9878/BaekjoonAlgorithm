import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        int command;
        for (int i = 0; i < N; i++) {
            command = Integer.parseInt(br.readLine());

            if (command == 0 && plus.isEmpty() && minus.isEmpty()) {
                bw.write("0" + '\n');
                continue;
            }

            if (command == 0 && plus.isEmpty()) {
                bw.write(String.valueOf(minus.poll()) + '\n');
                continue;
            }

            if (command == 0 && minus.isEmpty()) {
                bw.write(String.valueOf(plus.poll()) + '\n');
                continue;
            }

            if (command == 0) {
                int minusNum = minus.peek();
                int plusNum = plus.peek();

                if (Math.abs(minusNum) <= Math.abs(plusNum)) {
                    bw.write(String.valueOf(minus.poll()) + '\n');
                }

                else if (Math.abs(minusNum) > Math.abs(plusNum)) {
                    bw.write(String.valueOf(plus.poll()) + '\n');
                }

                continue;
            }

            if (command < 0) {
                minus.add(command);
            } else if (command > 0) {
                plus.add(command);
            }
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
