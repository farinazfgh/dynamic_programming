public class FibonacciTopDownWithoutMemoization {
    static int numberOfRecursiveCalls = 0;

    static int fibonacci(int n) {
        numberOfRecursiveCalls++;
        if (n == 1 || n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        System.out.println(fibonacci(6));
        System.out.println(numberOfRecursiveCalls);
    }

}
