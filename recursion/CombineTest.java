import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class CombineTest{
	public static void main(String[] args) {
		int[] nums = {2, 6, 8};
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		// Solution 1
		// for(int k = 0; k <= nums.length; k++){
		// 	combine(nums, k, new ArrayList<Integer>(), results);
		// }
		// Solution 2
		// com(nums, 0, new ArrayList<Integer>(), results);
		//Solution 3 can't get it,why? related to tree
		combination(results, nums, 0, new ArrayList<Integer>());
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

	public static void com(int[] nums, int index, 
		ArrayList<Integer> cur, List<List<Integer>> results){
		// base case
		if(index == nums.length){
			results.add(new ArrayList<Integer>(cur));
			return;
		}

		// recursion
		com(nums, index +1, cur, results);
		cur.add(nums[index]);
		com(nums, index +1, cur, results);
		cur.remove(cur.size()-1);
	}

	public static void combination(List<List<Integer>> results, 
                        int[] nums, int index,
                        ArrayList<Integer> items) {
	    if (index == nums.length) {
	      results.add(new ArrayList<Integer>(items));
	      return;
	    }
	    for (int i = index; i < nums.length; i++) {
	      items.add(nums[i]);
	      combination(results, nums, i+1, items);
	      items.remove(items.size()-1);
	    }
	    combination(results, nums, nums.length, items);
	}

}








