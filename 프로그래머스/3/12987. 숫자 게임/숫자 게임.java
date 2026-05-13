import java.util.Arrays;

class Solution {


    static public int solution(int[] A, int[] B) {
        int answer = 0;
        int aIdx = 0;
        int bIdx = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        while (aIdx < A.length && bIdx < B.length) {
            if (A[aIdx] < B[bIdx]) {
                aIdx++;
                answer++;
            }
            bIdx++;
        }

        return answer;
    }
}
