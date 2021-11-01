public int numSplits(String s) {
    int n = s.length();
    int[] prefix = new int[n];
    int[] suffix = new int[n];
    Set<Character> pSet = new HashSet<>();
    Set<Character> qSet = new HashSet<>();

    for (int i = 0; i < n; i++) {
        pSet.add(s.charAt(i));
        qSet.add(s.charAt(n - 1 - i));
        prefix[i] = pSet.size();
        suffix[n - 1 - i] = qSet.size();
    }

    int cnt = 0;
    for (int i = 1; i < n; i++) {
        if (prefix[i - 1] == suffix[i]) {
            cnt++;
        }
    }
    return cnt;
}