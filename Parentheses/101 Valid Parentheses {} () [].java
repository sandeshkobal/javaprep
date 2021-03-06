Input: "([)]"
Output: false 
Input: "()[]{}"
Output: true
Input: "{[]}"
Output: true

class Solution {
// Very smart 
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
   /* public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i)); 
                continue;
           } 
           if(stack.isEmpty()) return false;
           if(s.charAt(i) == ')' && stack.peek() == '(') stack.pop();
           else if(s.charAt(i) == '}' && stack.peek() == '{') stack.pop();
           else if(s.charAt(i) == ']' && stack.peek() == '[') stack.pop();
           else return false;
        } 
        if(stack.isEmpty())
            return true;
        return false;
    } */
    
}
