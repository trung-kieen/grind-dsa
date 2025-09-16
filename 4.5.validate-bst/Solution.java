import java.util.List; 
import java.util.ArrayList; 
class Solution {
    public static class TreeNode<T extends Comparable<T>> {
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T data){
            this.val = data;
        }
        public TreeNode(T data, TreeNode<T> left, TreeNode<T> right){
            this.val = data;
            this.left = left;
            this.right = right;
        }

        public boolean validBST1(){
            return Solution.validBST1(this);
        }
        public boolean validBST2(){
            return Solution.validBST2(this);
        }
    }
    public static <T extends Comparable<T>> boolean validBST1(TreeNode<T> root){
        return validBST1(root, null, null);
    }
    public static <T extends Comparable<T>> boolean validBST1(TreeNode<T> root, T min, T max){
        if (root == null){
            return true;
        }
        if (root.left != null && root.left.val.compareTo(root.val) > 0 ) {
            return false;
        }

        if (max != null && max.compareTo(root.val) > 0) {
            return false;
        }

        if (root.right != null && root.right.val.compareTo(root.val) <= 0) {
            return false;
        }
        if (min != null && min.compareTo(root.val) <= 0 ) {
            return false;
        }

        return validBST1(root.left, root.val, max) && validBST1(root.right, min, root.val);
    }
    public static <T extends Comparable<T>> void iterateAndAddList(TreeNode<T> root, List<T> values){ 
        if (root == null){ 
            return; 
        }
        iterateAndAddList(root.left, values); 
        values.add(root.val); 
        iterateAndAddList(root.right, values); 
    }
    public static <T extends Comparable<T>> boolean validBST2(TreeNode<T> root){ 
        if (root == null){ 
            return false; 
        }
        List<T> values = new ArrayList<>(); 

        iterateAndAddList(root, values); 
        // Iterate with preorder 


        // PUsh value to a array 

        // Check if values array is sorted 
        T prev = values.get(0); 
        for (T val: values){ 
            // Next value must greater than previous 
            if (val.compareTo(prev) < 0) { 
                return false; 
            }
            prev = val; 
        }

        return true; 
    }
    public static void main(String [] args){
        TreeNode<Integer> bst = new TreeNode<>(5,
                new TreeNode<>(3,
                    new TreeNode<>(2), new TreeNode<>(4)
                ),
                new TreeNode<>(7,
                    new TreeNode<>(6), new TreeNode<>(8)
                )
        );
        assert bst.validBST1() : "ERROR Case 1: expect valid tree";
        assert bst.validBST2() : "ERROR Case 1: expect valid tree";

        // Case 2: Invalid BST
        TreeNode<Integer> notBst = new TreeNode<>(5,
                new TreeNode<>(3,
                    new TreeNode<>(2), new TreeNode<>(6) // ❌ 6 ở nhánh trái nhưng > 5
                ),
                new TreeNode<>(7)
        );
        assert ! notBst.validBST1() : "ERROR Case 2: expect invalid tree";
        assert ! notBst.validBST2() : "ERROR Case 2: expect invalid tree";
        System.out.println("AC");
    }

}
