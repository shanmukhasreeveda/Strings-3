// Time Complexity : O(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Initialize and Iterate: The code initializes variables and iterates through the string, processing each character to form numbers and detect operators.
//Apply Operators: Based on the last operator (lastsign), it performs the appropriate arithmetic operation (addition, subtraction, multiplication, or division) using a stack to handle intermediate results.
//Calculate Final Result: After processing all characters, it sums up all the values in the stack to get the final result.

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int curr =0;
        char lastsign = '+';
        Stack<Integer> st = new Stack<>();
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c- '0';
            }
            if((!Character.isDigit(c) && c!= ' ') || i == s.length()-1){
                if(lastsign == '+'){
                    st.push(+curr);
                }
                if(lastsign == '-'){
                    st.push(-curr);
                }
                if(lastsign == '*'){
                    st.push(st.pop () *curr);
                }
                if(lastsign == '/'){
                    st.push(st.pop()/curr);
                }
                lastsign = c;
                curr =0;
            }
        }
        int calc = 0;
        while(!st.isEmpty()){
            calc = calc + st.pop();
        }
        return calc;
    }
}