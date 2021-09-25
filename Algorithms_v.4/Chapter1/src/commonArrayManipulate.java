import java.util.Arrays;
public class commonArrayManipulate {
    // 1. find maximum number in array:
    public static double findMax(double[] a) {
        double max = a[0];
        for (int i = 0; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }


    // 2. average number in array
    public static double findAverage(double[] a) {
        int N = a.length;
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum += a[i];
        
        return sum / N; // override operators for different data types
    }

    // 3. copy array
    public static double[] copyArr(double[] a) {
        int N = a.length;
        double[] b = new double[N];
        for (int i = 0; i < N; i++) {
            b[i] = a[i];
        }
        // b = a : P12 1.1.5.4: alias， if a changed, b will be changed too.
        return b;
    }

    // 4. reverse array:
    public static double[] reverseArr(double[] a) {
        int N = a.length;

        for (int i = 0; i < N / 2; i++) {
            double tmp = a[i];
            a[i] = a[N - 1 - i];
            a[N - 1 - i] = tmp;
        }

        return a;
    }

    // 5. a[][] * b[][] = c[][] matrix Multiply
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        int N = a.length;
        double[][] c = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 选中行, 列
                for (int k = 0; k < N; k++) {
                    // 行i 和列j的点乘
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        } 
        return c;
    }

    public static void main(String[] args) {
        double[] a = {1.0, 2.0, 3.0, 10.20, 25.01, 7.8, 5.9, 3.1};
        System.out.println("find max: " + findMax(a));
        System.out.println("reverse: " + Arrays.toString(reverseArr(a)));
    }
}
