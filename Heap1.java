import java.util.PriorityQueue;

class Heap1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        while(pq.peek()<K){
            int scoville1 = pq.poll();
            if(pq.isEmpty()){
                answer = -1;
                break;
            }
            int scoville2 = pq.poll();
            pq.add(scoville1+scoville2*2);
            answer++;
        }
        
        return answer;
    }
}