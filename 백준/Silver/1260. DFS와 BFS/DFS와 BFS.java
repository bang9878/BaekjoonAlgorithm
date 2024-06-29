import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, R, count=1;
    static  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];


        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(R);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(R);
        System.out.println(sb);



        br.close();
    }
    static void dfs(int cur)
    {
        visited[cur] = true;
        sb.append(cur + " ");
        Collections.sort(graph.get(cur));
        for(Integer value : graph.get(cur)) {
            if (!visited[value])
                dfs(value);
        }
    }


    static void bfs(int cur)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);

        while(!queue.isEmpty())
        {
            cur = queue.poll();
            Collections.sort(graph.get(cur));
            visited[cur] = true;
            sb.append(cur + " ");

            for(Integer value : graph.get(cur))
            {
                if(!visited[value]) {
                    queue.add(value);
                    visited[value]=true;
                }

            }
        }
    }



}