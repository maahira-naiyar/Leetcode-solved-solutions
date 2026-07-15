class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        String ans ="";
        String rev ="";
        for(int i=0;i<s.length();i++){
            if(st.isEmpty()){
            st.push(s.charAt(i));
            continue;
            }
            if(st.peek()== s.charAt(i))
                {st.pop();
            }else{
                //stack.peek() != s.CharAt[i];
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            ans = ans + st.pop();
        }
        for(int j= ans.length()-1;j>=0;j--){
            rev = rev+ ans.charAt(j);
        }
    
    return rev;
    }
}