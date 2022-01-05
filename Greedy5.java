import java.util.*;

class Greedy5 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<int[]> edges = new PriorityQueue<>(costs.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]>o2[2] ? 1:-1;
            }
        });

        for(int i=0; i<costs.length; i++){
            edges.add(costs[i]);
        }

        int[] root = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            root[i] = i;
        }

        int count = 0;
        while(count < n-1){
            int[] edge = edges.poll();
            if (findRoot(root, edge[0]) == findRoot(root, edge[1])) {
                continue;
            }
            answer += edge[2];
            union(root, edge[0], edge[1]);
            count++;
        }
        
        return answer;
    }

    private static void union (int[] root, int a, int b){
        a = findRoot(root,a);
        b = findRoot(root,b);
        if (a == b) {
            return;
        }
        if (a > b) {
            root[a] = b;
        } else {
            root[b] = a;
        }
    }

    private static int findRoot (int[] root, int x) {
        if (root[x] == x) {
            return x;}
        return findRoot(root,root[x]);

    }
}