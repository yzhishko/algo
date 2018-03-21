import java.util.*;

public class Main {

    public static void main(String[] arr) {
        //int i = 5;
        for(int i =2; i < 10; i++){
          System.out.println(i + ":" + new Fibonacci().fibBottomUp(i));
        }
    }
}

class Fibonacci {
  
  long fib2(long n){
    if(n == 1){
      return 1;
    }
    
    long prev = 1;
    long prevPrev = 0;
    
    long result = 0;
    
    for(int i = 1; i < n; i++){
      result = prev + prevPrev;
      prevPrev = prev;
      prev = result;
    }
    
    return result;
  }
  
  int fibBottomUp(int n){
    Map<Integer, Integer> mem = new HashMap<>();
    
    mem.put(0, 1);
    mem.put(1, 1);
    
    for(int i = 2; i < n; i++){
      mem.put(i, mem.get(i-1) + mem.get(i-2));
    }
    
    return mem.get(n-1);
  }
  
  int fib3(int n){
    return fibTopDown(n, new HashMap<>());
  }
  
  int fibTopDown(int n, Map<Integer, Integer> mem){
    
    if(mem.keySet().contains(n)){
      return mem.get(n);
    }
    
    if(n <= 1) {
      mem.put(n, 1);
    } else {
      mem.put(n, fib3(n-1) + fib3(n-2));
    }
    
    return mem.get(n);
  }
}
