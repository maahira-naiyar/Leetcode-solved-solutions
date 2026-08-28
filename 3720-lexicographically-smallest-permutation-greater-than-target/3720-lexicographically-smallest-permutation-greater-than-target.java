class Solution {
    public String lexGreaterPermutation(String s, String target) {
        final int size = s.length();
        int[] freq = new int[26];

        for (final char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int idx = 0;

        while (idx < size) {
            int c = target.charAt(idx) - 'a';

            if (freq[c] == 0) {
                break;
            } else {
                freq[c]--;
                idx++;
            }
        }


        while (idx >= 0) {
            if (idx < size) {
                int curr = target.charAt(idx) - 'a';

                for (int next = curr + 1; next < 26; next++) {

                    if (freq[next] > 0) {
                        StringBuilder ans = new StringBuilder( target.substring(0, idx) );
                        ans.append( (char) (next + 'a') );
                        freq[next]--;
                        for (int i = 0; i < 26; i++) {
                            char ch = (char) (i + 'a');

                            while (freq[i] > 0) {
                                ans.append(ch);
                                freq[i]--;
                            }
                        }

                        return ans.toString();
                    }
                }
            }


            if (idx > 0) {
                freq[target.charAt(idx - 1) - 'a']++;
            }

            idx--;
        }

        return "";
    }
}