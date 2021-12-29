class Graph1 {
    public int solution(int n, int[][] edge) {
        int V = n;
        int E = edge.length;
        int[] shortestPath = new int[V+1];
        boolean[] visited = new boolean[V+1];


        for (int i = 1; i <= V; i++) {
            shortestPath[i] = Integer.MAX_VALUE;
        }

        shortestPath[1] = 0;

        for(int i=0; i<V; i++){
            int nodeIndex = 0;
            int nodeValue = Integer.MAX_VALUE;
            for(int j=1; j<=V; j++){
                if(!visited[j] && shortestPath[j]<nodeValue){
                    nodeIndex = j;
                    nodeValue = shortestPath[j];
                }
            }
            visited[nodeIndex] = true;
            for(int j=0; j<E; j++){
                if(edge[j][0]==nodeIndex){
                    if(shortestPath[edge[j][1]] > nodeValue+1){
                        shortestPath[edge[j][1]] = nodeValue+1;
                    }
                } else if(edge[j][1] == nodeIndex){
                    if(shortestPath[edge[j][0]] > nodeValue+1){
                        shortestPath[edge[j][0]] = nodeValue+1;
                    }
                }
            }

        }

        int max = 0;
        for(int i=1; i<=V; i++){
            if(shortestPath[i] == Integer.MAX_VALUE ){
                continue;
            }else if(max < shortestPath[i]){
                max = shortestPath[i];
            }
        }

        int answer = 0;

        for(int i=1; i<=V; i++){
            if(shortestPath[i] == max){
                answer ++;
            }
        }

        for(int element : shortestPath){
            System.out.print(element);
            System.out.println();
        }




        return answer;
    }
}