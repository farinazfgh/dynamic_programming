public class Recursion {
    static void print(int[] array, int index) {
        if (index == array.length) {
            return;
        }
        System.out.println(array[index]);
        print(array, index + 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        print(array, 0);
        System.out.println(sum(array, 0));
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
}
