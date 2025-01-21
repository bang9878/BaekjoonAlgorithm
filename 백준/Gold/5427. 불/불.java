import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int w, h; // 열 행
    static char[][] building;
    static boolean[][] perVisited;
    static boolean[][] fireVisited;
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};
    
    static Queue<Fire> qFire;
    static int fireMoveCnt;
    
    static Queue<Person> qPer;
    static int personMoveCnt;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; testCase++) {
            qPer = new LinkedList<>();
            qFire = new LinkedList<>();
            fireMoveCnt = 0;  // 초기화 추가
            personMoveCnt = 1;  // 초기화 추가
            input();
            bfs();
        }
        System.out.print(sb);
    }
    
    public static void bfs() {
        while (true) {
            // 불 이동
            int tmpFireMoveCnt = 0;
            for (int i = 0; i < fireMoveCnt; i++) {
                Fire tmp = qFire.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nextR = tmp.r + dirR[d];
                    int nextC = tmp.c + dirC[d];
                    
                    if (!isRange(nextR, nextC) || building[nextR][nextC] == '#' || fireVisited[nextR][nextC]) continue;
                    
                    fireVisited[nextR][nextC] = true;
                    qFire.add(new Fire(nextR, nextC));
                    tmpFireMoveCnt++;
                }
            }
            
            fireMoveCnt = tmpFireMoveCnt;
            
            // 사람 이동
            int tmpPersonMoveCnt = 0;
            boolean isMove = false;
            for (int i = 0; i < personMoveCnt; i++) {
                Person tmp = qPer.poll();
                
                if(tmp.r == 0 || tmp.c == 0 || tmp.r == h - 1 || tmp.c == w -1) {
                    sb.append(tmp.sec + 1).append('\n');
                    return;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nextR = tmp.r + dirR[d];
                    int nextC = tmp.c + dirC[d];

                    
                    if (!isRange(nextR, nextC) || building[nextR][nextC] == '#' || building[nextR][nextC] == '*' || perVisited[nextR][nextC] || fireVisited[nextR][nextC]) continue;
                    

                    
                    perVisited[nextR][nextC] = true;
                    qPer.add(new Person(nextR, nextC, tmp.sec + 1));
                    tmpPersonMoveCnt++;
                    isMove = true;
                }
            }
            personMoveCnt = tmpPersonMoveCnt;
            
            if (!isMove) {
                sb.append("IMPOSSIBLE").append('\n');
                return;
            }
        }
    }
    
    public static boolean isRange(int r, int c) {
        return (0 <= r && r < h) && (0 <= c && c < w);
    }
    
    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        building = new char[h][w];
        perVisited = new boolean[h][w];
        fireVisited = new boolean[h][w];
        
        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                building[i][j] = line.charAt(j);
                if (building[i][j] == '@') {
                    qPer.add(new Person(i, j, 0));
                    perVisited[i][j] = true;
                } else if (building[i][j] == '*') {
                    qFire.add(new Fire(i, j));
                    fireMoveCnt++;
                    fireVisited[i][j] = true;
                }
            }
        }
    }
}

class Person {
    int r, c, sec;
    
    public Person(int r, int c, int sec) {
        this.r = r;
        this.c = c;
        this.sec = sec;
    }
}

class Fire {
    int r, c;
    
    public Fire(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
