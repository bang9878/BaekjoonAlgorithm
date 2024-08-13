import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken()); //15
        int S = Integer.parseInt(st.nextToken()); //28
        int M = Integer.parseInt(st.nextToken()); //19

        int year = 1;

        int eNum = 1;
        int sNum = 1;
        int mNum = 1;


        while(true){
            if(eNum >15){
                eNum = 1;
            }

            if (sNum > 28) {
                sNum = 1;
            }

            if (mNum > 19) {
                mNum = 1;
            }

            if (eNum == E && sNum == S && mNum == M) {
                break;
            }



            eNum++;
            sNum++;
            mNum++;
            year++;

        }

        System.out.println(year);

    }
}

