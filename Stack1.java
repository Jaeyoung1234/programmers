import java.util.Stack;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
         Stack<Integer> stack = new Stack<>();
        for(int i=progresses.length-1; i>=0; i--){
            int time = 0;
            int quotient = (100-progresses[i])/speeds[i];
            int remainder = (100-progresses[i])%speeds[i];
            if(remainder > 0){
                time = quotient +1;
            } else{
                time = quotient;
            }
            stack.add(time);
        }

        ArrayList<Integer> returnElements = new ArrayList<>();

        int count = 1;
        while(!stack.isEmpty()){
            int time = stack.pop();
            while(!stack.isEmpty()){
                if(time >= stack.peek()){
                    stack.pop();
                    count++;
                }else{
                    break;
                }
            }

            returnElements.add(count);
            count = 1;

        }
        int[] answer =new int[returnElements.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = returnElements.get(i);
        }
        return answer;
    }
}