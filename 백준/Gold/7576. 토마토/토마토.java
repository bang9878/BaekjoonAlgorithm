import java.util.*;
import java.io.*;


public class Main {
    static int n, m, flag;
    static int[][] graph;
    static int one_cnt =0, zero_cnt=0;
    static int result;
    static int[] vecX = { 0,0,-1,1 };
    static int[] vecY = { -1,1,0,0 };
    static boolean[][] visited;
    static Queue<node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());}
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j] == 1){
                    one_cnt++;
                    push_queue(i,j);
                }
                if(graph[i][j] == 0)zero_cnt++;
            }
        }

        if(one_cnt == n*m){System.out.print("0"); return;}
        else if(zero_cnt == n*m || one_cnt == 0){System.out.print("-1"); return;}
        else bfs();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == false && graph[i][j]==0){
                    System.out.print("-1");
                    return;
                }
            }
        }

        System.out.print(result);


        br.close();
    }

    private static void push_queue(int x, int y) {
        q.add(new node(x,y,0));
        visited[x][y] = true;
    }

    // 범위를 벗어나는가 확인해주는 함수
    static boolean range(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }

    static void bfs()
    {
        node tmp = null;

        while(!q.isEmpty()){
            tmp = q.poll();

            for(int i=0; i<4; i++){
                int nextX = tmp.x + vecX[i];
                int nextY = tmp.y + vecY[i];
                int nextDis = tmp.day + 1;

                if(range(nextX,nextY) && graph[nextX][nextY] == -1)continue;

                if(range(nextX,nextY) && !visited[nextX][nextY] && graph[nextX][nextY] == 0){
                    visited[nextX][nextY] = true;
                    graph[nextX][nextY] = 1;
                    q.add(new node(nextX, nextY, nextDis));
                }
            }
        }
        result = tmp.day;
    }
}

class node
{
    int x;
    int y;
    int day;
    node(int x, int y, int day){
        this.x = x;
        this.y = y;
        this.day = day;
    }
}
