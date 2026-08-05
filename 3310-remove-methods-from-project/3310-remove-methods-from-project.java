class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : invocations) {
            adj.get(e[0]).add(e[1]);
        }
        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(k);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj.get(cur)) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    queue.add(next);
                }
            }
        }
        for (int[] e : invocations) {
            int a = e[0], b = e[1];
            if (suspicious[b] && !suspicious[a]) {
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) all.add(i);
                return all;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) result.add(i);
        }
        return result;
    }
}