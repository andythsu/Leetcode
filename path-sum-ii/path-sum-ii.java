    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, targetSum, Arrays.asList(root.val)));
        while(!stack.isEmpty()){
            Node n = stack.pop();
            if(n.sum == n.node.val && n.isLeaf()){
                result.add(new ArrayList<>(n.path));
                continue;
            }
            
            // push left
            if(n.node.left != null){
                List<Integer> lList = new ArrayList<>(n.path);
                lList.add(n.node.left.val);
                stack.push(new Node(n.node.left, n.sum - n.node.val, lList));
            }
            
            // push right
            if(n.node.right != null){
                List<Integer> rList = new ArrayList<>(n.path);
                rList.add(n.node.right.val);
                stack.push(new Node(n.node.right, n.sum - n.node.val, rList));
            }
        }
        return result;
    }
}
