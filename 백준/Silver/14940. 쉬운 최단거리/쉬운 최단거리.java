import java.util.*;
import java.io.*;


public class Main {
    static int n, m, flag;
    static int[][] graph;
    static int[][] res;
    static int[] vecX = { 0,0,-1,1 };
    static int[] vecY = { -1,1,0,0 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];
        res = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());}
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j] == 2) {
                    res[i][j] = 0;
                    flag = 1;
                    bfs(i, j);
                    break;
                }
            }
            if(flag == 1)
                break;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && graph[i][j] == 0)res[i][j] = 0;
                else if(!visited[i][j] && graph[i][j] == 1)res[i][j] = -1;
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        br.close();
    }

    // 범위를 벗어나는가 확인해주는 함수
    static boolean range(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }

    static void bfs(int r, int c)
    {
        Queue<node> q = new LinkedList<>();
        q.add(new node(r,c,0));
        node tmp = null;

        visited[r][c] = true;

        while(!q.isEmpty()){
            tmp = q.poll();

            for(int i=0; i<4; i++){
                int nextX = tmp.x + vecX[i];
                int nextY = tmp.y + vecY[i];
                int nextDis = tmp.dis + 1;


                if(range(nextX,nextY) && graph[nextX][nextY] == 0)
                {
                    res[nextX][nextY] = 0;
                    continue;
                }



                if(range(nextX,nextY) && !visited[nextX][nextY] && graph[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    res[nextX][nextY] = nextDis;
                    q.add(new node(nextX, nextY, nextDis));
                }
            }
        }
    }
}

class node
{
    int x;
    int y;
    int dis;
    node(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
