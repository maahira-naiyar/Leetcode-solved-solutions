class Solution {
    public int maxNumberOfFamilies(int n, int[][] s) {
        int ans = 0;
        boolean gph1, gph2, gph3;
        Map<Integer, boolean[]> map = new HashMap<>();
        int row;
        for (int[] data : s) {
            row = data[0] + 1;
            if (!map.containsKey(row)) {
                map.put(row, new boolean[10]);
            }
            map.get(row)[data[1] - 1] = true;

        }
        ans += (n - map.size()) * 2;
        for (boolean[] r : map.values()) {
            gph1 = false;
            gph2 = false;
            gph3 = false;
            if (!r[1] && !r[2] && !r[3] && !r[4]) {
                gph1 = true;
            }
            if (!r[3] && !r[4] && !r[5] && !r[6]) {
                gph2 = true;
            }
            if (!r[5] && !r[6] && !r[7] && !r[8])
                gph3 = true;
            if (gph1)
                ans++;
            if (gph3)
                ans++;
            if (!gph1 && gph2 && !gph3)
                ans++;

        }
        return ans;
    }
}