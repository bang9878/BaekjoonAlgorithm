import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.offerLast(s.charAt(i));
                continue;
            }

            // 알파벳이 같다면 pop
            if (stack.peekLast() == s.charAt(i)) {
                stack.pollLast();
            } else {
                stack.offerLast(s.charAt(i));
            } 
        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }
}