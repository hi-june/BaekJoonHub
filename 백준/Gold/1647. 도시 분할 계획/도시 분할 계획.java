import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    static class Edge {
        int nodeA;
        int nodeB;
        int cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }

        public int getA() {
            return nodeA;
        }

        public int getB() {
            return nodeB;
        }

        public int getCost() {
            return cost;
        }
    }
    
    static int[] parent;
    
    static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
    
    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            edges.add(new Edge(nodeA, nodeB, cost));
        }
        
        edges.sort((e1, e2) -> e1.getCost() - e2.getCost());
        
        List<Integer> costList = new ArrayList<>();
        for (Edge edge : edges) {
            int nodeA = edge.getA();
            int nodeB = edge.getB();
            int cost = edge.getCost();
            
            if (findParent(nodeA) != findParent(nodeB)) {
                union(nodeA, nodeB);
                costList.add(cost);
            }
        }
        
        // 마을을 둘로 나누다 == MST에서 가장 cost가 높은 edge를 제거
        int answer = costList.stream().mapToInt(Integer::intValue).sum() - costList.get(costList.size() - 1);
        
        bw.write(answer + "");
        bw.flush();
        bw.close();
        
        br.close();
    }
}