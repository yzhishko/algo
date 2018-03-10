//https://leetcode.com/problems/move-zeroes

class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 0, 3, 4, 5, 0, 6, 7, 0, 0, 9, 0, 11};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

        new HashMap<>() {{
            put(1, 1);
            put(1, 2);
        }}
    }

    static void moveZeroes(int[] nums) {

        int nextIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            if (nextIndex == i) {
                nextIndex++;
                continue;
            }

            nums[nextIndex] = nums[i];
            nums[i] = 0;

            nextIndex++;
        }
    }
}