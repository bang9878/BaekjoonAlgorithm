import java.io.*;
import java.util.*;

public class Main {
	
	static class Data {
		int index;
		int priority;
		
		public Data(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Queue<Data> queue = new LinkedList<>();
			PriorityQueue<Data> priorityQueue = new PriorityQueue<>(new Comparator<Data>() {
				public int compare(Data d1, Data d2) {
					return (d1.priority - d2.priority)*(-1);
				}
			});
			
			for(int i = 0; i < N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				Data d = new Data(i,priority);
				queue.offer(d);
				priorityQueue.offer(d);
			}
			
			int result = 1; // 답 
			while(!queue.isEmpty()) {
				if(queue.peek().priority == priorityQueue.peek().priority) {
					if(queue.peek().index == M) break;
					else {
						result++;
						queue.poll();
						priorityQueue.poll();
					}
				}
				else queue.offer(queue.poll());
				
			}
			queue.clear();
			priorityQueue.clear();
			
			System.out.println(result);
		}
		
		
		
		
	}
}
