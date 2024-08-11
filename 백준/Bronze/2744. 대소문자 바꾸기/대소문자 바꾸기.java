import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String ans = "";

        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                ans += Character.toLowerCase(input.charAt(i));
            } else {
                ans += Character.toUpperCase(input.charAt(i));
            }
        }

        System.out.println(ans);
    }
}
