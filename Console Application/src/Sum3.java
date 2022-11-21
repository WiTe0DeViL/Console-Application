import java.util.Arrays;

public class Sum3 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == target) return target;
                else if (Math.abs(nums[i] + nums[j] + nums[k] - target) < diff) {
                    diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    ans = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] < target) j++;
                else k--;
            }
        }
        return ans;
    }
}