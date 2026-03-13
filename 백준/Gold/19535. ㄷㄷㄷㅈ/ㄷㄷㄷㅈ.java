import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int[] degree;
    static List<Edge> input = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static class Edge {
        int n1;
        int n2;

        public Edge(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        long g = findG();
        long d = findD();
        if (d > 3 * g) {
            System.out.println("D");
        } else if (d < 3 * g) {
            System.out.println("G");
        } else {
            System.out.println("DUDUDUNGA");
        }
    }

    static long findD() {
        long result = 0L;
        for (Edge e : input) {
            int size = graph.get(e.n1).size() - 1;
            int size2 = graph.get(e.n2).size() - 1;

            result += ((long) size * size2);
        }
        return result;
    }


    static long findG() {
        long result = 0L;
        for (int i = 0; i < N; i++) {
            if (degree[i] >= 3) {
                result += calcCom(degree[i]);
            }
        }
        return result;
    }

    static long calcCom(int n) {
        long result = 1L;
        for (int i = n; i > n - 3; i--) {
            result *= i;
        }
        return result / 6;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        degree = new int[N];
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            input.add(new Edge(n1, n2));
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);

            degree[n1]++;
            degree[n2]++;
        }
    }

}
