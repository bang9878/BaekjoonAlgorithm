import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.FileInputStream;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
        int N = Integer.parseInt(st.nextToken());  // 재료 갯수
        int K = Integer.parseInt(st.nextToken());  // 배낭의 최대 무게
        
        int[] W = new int[N+1];  // 각 재료의 무게
        int[] V = new int[N+1];  // 각 재료의 값어치
        int[][] dp = new int[N+1][K+1];
        
        for(int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(W[i] > j)dp[i][j] = dp[i-1][j];
                
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
            }
        }
        
        System.out.print(dp[N][K]);
        
	}
}
