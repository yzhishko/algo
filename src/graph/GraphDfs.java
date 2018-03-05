import java.util.*;

class Main {
  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.add(1,2);
    graph.add(1,3);
    graph.add(2,4);
    graph.add(3,5);
    
    graph.findDfs(1);
  }
  
  static class Graph {
    Map<Integer, Set<Integer>> adjacents = new HashMap<>();
    
    void add(int vertex, int adjacent) {
      if(adjacents.get(vertex) == null){
        adjacents.put(vertex, new HashSet<>());
      }
      
      adjacents.get(vertex).add(adjacent);
    }
    
    void dfs(int vertex, Set<Integer> visited) {
      System.out.print(vertex + " ");
      Set<Integer> vertexAdjacents = adjacents.get(vertex);
      
      if(vertexAdjacents == null) {
        return;
      }
      
      for(int currAdj: vertexAdjacents) {
        if(visited.contains(currAdj)) {
          continue;
        }
        
        dfs(currAdj, visited);
      }
    }
    
    void findDfs(int vertex) {
      dfs(vertex, new HashSet<>());
    }
  }
}
