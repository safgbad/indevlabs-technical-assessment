# indevlabs-technical-assessment
Test task for Indevlabs

## Approach
1. Create an empty HashSet to store unique elements of the array.
2. Iterate through the array from left to right.
3. Add each element to HashSet. Define the biggest (max) and the smallest (min) numbers.
4. Check every number from min to max (both excluded) for presence in HashSet.
5. First not found in HashSet number is the answer.
6. If HashSet contains all the numbers between min and max, then assert array has no missing number.

#### Space complexity: O(n)
#### Expected time complexity: O(n)
#### Worst time complexity: O(n^2)
