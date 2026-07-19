	class Solution {
	    public String smallestSubsequence(String s) {
	        int[] last = new int[256];
	        for (int i = 0; i < s.length(); ++i)
	            last[s.charAt(i)] = i;
	        boolean[] seen = new boolean[256];
	        StringBuilder stack = new StringBuilder();
	        for (int i = 0; i < s.length(); ++i) {
	            char c = s.charAt(i);
	            if (seen[c]) continue;
	            while (stack.length() > 0 && c < stack.charAt(stack.length() - 1) && i < last[stack.charAt(stack.length() - 1)]) {
	               seen[stack.charAt(stack.length() - 1)] = false;
	                stack.deleteCharAt(stack.length() - 1);
	            }
	            stack.append(c);
	            seen[c] = true;
	        }
	        return stack.toString();
	    }
	}