import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

class Stack2 {
    public int solution(int[] priorities, int location) {
        int priority = priorities[location];

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++){
            queue.add(priorities[i]);
        }

        int count = 0;
        int pointer = location;

        while(true){
            int max = Collections.max(queue);
            int firstElement = queue.poll();
            if(firstElement == max){
                count ++;
                pointer --;
                if(max == priority && pointer == -1){
                    break;
                }
            } else {
                queue.add(firstElement);
                pointer --;
                if(pointer == -1){
                    pointer = queue.size()-1;
                }
            }
        }


        int answer = count;
        return answer;
    }
}