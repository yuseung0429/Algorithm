import java.io.*;
import java.util.*;

class Main {
    static class Node {
        long sheep;
        long wolf;
        ArrayList<Node> children = new ArrayList<>();
    }

    static Node[] nodes;

    public static long solution() {
        return rec(nodes[0]);
    }

    public static long rec(Node node) {
        long currentSheep = 0;
        for (Node child : node.children) {
            currentSheep += rec(child);
        }
        currentSheep = Math.max(0, currentSheep - node.wolf);
        return currentSheep + node.sheep;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            long count = Long.parseLong(st.nextToken());
            int parentIdx = Integer.parseInt(st.nextToken()) - 1;

            if (type.equals("S")) nodes[i].sheep = count;
            else if (type.equals("W")) nodes[i].wolf = count;
            nodes[parentIdx].children.add(nodes[i]);
        }
        System.out.println(solution());
    }
}