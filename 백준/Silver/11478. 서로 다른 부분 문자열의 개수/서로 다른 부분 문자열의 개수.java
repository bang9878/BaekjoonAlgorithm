import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    static String S;
    static Map<String, String> map = new HashMap<>();
    static boolean[] chk;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        chk = new boolean[S.length()];
        String tmp = "";

        for (int i = 0; i < S.length(); i++) {
            findSubString(i+1);
        }

        System.out.println(cnt);
    }

    static void findSubString(int r) {

        for (int i = 0; i < S.length(); i++) {
            if(i+r > S.length()){
                continue;
            }
            String substring = S.substring(i, i + r);
            duplicateCheck(substring);
        }
    }

    static void duplicateCheck(String tmp) {
        if (map.containsKey(tmp)) {
            return;
        } else if (!map.containsKey(tmp)) {
            cnt++;
            map.put(tmp, tmp);
        }
    }
}

