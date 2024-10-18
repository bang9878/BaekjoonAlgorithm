import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        Map<String, String> company = new LinkedHashMap<>();


        int n = Integer.parseInt(br.readLine());

        String name;
        String exist;
        int leaveCnt=0;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());

             name = st.nextToken();
             exist = st.nextToken();

            if (exist.equals("leave")) {
                company.remove(name);
                continue;
            }
            company.put(name, exist);
        }

        String[] leavePeople = new String[company.size()];
        int index=0;
        for (String s : company.keySet()) {
            leavePeople[index++] = s;
        }

        Arrays.sort(leavePeople, Comparator.reverseOrder());

        for (int i = 0; i < index; i++) {
            sb.append(leavePeople[i]).append("\n");
        }

        System.out.print(sb);


   }

}