import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        TreeSet<Integer> subArr = new TreeSet<Integer>();
        
        for(int i =0; i< a.length;i++){
            subArr.add(a[i]);
                
            Iterator<Integer> iter = subArr.iterator();
            double first = subArr.first();
            double second = subArr.first();
            
            int offset = 0;
            while(offset <= subArr.size()/2) {
                offset++;
                first = second;
                second = iter.next();
            }
            
            if(subArr.size() %2 == 0){
               System.out.println((first+second)/2); 
            } else{
                System.out.println(second);
            }
        }
    }
}
