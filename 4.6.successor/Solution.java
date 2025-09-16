class Solution { 

    public static class TreeNode<T extends Comparable<T>> { 
        public T val; 
        public TreeNode<T> left; 
        public TreeNode<T> right; 
        public TreeNode<T> parent; 
        public TreeNode(T val){ 
            this.val = val; 
        }
        public TreeNode(T val, TreeNode<T> left, TreeNode<T> right, TreeNode<T> parent){ 
            this.val = val; 
            this.left = left;
            this.right = right; 
            this.parent = parent; 
        }
        public TreeNode(T val, TreeNode<T> left, TreeNode<T> right){ 
            this(val, left, right, null); 
        }
        
    }
    // public static TreeNode<T> successor(TreeNode<T> node){
        
    // }


    public static <T extends Comparable<T>> TreeNode<T> leftMost(TreeNode<T> node){ 
        if (node == null){ 
            return null; 
        }
        if (node.left != null){ 
            return leftMost(node.left); 
        }
        return node; 
    }
    public static <T extends Comparable<T>> TreeNode<T> successor(TreeNode<T> node){ 
        if (node == null){ 
            return null;
        }



        // If have the right node 
        // => Successor is the left most of right node 
        if (node.right != null){ 
            return leftMost(node.right); 
        // If current not have right node 
        }else { 
            // Get parrent pointer 
            TreeNode<T> parent = node.parent; 
            TreeNode<T> current = node; 

            // While p.right == current  => go backward 
            while (parent.right != null && parent.right == current){ 
                current = parent; 
                parent = current.parent; 
            }

            // If current is the left parrent => return parrent because it will bigger because of the BST 
            return parent;


        }






    }


    public static void main (String[] args){ 
        // The order mst 3 -> 5 -> 10 -> 15 
        
        TreeNode<Integer> treeRoot = new TreeNode<>(4); 
        TreeNode<Integer> a = new TreeNode<>(2); 
        TreeNode<Integer> b = new TreeNode<>(1); 
        TreeNode<Integer> c = new TreeNode<>(3); 
        TreeNode<Integer> d = new TreeNode<>(7); 
        treeRoot.left = a; 
        treeRoot.right = d; 
        a.left = b; 
        a.right = c;


        assert Solution.successor(b) == a : "ERROR Case 1"; 
        assert Solution.successor(a) == c : "ERROR Case 2";
        assert Solution.successor(c) == treeRoot  : "ERROR Case 3";
        assert Solution.successor(treeRoot) == d : "ERROR Case 4";

        System.out.print("AC"); 
    }


}
