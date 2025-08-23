class Node { 
    public String name; 
    public Node left; 
    public Node right; 
    public Node(String name) { 
        this.name = name; 
    }
    @Override
    public String toString(){ 
        return this.name; 
    }
}
