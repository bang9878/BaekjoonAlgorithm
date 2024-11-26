import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<Integer, String> map = new HashMap<>(20001);
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s.length(), null);
            set.add(s);
        }

        Object[] arr = set.toArray();
        Arrays.sort(arr);

        for (Integer j : map.keySet()) {
            for (int i = 0; i < arr.length; i++) {
                if (((String) arr[i]).length() == j) {
                    sb.append((String) arr[i] + "\n");
                }
            }
        }

        System.out.print(sb);

    }
}