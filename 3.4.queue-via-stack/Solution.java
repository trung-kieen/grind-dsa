import java.util.Deque;
import java.util.ArrayDeque;
public class Solution{ 
    private static class MyQueue{ 
        
        Deque<Integer> q1; 
        Deque<Integer> q2; 
        public MyQueue() {
            q1 = new ArrayDeque<>(); 
            q2 = new ArrayDeque<>(); 
        }

        public void push(Integer value){ 
            q1.push(value); 
        }
        public Integer pop(){
            if (q2.isEmpty()){  
                // Push value from q1 to q2 
                // Flush 
                while(!q1.isEmpty()){ 
                    q2.push(q1.pop()); 
                }
            }
            return q2.pop(); 
        }
    }

    public static void main(String [] args){ 
        var q = new MyQueue(); 
        q.push(1);
        q.push(2);
        q.push(-1);
        System.out.println(q.pop()); 
        System.out.println(q.pop()); 
        q.push(-2);
        System.out.println(q.pop()); 
        System.out.println(q.pop()); 
    }
}
