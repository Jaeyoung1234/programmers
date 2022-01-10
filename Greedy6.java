import java.util.*;

class Greedy6 {
    public int solution(int[][] routes) {
        int answer = 0;

        ArrayList<int[]> routeList = new ArrayList<>();
        for(int[] element : routes){
            routeList.add(element);
        }

        Collections.sort(routeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] route1, int[] route2){
                if(route1[1] == route2[1]){
                    return 0;
                }
                return route1[1] > route2[1] ? 1 : -1;
            }
        });


        Iterator iterator =  routeList.iterator();

        while(iterator.hasNext()){
            int position = routeList.get(0)[1];


            for(int i=0; i<routeList.size(); i++){
                if(routeList.get(i)[0] <= position){
                    routeList.remove(i);
                    i--;
                }
            }
            answer ++;
        }


        return answer;
    }
}