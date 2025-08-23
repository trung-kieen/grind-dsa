import java.util.List; 
class Node<T>  { 
    public T data; 
    public List<Node<T>> nodes;
    public Node (){ 
    }
    public Node(T value){ 
        this.data = value; 
    }
    @Override 
    public String toString (){ 
        return String.valueOf(this.data); 
    }
    public static void main(String ... args){ 
        Node<String> n = new Node<>(); 
        Node<String> a = new Node<>("Kai"); 
        System.out.println(n); 
        System.out.println(a); 
    }
}
