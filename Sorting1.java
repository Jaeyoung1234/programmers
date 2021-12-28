import java.util.Arrays;

class Sorting1 {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int location = commands[i][2];
            int[] slicedArray = new int[end-start+1];
            for(int j=0; j<slicedArray.length; j++){
                slicedArray[j] = array[start+j-1];
            }
            Arrays.sort(slicedArray);
            answer[i] = slicedArray[location-1];
        }
        return answer;
    }
}