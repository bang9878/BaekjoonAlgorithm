import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = new String[5];

        int max = 0;
        for (int i = 0; i < 5; i++) {
            str[i] = br.readLine();

            if(max < str[i].length())max=str[i].length();
        }

        String result = "";

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if(str[j].length() <= i){
                    continue;
                }
                result += str[j].charAt(i);
            }
        }

        System.out.println(result);
    }
}