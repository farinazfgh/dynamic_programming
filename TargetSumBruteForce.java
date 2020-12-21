public class TargetSumBruteForce {
    //since we have two operators + and - we call the function inside twice
    //therefore like every function that calls itself twice it is O(2^n)
    //if it was three operations then it was O(3^n)

    static int targetSum(int[] numbers, int target) {
        return targetSum(numbers, target, 0, 0);
    }

    static int targetSum(int[] numbers, int target, int i, int sum) {
        // When we've gone through every item, see
        // if we've reached our target sum
        if (i == numbers.length) {
            return sum == target ? 1 : 0;
        }
        // Combine the possibilities by adding and
        // subtracting the current value
        //notice that we have no global variables
        //the recursive calls are self-contained every required information is passed as arguments
        return
                targetSum(numbers, target, i + 1, sum + numbers[i]) +
                        targetSum(numbers, target, i + 1, sum - numbers[i]);
    }

    public static void main(String[] args) {
        int[]  numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(targetSum( numbers, target));
    }
}
