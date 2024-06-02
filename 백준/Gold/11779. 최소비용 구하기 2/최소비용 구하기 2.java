import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static int n;
    static int m;
    static int sPoint;
    static int ePoint;
    
    static List<Edge>[] graph;
    static boolean[] visited;
    static int[] paths;
    static int[] costs;
    
    static class Edge implements Comparable<Edge>{
        Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        int start;
        int end;
        int cost;
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public static void solution() {
    	Queue<Edge> queue = new PriorityQueue<>();
    	queue.addAll(graph[sPoint]);
    	visited[sPoint] = true;
    	paths[sPoint] = -1;
    	costs[sPoint] = 0;
    	for(Edge edge : graph[sPoint])
    		costs[edge.end] = Math.min(costs[edge.end], edge.cost);
    	
    	while(!queue.isEmpty()) {
    		Edge nextEdge = queue.poll();
    		if(visited[nextEdge.end])
    			continue;
    		
    		visited[nextEdge.end] = true;
    		paths[nextEdge.end] = nextEdge.start;
    		if(graph[nextEdge.end] == null)
    			continue;

			for(Edge edge : graph[nextEdge.end]) {
    			if(costs[edge.end] > costs[nextEdge.end] + edge.cost) {
    				costs[edge.end] = costs[nextEdge.end] + edge.cost;
    				paths[edge.end] = edge.start;
    				edge.cost = costs[edge.end];
    				queue.add(edge);
    			}
    		}
    	}
    	
        System.out.println(costs[ePoint]);
        
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> stack = new Stack<>();
        int value = ePoint;
        while(value != -1) {
            stack.push(value);
            value = paths[value];
        }
        System.out.println(stack.size());
        
        while(!stack.isEmpty())
            sb.append((stack.pop() + 1) + " ");
        System.out.println(sb.toString().trim());
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n];
        costs = new int[n];
        paths = new int[n];
        visited = new boolean[n];
        Arrays.fill(costs, Integer.MAX_VALUE/2);
        for(int i=0; i<m; i++) {
            String[] temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0])-1;
            int end = Integer.parseInt(temp[1])-1;
            int cost = Integer.parseInt(temp[2]);
            if(graph[start] == null)
                graph[start] = new ArrayList<>();
            graph[start].add(new Edge(start, end, cost));
        }
        String[] temp = br.readLine().split(" ");
        sPoint = Integer.parseInt(temp[0])-1;
        ePoint = Integer.parseInt(temp[1])-1;
        solution();
    }
}
