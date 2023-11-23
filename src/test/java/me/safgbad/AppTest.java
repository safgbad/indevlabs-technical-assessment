package me.safgbad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Optional;

public class AppTest {
    public void assertPresent(int[] arr, int expectedValue) {
        Optional<Integer> ans = App.findMissingNumber(arr);
        assertTrue(ans.isPresent());
        assertEquals(ans.get(), Integer.valueOf(expectedValue));
    }

    public void assertEmpty(int[] arr) {
        Optional<Integer> ans = App.findMissingNumber(arr);
        assertTrue(ans.isEmpty());
    }

// Arrays with no missing number

    @Test
    public void shouldReturnEmptyOptionalForArrayWithNoMissingNumber() {
        int[] arr = {3, 2, 5, 1, 4};
        assertEmpty(arr);
    }


// Sorted and not sorted arrays

    @Test
    public void shouldReturnCorrectValueForNotSortedArray() {
        int[] arr = {5, 0, 1, 3, 2};
        assertPresent(arr, 4);
    }

    @Test
    public void shouldReturnCorrectValueForSortedArray() {
        int[] arr = {7, 9, 10, 11, 12};
        assertPresent(arr, 8);
    }


// Arrays with negative numbers

    @Test
    public void shouldReturnCorrectValueForArrayWithNegativeNumbers() {
        int[] arr = {-5, -4, -2, -1};
        assertPresent(arr, -3);
    }

    @Test
    public void shouldReturnZeroForArrayWithOnlyZeroMissing() {
        int[] arr = {-3, 2, 1, -1, -2};
        assertPresent(arr, 0);
    }

    @Test
    public void shouldReturnZeroForArrayWithZeroAsFirstMissingNumber() {
        int[] arr = {-3, 2, -1, -2};
        assertPresent(arr, 0);
    }

    @Test
    public void shouldReturnCorrectValueForArrayWithMissingZeroButZeroIsNotTheSmallestMissingNumber() {
        int[] arr = {-3, 2, -1};
        assertPresent(arr, -2);
    }


// Arrays with several missing numbers

    @Test
    public void shouldReturnCorrectValueForArrayWithSeveralMissingNumbers() {
        int[] arr = {7, 9, 10, 12};
        assertPresent(arr, 8);
    }


// Arrays with duplicated numbers

    @Test
    public void shouldReturnCorrectValueForArrayWithDuplicatedNumbers() {
        int[] arr = {1, 2, 5, 2, 2, 3, 1, 5, 3};
        assertPresent(arr, 4);
    }


// Big values

    @Test
    public void shouldReturnCorrectValueForBigArray() {
        int[] arr = new int[999_999];
        int random = (int) (arr.length * Math.random());
        for (int i = 0; i < arr.length; i++) {
            if (i >= random) {
                arr[i] = i + 1;
            } else {
                arr[i] = i;
            }
        }
        assertPresent(arr, random);
    }

    @Test
    public void shouldReturnCorrectValueForArrayWithBigNumbers() {
        int[] arr = new int[100];
        int random = (int) (arr.length * Math.random());
        int start = Integer.MAX_VALUE - arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (i >= random) {
                arr[i] = start + i + 1;
            } else {
                arr[i] = start + i;
            }
        }
        assertPresent(arr, start + random);
    }
}
