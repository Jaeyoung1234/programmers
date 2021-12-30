import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

class DFSBFS2 {
    public int solution(int n, int[][] computers) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for(int i=0; i<n-1; i++){
            for(int j=i; j<n; j++){
                if(findRoot(root, i) == findRoot(root, j)){
                    continue;
                }
                if(computers[i][j]==1){
                union(root, i, j);}
            }
        }
        for(int i=0; i<root.length;i++){
            root[i] = findRoot(root, i);
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<root.length; i++){
            set.add(root[i]);
        }

        int answer = set.size();
        return answer;
    }
    private static int findRoot (int[] root, int x) {
        if (root[x] == x) {
            return x;}
        return findRoot(root,root[x]);

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
}