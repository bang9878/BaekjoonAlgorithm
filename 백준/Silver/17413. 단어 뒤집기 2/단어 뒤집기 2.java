import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb;

        String S = br.readLine();
        String copyString = "";
        String tmp = "";
        boolean flag = false;


        for (int i = 0; i < S.length(); i++) {
            if (flag) {
                if (S.charAt(i) == '>') {
                    flag = false;
                    copyString += '>';
                    continue;
                } else {
                    copyString += S.charAt(i);
                    continue;
                }
            }

            if (S.charAt(i) == '<') {
                flag = true;
                sb = new StringBuffer(tmp);
                copyString += sb.reverse().toString();
                tmp = "";
                copyString += '<';
                continue;
            }

            if(S.charAt(i) == ' '){
                sb = new StringBuffer(tmp);
                copyString += sb.reverse().toString();
                tmp = "";
                copyString += " ";
                continue;
            }

            tmp += S.charAt(i);
        }

        sb = new StringBuffer(tmp);
        copyString += sb.reverse().toString();

        System.out.print(copyString);
    }
}

