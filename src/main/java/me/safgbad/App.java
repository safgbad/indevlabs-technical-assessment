package me.safgbad;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class App {
    /**
     * Method accepts array of sequent numbers (not necessarily distinct) with one or several missing elements.
     *
     * @param arr array of sequent numbers
     * @return {@link Optional} of the smallest missing number if at least one number is missing.
     *         Otherwise, returns empty {@link Optional}.
     */
    public static Optional<Integer> findMissingNumber(int[] arr) {
        // If array's size is equal to 0 or 1, we can assert array has no missing numbers
        if (arr == null || arr.length < 2) return Optional.empty();
        // We'll need to know if array contains certain number or not. But searching for element in array is not fast.
        // Also, we are not interested in processing same number on several occasions when array has duplicates.
        // So we use HashSet to store unique members of array.
        Set<Integer> uniqueElements = new HashSet<>();
        // We'll need to know minimum and maximum values to check the presence of numbers
        // between them in the HashSet of unique numbers.
        int min = arr[0];
        int max = arr[0];
        // While filling the HashSet of unique numbers, we'll define minimum and maximum values in array.
        for (int num : arr) {
            uniqueElements.add(num);
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }
        // We'll be checking every number between minimum and maximum for presence in the HashSet of unique numbers.
        // First not found number is the answer.
        for (int num = min + 1; num < max; num++) {
            if (!uniqueElements.contains(num)) {
                return Optional.of(num);
            }
        }
        // If the HashSet of unique numbers contains all the values between minimum and maximum,
        // we can assert array has no missing values.
        return Optional.empty();
    }

    // NOTE. Let's denote arr.length as 'size'. We could say that array has no missing values before
    // checking (min, max) interval if we knew that numbers in array are distinct – condition would be
    // (max - min == size - 1).

    // NOTE. With assumption that all the numbers are distinct and there can be only one missing element,
    // we could solve the problem just in one cycle. The idea would be to sum up (arr[i] mod arr.length) using BigInteger.
    // Expected sum will be (size * (size - 1) / 2). Let's denote the difference between two sums as 'diff'.
    // If (diff == 0) then we add 'size' to diff (diff = diff == 0 ? size : diff).
    // Then missing element would be found as ((min div size) * size) + diff.
    // In this case we would have to pay special attention to situation when the missing number is zero
    // (i.e. using three flags doesContainPositiveNumbers, doesContainNegativeNumbers, doesContainZero =>
    // condition when we sure that missing value is zero would be
    // (doesContainPositiveNumbers && doesContainNegativeNumbers && !doesContainZero)).

    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        Optional<Integer> optionalOfMissingNumber = findMissingNumber(arr);
        if (optionalOfMissingNumber.isEmpty()) {
            System.out.println("There is no missing number in array");
        } else {
            System.out.println("First missing number is " + optionalOfMissingNumber.get());
        }
    }
}
