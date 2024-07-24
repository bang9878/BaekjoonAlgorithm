import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] select;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        select = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        combination(M);
    }

    static void combination(int r) {
        if (r == 0) {
            printSequence();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!select[i]) {
                select[i] = true;
                arrayList.add(i);
                combination(r - 1);
                select[i] = false;
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    static void printSequence() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arr[arrayList.get(i)] + " ");
        }
        System.out.println();
    }


}

