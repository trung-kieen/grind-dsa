class Solution  {

    public static void main (String [] args){ 
        var s = new Solution(); 
        assert s.isUnique("123"): "must unqiue 123"; 
        assert !s.isUnique("112"): "must not unique 123"; 

    }
    public boolean isUnique(String s){ 
        // Fixed memory to O(1)
        boolean [] chars = new boolean [256]; 
        // Use O(n) run time to check is unique
        for (int i =0; i< s.length(); i++){ 
            int idx = (int) s.charAt(i); 
            if (chars[idx]){ 
                return false;
            }
            chars[idx] = true; 
        }
        return true; 
    }

}
