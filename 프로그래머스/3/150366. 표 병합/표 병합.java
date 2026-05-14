import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static List<String> list = new ArrayList<>();
    static String[][] table = new String[51][51];
    static int[][] mergeStatusArr = new int[51][51];
    static int curMergeId = 0;

    public String[] solution(String[] commands) {
        init();
        for (String cmd : commands) {
            String[] splitStr = cmd.split(" ");

//            for (String str : splitStr) {
//                System.out.print(str + " ");
//            }
//
//            for (int i = 0; i < 51; i++) {
//                for (int j = 0; j < 51; j++) {
//                    System.out.print(table[i][j] + " ");
//                }
//                System.out.println();
//            }


            // 1, "UPDATE r c value"
            if (splitStr[0].equals("UPDATE") && splitStr.length == 4) {
                int r = Integer.parseInt(splitStr[1]);
                int c = Integer.parseInt(splitStr[2]);
                String value = splitStr[3];
                updateRC(r, c, value);
            }

            // 2. "UPDATE value1 value2"
            else if (splitStr[0].equals("UPDATE") && splitStr.length == 3) {
                String value1 = splitStr[1];
                String value2 = splitStr[2];
                updateV1ToV2(value1, value2);
            }

            // 3. "MERGE r1 c1 r2 c2"
            else if (splitStr[0].equals("MERGE")) {
                int r1 = Integer.parseInt(splitStr[1]);
                int c1 = Integer.parseInt(splitStr[2]);
                int r2 = Integer.parseInt(splitStr[3]);
                int c2 = Integer.parseInt(splitStr[4]);
                String value = "";

                // 같은 셀이면 무시
                if (r1 == r2 && c1 == c2) continue;

                if (!table[r1][c1].isEmpty() && !table[r2][c2].isEmpty()) {
                    value = table[r1][c1];
                } else if (!table[r1][c1].isEmpty() && table[r2][c2].isEmpty()) {
                    value = table[r1][c1];
                } else if (table[r1][c1].isEmpty() && !table[r2][c2].isEmpty()) {
                    value = table[r2][c2];
                }

                mergeShell(r1, c1, r2, c2, value);
            }

            // 4. "UNMERGE r c"
            else if (splitStr[0].equals("UNMERGE")) {
                int r = Integer.parseInt(splitStr[1]);
                int c = Integer.parseInt(splitStr[2]);
                unmergeShell(r, c);
            }

            // 5. "PRINT r c"
            else if (splitStr[0].equals("PRINT")) {
                int r = Integer.parseInt(splitStr[1]);
                int c = Integer.parseInt(splitStr[2]);
                printShell(r, c);
            }

//            for (int i = 0; i < 51; i++) {
//                for (int j = 0; j < 51; j++) {
//                    System.out.print(table[i][j] + " ");
//                }
//                System.out.println();
//            }

        }

        return list.toArray(new String[0]);
    }

    private void updateRC(int r, int c, String value) {
        int mergeId = mergeStatusArr[r][c];

        if (mergeId == 0) {
            table[r][c] = value;
            return;
        }

        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                if (mergeStatusArr[i][j] == mergeId) {
                    table[i][j] = value;
                }
            }
        }
    }

    private void updateV1ToV2(String value1, String value2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                if (table[i][j].equals(value1)) {
                    if (mergeStatusArr[i][j] == 0) {
                        table[i][j] = value2;
                        continue;
                    }
                    set.add(mergeStatusArr[i][j]);
                }
            }
        }

        for (int mergeId : set) {
            for (int i = 0; i < 51; i++) {
                for (int j = 0; j < 51; j++) {
                    if (mergeStatusArr[i][j] == mergeId) {
                        table[i][j] = value2;
                    }
                }
            }
        }
    }

    private void mergeShell(int r1, int c1, int r2, int c2, String value) {
        int mergeId1 = mergeStatusArr[r1][c1];
        int mergeId2 = mergeStatusArr[r2][c2];

        ++curMergeId;
        if (mergeId1 == 0 && mergeId2 == 0) {
            mergeStatusArr[r1][c1] = curMergeId;
            mergeStatusArr[r2][c2] = curMergeId;
            table[r1][c1] = value;
            table[r2][c2] = value;
        } else if (mergeId1 == 0) {
            mergeStatusArr[r1][c1] = curMergeId;
            table[r1][c1] = value;
            updateMergeId(mergeId2, value);
        } else if (mergeId2 == 0) {
            mergeStatusArr[r2][c2] = curMergeId;
            table[r2][c2] = value;
            updateMergeId(mergeId1, value);
        } else {
            for (int i = 0; i < 51; i++) {
                for (int j = 0; j < 51; j++) {
                    if (mergeStatusArr[i][j] == mergeId1 || mergeStatusArr[i][j] == mergeId2) {
                        mergeStatusArr[i][j] = curMergeId;
                        table[i][j] = value;
                    }
                }
            }
        }
    }

    private void unmergeShell(int r, int c) {
        int mergeId = mergeStatusArr[r][c];
        String value = table[r][c];

        if (mergeId == 0) {
            return;
        }
        
        
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                if (mergeStatusArr[i][j] == mergeId) {
                    mergeStatusArr[i][j] = 0;
                    table[i][j] = "";
                }
            }
        }
        table[r][c] = value;
    }

    private void printShell(int r, int c) {
        if (table[r][c].isEmpty()) {
            list.add("EMPTY");
        } else {
            list.add(table[r][c]);
        }
    }

    private void updateMergeId(int mergeId, String value) {
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                if (mergeStatusArr[i][j] == mergeId) {
                    mergeStatusArr[i][j] = curMergeId;
                    table[i][j] = value;
                }
            }
        }
    }


    private void init() {
        for (int i = 0; i <= 50; i++) {
            Arrays.fill(table[i], "");
        }
    }
}