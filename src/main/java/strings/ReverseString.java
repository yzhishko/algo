import java.lang.*;

class Solution {
    
    public String reverseWords(String s) {
        StringBuffer result = new StringBuffer();
        
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == ' '){
                while(!stack.isEmpty()) {
                    result.append(stack.pollFirst());
                }
                result.append(' ');
            }else {
                stack.addFirst(s.charAt(i));
            }
        }
        while(!stack.isEmpty()) {
           result.append(stack.pollFirst());
        }
        return result.toString();        
    }
    
    public String simpleReverse(String s){
        String[] words = s.split(" ");
        
        StringBuilder result = new StringBuilder();
        
        for(String word: words){
          StringBuffer reversed = new StringBuffer(word).reverse();
          result.append(reversed);
        }
        
        return result.toString().trim();
    }
}
