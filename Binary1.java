class Binary1 {
   public long solution(int n, int[] times) {

        long minEvalTime = 1000000000;

        for(int i=0; i<times.length; i++){
            if(minEvalTime > times[i]){
                minEvalTime = times[i];
            }
        }

        long high = minEvalTime * n;
        long low = 0;
        long guess = 0;
        long answer = 0;
        int endType = 1;

        while(low < high){
            guess = (high + low)/2;
            long totalCapacity = calculateCapacity(times, guess);
            if(n<=totalCapacity){
                high = guess -1 ;
                if (calculateCapacity(times, guess - 1) < n) {
                    answer = guess;
                    break;
                }
            }
            else if(n>totalCapacity){
                low = guess + 1;
                if(calculateCapacity(times, guess + 1) >= n){
                    answer = guess+1;
                    break;
                }

            }
                }


        return answer;

    }

    public static long calculateCapacity(int[] times, long time){
        long totalCapacity = 0;
        for(int i=0; i<times.length; i++){
            totalCapacity += time/times[i];
        }

        return totalCapacity;
    }
}