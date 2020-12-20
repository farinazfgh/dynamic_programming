//https://www.codesdope.com/course/algorithms-rod-cutting/
class Rod {
    static final int INF = 100000;


    public static int bottomUpRodCutting(int[] c, int n) {
        int[] r = new int[n + 1];
        r[0] = 0;
        int i, j;

        for (j = 1; j <= n; j++) {
            int maximumRevenue = -1 * INF;
            for (i = 1; i <= j; i++) {
                maximumRevenue = Math.max(maximumRevenue, c[i] + r[j - i]);
            }
            r[j] = maximumRevenue;
        }
        return r[n];
    }

    public static int topDownRodCuttingR(int[] c, int n) {
        int[] r = new int[5 + 1];
        return topDownRodCutting(c, n, r);
    }

    public static int topDownRodCutting(int c[], int n, int[] r) {
        if (r[n] >= 0) {
            return r[n];
        }

        int maximumRevenue = -1 * INF;
        int i;

        for (i = 1; i <= n; i++) {
            maximumRevenue = Math.max(maximumRevenue, c[i] + topDownRodCutting(c, n - i, r));
        }

        r[n] = maximumRevenue;
        return r[n];
    }


    public static void main(String[] args) {
        // array starting from 1, element at index 0 is fake
        int c[] = {0, 10, 24, 30, 40, 45};
        System.out.println(bottomUpRodCutting(c, 5));
    }
}