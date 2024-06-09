package com.algorithm.array;

import java.io.*;
import java.util.*;

public class AllNumbersLessThanEachNumberInArray {
  private static AllNumbersLessThanEachNumberInArray myCode = new AllNumbersLessThanEachNumberInArray();

  public static void main(String[] args) {
    int[] nums = new int[]{4, 1, 2, 5, 4, 3, 6, 0, 1};
    // result = {5, 1, 3, 7, 5, 4, 8, 0, 1}

    // 1. array of int
    // 2. return number with number of occurences with n < i
    // return array with result
    // 3. Repeatation is possible
    test1();
  }

  public int[] findAllLessThan(int[] input) {
    var result = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      var count = 0;

      for (int j = 0; j < input.length; j++) {
        if (input[j] < input[i]) {
          count++;
        }
      }

      result[i] = count;
    }

    return result;
  }

  public int[] findAllLessThanOptimized(int[] input) {
    var result = new int[input.length];
    var sorted = Arrays.copyOf(input, input.length);
    Arrays.sort(sorted);
    //// 4, 1, 2, 5, 4, 3, 6, 0, 1

    // sorted = { 0, 1, 1, 2, 3, 4, 4, 5, 6}
    // i = 0, result = 0
    // i = 1, result = 1
    // i = 2, result = 1
    // i = 3, result = 3
    // i = 4, result = 5
    // sortedResults = {0, 1, 1, 3, 4, 5, 5, 7, 8}

    // var i = 0;
    // for(int k = 0; k < input.length; k++) {
    //   var current = input[k];
    //   // count = slice sorted from 0 to sorted.indexOf(current);
    //   var indexOfCurrent = sorted.indexOf(current);
    //   result[k] = Arrays.copyOfRange(0, indexOfCurrent).length;
    // }

    var map = new HashMap<Integer, Integer>();

    // result[0] = 0;
    map.put(0, 0);
    for (int i = 1; i < sorted.length; i++) {
      if (sorted[i - 1] == sorted[i]) {
        // result[i] = result[i-1];
        // map.put(i, map.get(sorted[i-1]));
      } else {
        // result[i] = i;
        map.put(sorted[i], i);
      }
    }

    for (int i = 0; i < input.length; i++) {
      result[i] = map.get(input[i]);
    }

    return result;
  }

  // From LeetCode solutions
  /*
  This solution maps the numbers in the array to a counter.
Since the numbers are between 0 and 100 I create an array of length 101 and iterate over the original array and put each number in the corresponding index in the bucket array. If the original array contains the number 1, number 1 goes to index 1 in the new array.

Since the nums array may contain duplicates, in the bucket array I store a counter for each of the numbers, not the number itself. So if the number 1 occurs 3 times in the nums array, in index 1 of the bucket array we store the value 3.

4 5 1 3 5 4 4 1 4 5 1 4
becomes
0 3 0 1 5 3

(0 zeros, 3 ones, 0 twos, 1 three, 5 fours and 3 fives)

After the bucket array has been populated, I iterate it again from index 1 to index 100 and to each of the values I add the previous value. A similar example with a smaller array:

0 3 0 1 5 3
becomes
0 3 3 4 9 12

(0 numbers are <= 0, 3 numbers are are <= 1, 3 numbers are are <= 2, 4 numbers are are <= 3 and so on.)

That way each position contains how many numbers are smaller or equal than the current position.

Finally I iterate the original nums array and get the index from bucket corresponding the value of the number from nums - 1 (minus one because without it we also get the ones equal to it and we only want smaller). When doing this I assign the result as the new value in the nums array instead of creating a new array. Also if value is 0 we automatically return 0 as no element can be smaller than it.

For example, if nums array is
4 5 1 3 5 4 4 1 4 5 1 4

and the final bucket mapping is:
0 3 3 4 9 12

buck[4-1] = 4
buck[5-1] = 9
buck[1-1] = 0
buck[3-1] = 3
buck[5-1] = 9
buck[4-1] = 4
buck[4-1] = 4
buck[1-1] = 0
buck[4-1] = 4
buck[5-1] = 9
buck[1-1] = 0
buck[4-1] = 4
   */
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] buck = new int[101];

    for(int i=0; i<nums.length; i++) {
      buck[nums[i]] +=1;
    }

    for(int j=1; j<= 100; j++) {
      buck[j] += buck[j-1];
    }

    for(int k=0; k< nums.length; k++) {
      int pos = nums[k];
      nums[k] = pos==0 ? 0 : buck[pos-1];
    }

    return nums;
  }


  private static void test1() {
    var input = new int[]{4, 1, 2, 5, 4, 3, 6, 0, 1};
    //var expected = new int[] {5, 1, 3, 6, 5, 4, 7, 0, 1};

    var actual = myCode.findAllLessThanOptimized(input);

    display(actual);
  }

  private static void display(int[] input) {
    for (int i = 0; i < input.length; i++) {
      System.out.println(input[i]);
    }
  }

}


