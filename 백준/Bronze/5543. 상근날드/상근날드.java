import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] hamburger = new int[3];
        int[] beverage = new int[2];

        for (int i = 0; i < 3; i++) {
            hamburger[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2; i++) {
            beverage[i] = Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if(min > hamburger[i] + beverage[j]){
                    min = hamburger[i] + beverage[j];
                }
            }
        }

        System.out.println(min - 50);
    }
}