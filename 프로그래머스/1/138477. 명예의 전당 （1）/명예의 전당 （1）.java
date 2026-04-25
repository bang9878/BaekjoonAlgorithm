import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            if (pq.size() == k && score[i] > pq.peek()) {
                pq.poll();
                pq.add(score[i]);
                answer[i] = pq.peek();
                continue;
            } else if(i < k) {
                pq.add(score[i]);
                answer[i] = pq.peek();
             }
            answer[i] = pq.peek();
        }

        return answer;
    }
}