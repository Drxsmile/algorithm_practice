public class BinaryTreeTraversal{
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
		}
	}
	public static void main(String[] args) {
		//TODO: build a tree
		levelOrder(root, )
	}
	public void levelOrder(TreeNode root){
		if(root == null) return;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			TreeNode top = q.poll();
			System.out.println(top.val);
			if (top.left != null) {
				q.offer(top.left);
			}
			if (top.right != null) {
				q.offer(top.right);
			}
		}
		return;
	}
	public List<List<Integer>> levelOrderTwoQueues(TreeNode root) {
        if(root == null) return new ArrayList();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!q1.isEmpty() || !q2.isEmpty()){
            res.add(new ArrayList<Integer>());
            while(!q1.isEmpty()){
                TreeNode cur = q1.poll();
                if(cur.left != null){
                    q2.offer(cur.left);
                }
                if(cur.right != null){
                    q2.offer(cur.right);
                }
                res.get(res.size()-1).add(cur.val);
            }
            while(!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrderTwoQueues2(TreeNode root) {
        if(root == null) return new ArrayList();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!q1.isEmpty() || !q2.isEmpty()){
            res.add(new ArrayList<Integer>());
            while(!q1.isEmpty()){
                TreeNode cur = q1.poll();
                if(cur.left != null){
                    q2.offer(cur.left);
                }
                if(cur.right != null){
                    q2.offer(cur.right);
                }
                res.get(res.size()-1).add(cur.val);
            }
            while(!q2.isEmpty()){
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrderWithNull(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(null);
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null && !q.isEmpty()){
                res.add(new ArrayList());
                q.offer(null);
            }else if(cur != null){
                res.get(res.size()-1).add(cur.val);
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrderQueueSize(TreeNode root) {
        if(root == null) return new ArrayList();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int k = q.size();
            res.add(new ArrayList());
            while(k-- != 0){
                TreeNode cur = q.poll();
                res.get(res.size()-1).add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }
        return res;
    }
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    public void dfs(TreeNode root, List<List<Integer>> res, int level){
    	//base case
    	if(root == null) return;
    	if(level > res.size()-1){
    		res.add(new ArrayList());
    	}
    	//recursion
    	res.get(level).add(root.val);
    	dfs(root.left, res, level+1);
    	dfs(root.right, res, level+1);
    }
}