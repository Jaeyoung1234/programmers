class Stack3 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();

        for(int i=0; i<bridge_length; i++){
            bridge.add(0);
        }
        for(int i=0; i<truck_weights.length; i++){
            trucks.add(truck_weights[i]);
        }

        int weightSum = 0;
        while(!trucks.isEmpty() || weightSum !=0){
            int nextWeight = 0;

            if(!bridge.isEmpty()){
                int lastWeight = bridge.poll();
                weightSum -= lastWeight;
            }

            if(!trucks.isEmpty()){
                if(weightSum + trucks.peek() <= weight){
                    nextWeight = trucks.poll();
                    weightSum += nextWeight;
                }
            }
            bridge.add(nextWeight);

            answer++;
        }
        return answer;
    }
}