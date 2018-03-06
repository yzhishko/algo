/**
 * https://repl.it/@xnull/MaxSubArray
 *
 */
import java.util.*;
import java.lang.*;

class Main {
  public static void main(String[] args) {
    //List<Integer> list = Arrays.asList(1,2,3,4,5);
    List<Integer> list = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);
    
    
    int currMax = list.get(0);
    int max = currMax;
    
    for(int curr: list){
      currMax = Math.max(curr, currMax + curr);
      max = Math.max(currMax, max);
    }
    
    System.out.println(max);
  }
} 
