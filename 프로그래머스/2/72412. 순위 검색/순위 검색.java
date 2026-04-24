import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    private Map<String, List<Integer>> db = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        storeInfoToMap(info);
        findWithCondition(query, answer);
        return answer;
    }

    private void storeInfoToMap(String[] info) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < info.length; i++) {
            String[] splitStr = info[i].split(" ");
            for (int mask = 0; mask < 16; mask++) {
                sb.setLength(0);
                for (int k = 0; k < 4; k++) {
                    if (((mask >> k) & 1) == 0) {
                        // -로 대체
                        sb.append("-");
                    } else {
                        // 문자 그대로 쓰기
                        sb.append(splitStr[k]);
                    }
                }
                String key = sb.toString();
                db.computeIfAbsent(key, k -> new ArrayList<>()).add(Integer.parseInt(splitStr[4]));
            }
        }
        for (String key : db.keySet()) {
            Collections.sort(db.get(key));
        }
    }

    private void findWithCondition(String[] query, int[] answer) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].split(" and |\\s+");
            sb.setLength(0);
            for (int k = 0; k < 4; k++) {

                sb.append(split[k]);
            }
            String key = sb.toString();
            if (db.containsKey(key)) {
                answer[i] = getCount(db.get(key), Integer.parseInt(split[4]));
            }
        }
    }

    private int getCount(List<Integer> candidate, int target) {
        int left = 0;
        int right = candidate.size() - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (candidate.get(mid) == target) {
                right = mid - 1;
            } else if (target < candidate.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return candidate.size() - left;

    }
}