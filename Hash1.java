import java.util.*;

class Hash1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String element : participant){
            if(map.get(element)==null){
                map.put(element, 1);
                continue;
            }map.put(element, map.get(element)+1);
        }
        for(String element : completion){
            map.put(element, map.get(element)-1);
        }
        
        for(String element : map.keySet()){
            if(map.get(element)!=0){
                answer = element;
            }
        }
        return answer;
    }
}