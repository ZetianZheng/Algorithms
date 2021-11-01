public class v2 {
        public int minDominoRotations(int[] A, int[] B) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= 6; i++) {
                min = Math.min(min, getRotation(A, B, i));
                min = Math.min(min, getRotation(B, A, i));
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }
        
        private int getRotation(int[] A, int[] B, int n) {
            int res = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == n) {
                    continue;
                }
                if (B[i] != n) {
                    return Integer.MAX_VALUE;
                }
                res++;
            }
            return res;
        }
}
