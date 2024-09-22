import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int N;
    static int M;
    static List<House> houses = new ArrayList<>();
    static List<Chicken> chickens = new ArrayList<>();
    static boolean[] visited;
    static int[] choice;
    static int disMin = Integer.MAX_VALUE;
    static int result = Integer.MAX_VALUE;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        choice = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(num == 1) {
                    houses.add(new House(i+1, j+1));
                }

                else if(num == 2) {
                    chickens.add(new Chicken(i + 1, j + 1));
                }
            }
        }

        visited = new boolean[chickens.size()];

        dfs(0,0);

        System.out.println(result);

    }

    private static void dfs(int start, int depth) {
        if(depth == M){
            disCalc();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                choice[depth] = i;
                dfs(i,depth + 1);
                visited[i] = false;
            }
        }

    }

    private static void disCalc() {
        sum = 0;
        for (int i = 0; i < houses.size(); i++) {
            disMin = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                House house = houses.get(i);
                Chicken chicken = chickens.get(choice[j]);
                int dis = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
                disMin = Math.min(disMin,dis);
            }
            sum += disMin;
            if(sum > result) {
                return;
            }
        }
        result = sum;
    }
}

class House{
    int r;
    int c;

    public House(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Chicken{
    int r;
    int c;

    public Chicken(int r, int c) {
        this.r = r;
        this.c = c;
    }
}