import java.util.Arrays;

class Solution {

    static public long solution(int n, int[] works) {
        long answer = 0;

        long sum = 0;
        for (int work : works) {
            sum += work;
        }

        if (sum <= n) return 0;

        Arrays.sort(works);

        int len = works.length;
        int startIdx = len - 1;
        int targetCount = 1;
        int height = works[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            int count = len - i - 1;
            int diff = height - works[i];
            long cost = (long) diff * count;

            if (cost <= n) {
                n -= cost;
                height = works[i];
                startIdx = i;
                targetCount = count + 1;
            } else {
                startIdx = i + 1;
                targetCount = count;
                break;
            }
        }

        int quotient = n / targetCount;
        int remainder = n % targetCount;

        int finalHeight = height - quotient;

        for (int i = 0; i < startIdx; i++) {
            answer += (long) works[i] * works[i];
        }

        for (int i = 0; i < targetCount; i++) {
            int value = finalHeight;
            if (i < remainder) value--;

            answer += (long) value * value;
        }

        return answer;
    }
}