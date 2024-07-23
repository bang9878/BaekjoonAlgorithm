import java.io.*;
import java.util.*;
import java.lang.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = br.readLine();
        int len = message.length();

        for(int i = 0; i < len; i++){
            if(i!=0 && i%10==0){
                System.out.println();
            }

            System.out.print(message.charAt(i));
        }
    }
}

