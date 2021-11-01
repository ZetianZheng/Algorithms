class v1 {
    public int numSplits(String s) {
        char[] chrs = s.toCharArray();
        int len = s.length();
        int[] pref = new int[len];
        int[] suff = new int[len];
        pref[0] = 1;
        suff[len - 1] = 1;
        Set<Character> setPref = new HashSet<>();
        setPref.add(chrs[0]);
        for (int i = 1; i < len; i++) {
            if (setPref.contains(chrs[i])) {
                pref[i] = pref[i - 1];
                continue;
            }
            
            setPref.add(chrs[i]);
            pref[i] = pref[i - 1] + 1;
        }
        // System.out.println(Arrays.toString(pref));
        
        Set<Character> setSuff = new HashSet<>();
        setSuff.add(chrs[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            if (setSuff.contains(chrs[i])) {
                suff[i] = suff[i + 1];
                continue;
            }
            
            setSuff.add(chrs[i]);
            suff[i] = suff[i + 1] + 1;
        }
        
        int ret = 0;
        for (int i = 0;i < len - 1; i++) {
            if (pref[i] == suff[i + 1])
                ret++;
        }
        
        // System.out.println(Arrays.toString(suff));
        
        return ret;
    }
}