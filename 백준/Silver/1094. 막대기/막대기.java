import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int bar = 64;
        int cnt = 1;

        while(true) {
            if(num == bar) {
                System.out.println(cnt);
                break;
            }

            bar = bar / 2;

            if(bar >= num) {
                continue;
            }
            
            num -= bar;
            cnt++;

        }
    }
}
