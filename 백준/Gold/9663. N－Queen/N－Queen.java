import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.Math;

class Main
{
    static int[] board;
    static int cnt = 0;
    static int N;
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
	
		

		
			N = sc.nextInt();
             board = new int[N];
            
            dfs(0);
            System.out.print(cnt);
    
		
	}
    
    static void dfs(int depth)
    {
        // 만약 열 끝까지 갔는데 N개를 놨어 그러면 경우의 수 + 1
        if(depth == N){
            cnt++;
            return;
        }
        
        for(int i = 0; i < N; i++)
        {
            board[depth] = i;
            if(isPossibility(depth))
            {
                dfs(depth + 1);
            }
        }
    }
    
    static boolean isPossibility(int row)
    {
        // 행이 같으면 FALSE
        for(int i = 0; i < row; i++)
        {
            if(board[row] == board[i])return false;
            
            else if(Math.abs(row - i) == Math.abs(board[row] - board[i]))return false;
        }
        
        return true;
    }
}