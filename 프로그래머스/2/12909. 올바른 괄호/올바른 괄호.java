import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack();
        
        if(s.charAt(0) == ')') return false;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                  if(stack.isEmpty()) {
                    return false;
                } else if(stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        
        if(stack.size() == 0) return true;
        return false;
    }
}