/* 
 * If we use normal concatentation => with substring length k the 
 * runtime will be O(k^2)
 *
 *
 * aabcccccaaa 
 * c = 'a'
 * 
 * 'a2b1c4'
 *
 */ 
class Solution { 
    public static void main(String[] args){ 
        var s = new Solution(); 
        // String is immutable => compare by value not reference 
        assert s.compress("aabcccccaaa").equals("a2b1c5a3") : "Not compress success"; 
        System.out.println("AC"); 
    }
    public String compress(String s){ 
        if (s == null) return null; 
        if (s.length() == 0) return ""; 
        var sb = new StringBuilder(); 
        char c = s.charAt(0); 
        // Track current character count 
        int count = 0; 
        // If empty string or null => return nothing or null 
        // Create string builder to storage result 

        for (int i = 0; i < s.length(); i++){ 
            // Increase the count track every iteration 
            // init count = 0 then increase every time if current character not diffrent with c 
            if (s.charAt(i) == c){ 
                count ++; 
            }else { 
            // If catch different chracter => flush string and init new character with count  is 1 
                sb.append(c); 
                sb.append(count); 
                c = s.charAt(i); 
                count = 1; 
            }
        }
        
        // Flush string after iteration over 

        sb.append(c); 
        sb.append(count); 

        // Return compressed string 
        return sb.toString(); 
    }


}
