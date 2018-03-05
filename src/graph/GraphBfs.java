import java.util.*;

class Main {
  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.add(1,2);
    graph.add(1,3);
    graph.add(2,3);
    graph.add(3,4);
    
    graph.bfs(1);
  }
  
  static class Graph {
    Map<Integer, Set<Integer>> adjacents = new HashMap<>();
    
    void add(int vertex, int adjacent){
      if(adjacents.get(vertex) == null){
        adjacents.put(vertex, new HashSet<>());
      }
      
      if(adjacents.get(adjacent) == null){
        adjacents.put(adjacent, new HashSet<>());
      }
      
      adjacents.get(vertex).add(adjacent);
    }
    
    void bfs(int vertex){
      Queue<Integer> queue = new LinkedList<>();
      queue.add(vertex);
      
      Set<Integer> visited = new HashSet<>();
      
      while(!queue.isEmpty()){
        int currVertex = queue.poll();
        
        System.out.print(currVertex + " ");
        
        for(int adjacent: adjacents.get(currVertex)){
          if(visited.contains(adjacent)){
            continue;
          }
          visited.add(adjacent);
          queue.add(adjacent);
        }
      }
    }
  }
}
