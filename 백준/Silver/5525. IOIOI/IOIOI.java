import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        String M = br.readLine();

        int cnt = 0;
        int ans = 0;

        for (int i = 1; i < S - 1;) {
            if(M.charAt(i) == 'O' && M.charAt(i+1) == 'I'){
                cnt++;

                if(cnt == N){
                    if(M.charAt(i - (cnt*2-1)) == 'I'){
                        ans++;
                    }
                    cnt--;
                }
                i+=2;
            }

            else{
                cnt = 0;
                i++;
            }
        }

        System.out.println(ans);

    }
}
