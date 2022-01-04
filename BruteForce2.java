import java.util.Set;
import java.util.HashSet;

class BruteForce2 {
    public int solution(String numbers) {
        int answer = 0;
        Set<String> permutations = getPermutation(numbers);
        Set<Integer> allNumbers = new HashSet<>();
        for(String element : permutations){
            for(int i=0; i<element.length(); i++){
                for(int j=i+1; j<=element.length(); j++){

                    allNumbers.add(Integer.parseInt(element.substring(i, j)));
                }
            }
        }
        System.out.println(allNumbers);
        for(Integer element: allNumbers){
            if(isPrime(element)){
                System.out.println(element);
                answer++;
            }
        }
        return answer;
    }

    private static Set<String> getPermutation(String str){
        Set<String> permutations = new HashSet<String>();

        if(str == null){
            return null;
        }

        if(str.length() == 0){
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);

        String sub = str.substring(1);

        Set<String> words = getPermutation(sub);

        for(String element : words){
            for(int i=0; i<=element.length(); i++){
                permutations.add(element.substring(0,i)+first+element.substring(i));
            }
        }
        return permutations;
    }

    private static boolean isPrime(Integer num){
        if(num <= 1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i ==0){
                return false;
            }
        }
        return true;
    }
}