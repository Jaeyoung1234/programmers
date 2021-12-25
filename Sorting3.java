import java.util.ArrayList;
import java.util.Collections;

class Solution {
   public static int solution(int[] citations) {
        Arrays.sort(citations);

        int hIndex = 0;
        for(int i=0; i<citations.length; i++){
            if(citations[citations.length-1]>=citations.length){
                return citations.length;
            }
            if(i>=citations[i]){
                return i;
            }
        }

        return hIndex;
    }
    


}