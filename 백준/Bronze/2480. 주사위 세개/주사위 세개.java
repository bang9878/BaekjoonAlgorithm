import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();    // 첫번째 주사위
        int B = sc.nextInt();    // 두번째 주사위
        int C = sc.nextInt();    // 세번째 주사위

        if(A == B && A == C) {                             // 3개다 같을 경우 10000 + (같은눈) x 1000
            System.out.println(10000 + A * 1000);
        } else if(A == B && A != C || A == C && A != B) {  // 2개만 같을 경우 1000 + (같은눈) x 100
            System.out.println(1000 + A * 100);
        } else if(B == C && B != A){                       // 2개만 같을 경우 1000 + (같은눈) x 100
            System.out.println(1000 + B * 100);
        }else {                                            // 모두 다른 눈이 나오는 경우
            int m = A;                                     // (그중 가장 큰눈) x 100
            if (m < B) m = B;
            if (m < C) m = C;
            System.out.println(m * 100);
        }
    }
}