import java.lang.*;
import java.util.*;

/**
* https://leetcode.com/discuss/interview-question/124919/Remove-Substring-Recursively/
*/
public class Main {
    public static void main(String[] a) {
      String str = "aabcbc";
      String pattern = "abc";
      
      int index = 0;
      int times = 0;
      
      System.out.println(times(str, pattern));
    }
    
    static int times(String str, String pattern){
      int idx = str.indexOf(pattern);
      
      if(idx == -1){
        return 0;
      }
      
      return times(str.substring(0, idx) + str.substring(idx + pattern.length()), pattern)+1;
    }
}
