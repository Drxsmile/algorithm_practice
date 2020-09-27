import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class CombineTest{
	public static void main(String[] args) {
		int[] nums = {2, 6, 8};
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		for(int k = 0; k <= nums.length; k++){
			combine(nums, k, new ArrayList<Integer>(), results);
		}
		System.out.println(results);
	}

	public static void combine(int[] nums, int k, 
		ArrayList<Integer> cur, List<List<Integer>> results){
		// base case
		if(k == 0){
			results.add(new ArrayList<Integer>(cur));
			return;
		}
		// recursion
		for (int i = cur.size(); i <= nums.length - k; i++) {
			if(cur.size() != 0 && cur.get(cur.size()-1) >= nums[i]){
				continue;
			}
			cur.add(nums[i]);
			combine(nums, k-1, cur, results);
			cur.remove(cur.size() - 1);
		}
	}

}