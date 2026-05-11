class Solution {
    static public long solution(int k, int d) {
        long answer = 0;
        int range = d / k;
        for (int i = 0; i <= range; i++) {
            long x = (long) i * k;
            long dSqu = (long) d * d;
            long res = (long) (Math.sqrt(dSqu- (x * x)) / k);
            answer += res + 1;
        }

        return answer;
    }

}