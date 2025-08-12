import java.util.Deque; 
import java.util.ArrayDeque; 
import java.lang.Comparable; 
/* 
 * Approach 3: use min_stack to keep track the min 
 * Update the min to the min_stack if it smaller than current min value in min_stack 
 * If the min value is pop out of the stack => pop the min value in the min_stack
 */
public class Solution { 
    
    private static class MinStack<T extends Comparable<T>>{ 
        
        Deque<T> stack = new ArrayDeque<>(); 
        Deque<T> minStack = new ArrayDeque<>(); 
        public void push(T value){ 
            stack.push(value); 
            if (minStack.isEmpty() || minStack.peek().compareTo(value) > 0 ){ 
                minStack.push(value); 
            }
        }
        public T pop(){ 
            T value = stack.pop(); 
            if (value.compareTo(minStack.peek()) <= 0) { 
                minStack.pop(); 
            }
            return value; 
        }
        
        public T min(){ 
            return minStack.peek(); 
        }
        public T peek(){ 
            return stack.peek(); 
        }
        
    }
    public static void main(String[] args){ 
        var ms = new MinStack<Integer>(); 
        ms.push(5); 
        ms.push(6); 
        ms.push(3); 
        ms.push(7); 
        System.out.println(ms.min()); 
        assert ms.min() == 3: "Error step 1"; 
        ms.pop();
        System.out.println(ms.min()); 
        assert ms.min() == 3: "Error step 2"; 
        ms.pop();
        System.out.println(ms.min()); 
        assert ms.min() == 5: "Error step 3"; 
        System.out.println("AC"); 
    }
}
