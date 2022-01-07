class Greedy3 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = -1;
        char max = 0;

        for(int i=0; i<number.length()-k; i++){
            max = 0;
            for(int j=index +1; j<=k+i; j++){
                if(max < number.charAt(j)){
                    index = j;
                    max = number.charAt(j);
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}