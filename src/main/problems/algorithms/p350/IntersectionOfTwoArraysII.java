package problems.algorithms.p350;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static utils.PrintUtils.print;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk,
 * and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> results = new ArrayList<>();
        for (int i1 = 0, i2 = 0; i1 < nums1.length && i2 < nums2.length;) {
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] > nums2[i2]){
                i2++;
            } else {
                results.add(nums1[i1]);
                i1++;
                i2++;
            }
        }

        int[] intersection = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            intersection[i] = results.get(i);
        }
        return intersection;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();

        int[] intersect1 = intersectionOfTwoArraysII.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        print(Arrays.stream(intersect1).boxed().collect(Collectors.toList()));

        int[] intersect2 = intersectionOfTwoArraysII.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        print(Arrays.stream(intersect2).boxed().collect(Collectors.toList()));

    }
}
