class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();

        int noReplace = 0;
        int oneReplace = 0;

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            int prevNo = noReplace;
            int prevOne = oneReplace;

            if (prevNo < n && s.charAt(prevNo) == ch) {
                noReplace = prevNo + 1;
            }

            int nextOne = prevOne;

            if (prevOne < n && s.charAt(prevOne) == ch) {
                nextOne = prevOne + 1;
            }

            if (prevNo < n) {
                nextOne = Math.max(nextOne, prevNo + 1);
            }

            oneReplace = nextOne;
        }

        return noReplace == n || oneReplace == n;
    }
}