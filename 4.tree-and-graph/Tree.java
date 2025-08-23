// Just domain name class, nothing different with Node 
class Tree  { 
    Node root;
    public Tree (){  
    }
    public static Node node(String name, Node left, Node right) {
        Node n = new Node(name); 
        n.left = left; 
        n.right = right; 
        return n; 
    }

    public void inOrderTraversal(Node node, Traver traver){ 
        if (node == null ){ 
            return; 
        }
        this.inOrderTraversal(node.left, traver); 
        traver.act(node); 
        this.inOrderTraversal(node.right, traver); 
    }
    public void inOrderTraversal(Node node){ 
        this.inOrderTraversal(node, System.out::println); 
    }
    public void inOrderTraversal(){ 
        this.inOrderTraversal(this.root); 
    }
    public void inOrderTraversal(Traver traver){ 
        this.inOrderTraversal(this.root, traver); 
    }
    public static void main(String [] args){ 

        Tree tree = new Tree();

        // Build tree in one shot
        tree.root = node("A",
                node("B",
                        node("D", null, null),
                        node("E", null, null)),
                node("C",
                        node("F", null, null),
                        node("G", null, null))
        );

        System.out.println("Inorder traversal:");
        tree.inOrderTraversal(); 
        tree.inOrderTraversal((node) -> { 
            System.out.print(node + " "); 
        }); 
    }

}

