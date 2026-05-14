import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int SIZE = 50;
    private static final int CELL_COUNT = SIZE * SIZE;
    private static final String EMPTY = "";

    private int[] parent;
    private String[] value;
    private List<String> answer;

    public String[] solution(String[] commands) {
        init();

        for (String command : commands) {
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "UPDATE":
                    if (parts.length == 4) {
                        int r = Integer.parseInt(parts[1]);
                        int c = Integer.parseInt(parts[2]);
                        String newValue = parts[3];

                        updateCell(r, c, newValue);
                    } else {
                        String oldValue = parts[1];
                        String newValue = parts[2];

                        updateValue(oldValue, newValue);
                    }
                    break;

                case "MERGE":
                    int r1 = Integer.parseInt(parts[1]);
                    int c1 = Integer.parseInt(parts[2]);
                    int r2 = Integer.parseInt(parts[3]);
                    int c2 = Integer.parseInt(parts[4]);

                    merge(r1, c1, r2, c2);
                    break;

                case "UNMERGE":
                    int r = Integer.parseInt(parts[1]);
                    int c = Integer.parseInt(parts[2]);

                    unmerge(r, c);
                    break;

                case "PRINT":
                    int printR = Integer.parseInt(parts[1]);
                    int printC = Integer.parseInt(parts[2]);

                    print(printR, printC);
                    break;
            }
        }

        return answer.toArray(new String[0]);
    }

    private void init() {
        parent = new int[CELL_COUNT];
        value = new String[CELL_COUNT];
        answer = new ArrayList<>();

        for (int i = 0; i < CELL_COUNT; i++) {
            parent[i] = i;
            value[i] = EMPTY;
        }
    }

    private void updateCell(int r, int c, String newValue) {
        int root = find(toIndex(r, c));
        value[root] = newValue;
    }

    private void updateValue(String oldValue, String newValue) {
        for (int i = 0; i < CELL_COUNT; i++) {
            if (parent[i] == i && value[i].equals(oldValue)) {
                value[i] = newValue;
            }
        }
    }

    private void merge(int r1, int c1, int r2, int c2) {
        int cell1 = toIndex(r1, c1);
        int cell2 = toIndex(r2, c2);

        int root1 = find(cell1);
        int root2 = find(cell2);

        if (root1 == root2) {
            return;
        }

        String mergedValue = !value[root1].isEmpty()
                ? value[root1]
                : value[root2];

        parent[root2] = root1;
        value[root1] = mergedValue;
        value[root2] = EMPTY;
    }

    private void unmerge(int r, int c) {
        int target = toIndex(r, c);
        int root = find(target);
        String savedValue = value[root];

        List<Integer> mergedCells = new ArrayList<>();

        for (int i = 0; i < CELL_COUNT; i++) {
            if (find(i) == root) {
                mergedCells.add(i);
            }
        }

        for (int cell : mergedCells) {
            parent[cell] = cell;
            value[cell] = EMPTY;
        }

        value[target] = savedValue;
    }

    private void print(int r, int c) {
        int root = find(toIndex(r, c));

        if (value[root].isEmpty()) {
            answer.add("EMPTY");
        } else {
            answer.add(value[root]);
        }
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private int toIndex(int r, int c) {
        return (r - 1) * SIZE + (c - 1);
    }
}