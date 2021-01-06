public class StairCaseBruteForce {
    static int countWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return countWays(n - 3) + countWays(n - 2) + countWays(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("(0):" + countWays(0));
        System.out.println("(1):" + countWays(1));
        System.out.println("(2):" + countWays(2));
        System.out.println("(3):" + countWays(3));
        System.out.println("(4):" + countWays(4));
        System.out.println("(5):" + countWays(5));
        System.out.println("(6):" + countWays(6));
    }
}
