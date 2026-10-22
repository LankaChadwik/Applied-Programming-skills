import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] count;
    private int[] indexes;
    private int[] temp;
    private int[] tempIndexes;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        indexes = new int[n];
        temp = new int[n];
        tempIndexes = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }
        return result;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int rightCounter = 0;

        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                tempIndexes[k] = indexes[j];
                rightCounter++;
                j++;
            } else {
                tempIndexes[k] = indexes[i];
                count[indexes[i]] += rightCounter;
                i++;
            }
            k++;
        }

        while (i <= mid) {
            tempIndexes[k] = indexes[i];
            count[indexes[i]] += rightCounter;
            i++;
            k++;
        }

        while (j <= right) {
            tempIndexes[k] = indexes[j];
            j++;
            k++;
        }

        for (int p = left; p <= right; p++) {
            indexes[p] = tempIndexes[p];
        }
    }
}