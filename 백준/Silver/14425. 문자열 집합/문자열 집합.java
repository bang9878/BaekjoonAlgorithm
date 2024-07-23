import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        Map<String, String> map = new HashMap<>();
        String[] chk = new String[M];

        for(int i = 0; i < N; i++){
            String S = br.readLine();
            map.put(S, S);
        }

        for (int i = 0; i < M; i++) {
            chk[i] = br.readLine();
        }

        for(int i =0; i< chk.length; i++){
            if(map.containsKey(chk[i])){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

