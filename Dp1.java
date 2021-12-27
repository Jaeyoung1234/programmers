public class Dp1 {
    public static int solution(int[][] triangle) {

        int[][] memo = new int[triangle.length][triangle.length];
        for(int i=0; i<triangle.length; i++){
            if(i==0){
                memo[0][0] = triangle[0][0];
            }
            else if(i==1){
                memo[1][0] = memo[0][0] + triangle[1][0];
                memo[1][1] = memo[0][0] + triangle[1][1];
            } else{
                memo[i][0] = memo[i-1][0] + triangle[i][0];
                memo[i][i] = memo[i-1][i-1] + triangle[i][i];
                for(int j=1; j<i; j++){
                    memo[i][j] = memo[i-1][j-1] > memo[i-1][j] ? memo[i-1][j-1] + triangle[i][j] : memo[i-1][j] + triangle[i][j];
                }
            }
        }
        int answer = 0;

        for(int i=0; i< memo.length; i++){
            if(answer < memo[memo.length-1][i]){
                answer = memo[memo.length-1][i];
            }
        }
        return answer;
    }
}
