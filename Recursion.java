public class Recursion {
    static void print(int[] array, int index) {
        if (index == array.length) {
            return;
        }
        System.out.println(array[index]);
        print(array, index + 1);
    }

    //what do we need in a loop a counter to keeps the index so pass it
    //recursion termination condition? we reached the end of array
    //return value the value of current index + what have been summed up to this index which is the return value
    static int sum(int[] array, int index) {
        if (index == array.length) {
            return 0;
        }
        return (array[index] + sum(array, index + 1));
    }
    static int sumR(int[] array, int index, int sum) {
        if (index == array.length) return sum;
        sum += array[index];
        return sumR(array, index + 1, sum);

    }

    static int sum(int[] array) {
        return sumR(array, 0, 0);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sumI = 0;
        for (int value : array) sumI += value;
        System.out.println(sumI);
        System.out.println(sum(array));
        System.out.println((array.length * (array.length + 1)) / 2);
    }
}
