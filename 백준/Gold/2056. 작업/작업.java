import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Main {
	
	static int N;
	static ArrayList<ArrayList<Integer>> jobList;
	static int[] times;
	static int[] indegree;

	public static void main(String args[]) throws Exception {
		input();
		System.out.println(solution());
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = parseInt(br.readLine());

		jobList = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			jobList.add(new ArrayList<Integer>());
		}

		times = new int[N + 1];
		indegree = new int[N + 1];

		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine());

			times[i] = parseInt(st.nextToken());
			int preJobCnt = parseInt(st.nextToken());
			for (int j = 0; j < preJobCnt; j++) {
				int job = parseInt(st.nextToken());
				jobList.get(job).add(i);

				indegree[i]++;
			}

		}
		
		solution();
	}

	public static int solution() {

		Queue<Integer> q = new LinkedList<>();

		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			result[i] = times[i];
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : jobList.get(cur)) {
				indegree[next]--;
				
				result[next] = Math.max(result[cur] + times[next], result[next]);
				
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			ans = Math.max(ans, result[i]);
		}

		return ans;
	}
}
