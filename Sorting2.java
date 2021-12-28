import java.util.Arrays;
import java.util.Comparator;

class Sorting2 {
    public String solution(int[] numbers) {
        String[] convertedNumbers = new String[numbers.length];
        for(int i=0; i<convertedNumbers.length; i++){
            convertedNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(convertedNumbers, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                    return (s1+s2).compareTo(s2+s1);
                }
        });

        String answer = "";

        for(int i=convertedNumbers.length-1; i>=0; i--){
            answer += convertedNumbers[i];
        }
        
        int sum =0;
        for(int i=0; i<convertedNumbers.length; i++){
            sum+= Integer.parseInt(convertedNumbers[i]);
        }
        if(sum == 0){
            return "0";
        }
        return answer;
    }

    }

