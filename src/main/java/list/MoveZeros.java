//https://leetcode.com/problems/move-zeroes

class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 0, 3, 4, 5, 0, 6, 7, 0, 0, 9, 0, 11};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        int nextInsert = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Analyse element: " + i + ", nextInsert = " + nextInsert + ", array: " + Arrays.toString(nums));

            if (nums[i] == 0) {
                continue;
            }

            if (nextInsert == i) {
                nextInsert++;
                continue;
            }

            nums[nextInsert] = nums[i];
            nextInsert++;
            nums[i] = 0;
        }
    }
}