class DP3 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] memo = new int[n+1][m+1];

        for(int i=0; i<m+1; i++){
            memo[0][i] = 0;
        }

        for(int i=0; i<n+1; i++){
            memo[i][0] = 0;
        }

        memo[1][1] = 1;




        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(i==1 && j==1){
                    continue;
                }
                int above = (memo[i-1][j]==-1) ? 0 : memo[i-1][j];
                int left = (memo[i][j-1]==-1) ? 0 : memo[i][j-1];
                memo[i][j] = (above + left)%1000000007;

                for(int k=0; k<puddles.length; k++){
                    memo[puddles[k][1]][puddles[k][0]] = -1;
                }
            }
        }
    

        return memo[n][m]%1000000007;
    }
}