import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    static ArrayList<Counsel>[] participantsByType;
    static int[] result;
    static int[] mentorCountArr;

    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        result = new int[k];
        mentorCountArr = new int[k];
        Arrays.fill(mentorCountArr, 1);

        // 상담유형 구분하기
        classifyByType(k, reqs);

        n-=k;
        int typeId = init(k);
        if (typeId == -1) {
            return 0;
        }

        while (n > 0) {
            // 해당 유형에 상담원 보충
            int max = 0;
            int maxRes = 0;
            int maxIdx = -1;
            for (int i = 0; i < k; i++) {
                mentorCountArr[i]++;
                if(mentorCountArr[i] > participantsByType[i].size()) continue;
                // 보충된 유형만 다시 계산해보기
                int calcRes = calc(i);
                int decreaseCost = result[i] - calcRes;
                if (max <= decreaseCost) {
                    max = decreaseCost;
                    maxRes = calcRes;
                    maxIdx = i;
                }
                mentorCountArr[i]--;
            }

            mentorCountArr[maxIdx]++;
            result[maxIdx] = maxRes;
            --n;
        }

        for (int res : result) {
            answer += res;
        }

        System.out.println(answer);

        return answer;
    }

    private int calc(int typeId) {
        int mentorCount = mentorCountArr[typeId];
        int[] preEndTime = new int[mentorCount];

        ArrayList<Counsel> counsels = participantsByType[typeId];
        for (int i = 0; i < mentorCount; i++) {
            Counsel counsel = counsels.get(i);
            preEndTime[i] = counsel.startTime + counsel.duringTime;
        }

        int sum = 0;
        for (int i = mentorCount; i < counsels.size(); i++) {
            Counsel counsel = counsels.get(i);
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 0; j < mentorCount; j++) {
                int cost = preEndTime[j] - counsel.startTime;
                if (min > cost) {
                    min = cost;
                    minIdx = j;
                }
            }
            if (preEndTime[minIdx] > counsel.startTime) {
                sum += preEndTime[minIdx] - counsel.startTime;
                preEndTime[minIdx] = preEndTime[minIdx] + counsel.duringTime;
            } else {
                preEndTime[minIdx] = counsel.startTime + counsel.duringTime;
            }
        }
        return sum;
    }

    private void classifyByType(int k, int[][] reqs) {
        participantsByType = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            participantsByType[i] = new ArrayList<>();
        }

        int sum = 0;
        for (int i = 0; i < reqs.length; i++) {
            int startTime = reqs[i][0];
            int duringTime = reqs[i][1];
            int type = reqs[i][2] - 1;

            participantsByType[type].add(new Counsel(startTime, duringTime));
        }
    }

    private int init(int k) {
        // 상담원을 1명씩 배치
        int max = 0;
        int typeId = -1;
        for (int i = 0; i < k; i++) {
            int sum = 0;
            if(participantsByType[i].isEmpty()) continue;

            Counsel first = participantsByType[i].get(0);
            int preEndTime = first.startTime + first.duringTime;
            for (int j = 1; j < participantsByType[i].size(); j++) {
                Counsel counsel = participantsByType[i].get(j);
                if (preEndTime > counsel.startTime) {
                    sum += preEndTime - counsel.startTime;
                    preEndTime = preEndTime + counsel.duringTime;
                } else {
                    preEndTime = counsel.startTime + counsel.duringTime;
                }
            }
            result[i] = sum;
            if (max < sum) {
                max = sum;
                typeId = i;
            }
        }
        return typeId;
    }
}

class Counsel {

    int startTime;
    int duringTime;

    public Counsel(int startTime, int duringTime) {
        this.startTime = startTime;
        this.duringTime = duringTime;
    }
}