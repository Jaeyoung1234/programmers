import java.lang.*;

class DP4 {
    public int solution(int[] money) {
        int[] linearCost1 = new int[money.length];
        int[] linearCost2 = new int[money.length];
        int[] circularCost = new int[money.length];
        linearCost1[0] = money[0];
        linearCost1[1] = Math.max(money[0], money[1]);
        linearCost2[0] = 0;
        linearCost2[1] = money[1];
        circularCost[0] = linearCost1[0];
        circularCost[1] = linearCost1[1];
        for(int i=2; i<money.length; i++){
            linearCost1[i] = Math.max(linearCost1[i-1], money[i]+linearCost1[i-2]);
            linearCost2[i] = Math.max(linearCost2[i-1], money[i]+linearCost2[i-2]);
            circularCost[i] = Math.max(linearCost1[i-1], money[i] +linearCost2[i-2]);
        }
        
        int answer = 0;
        
        for(int i=0; i<circularCost.length; i++){
            if(answer < circularCost[i]){
                answer = circularCost[i];
            }
        }
        
        return answer;
    }
}