import java.util.LinkedList;
public class v1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        // empty intervasl
        if (n == 0) {
            return new int[][]{newInterval};
        }

        LinkedList<int[]> ret = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // newInterval been inserted
            if (newInterval[1] < intervals[i][0]) {
                ret.add(newInterval);
                while (i < n) {
                    ret.add(intervals[i++]);
                }
                break;
            }

            // newInterval not start
            if (newInterval[0] > intervals[i][1]) {
                ret.add(intervals[i]);
            } else { // merge: start <= intervals[i][1]; intervals[i][0] <= end
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }

            // last interval
            if (i == n -1) {
                ret.add(newInterval);
            }

        }

        return ret.toArray(new int[ret.size()][2]); // 合并后的区间个数。
    }
}
