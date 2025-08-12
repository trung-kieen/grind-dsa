
/*
 * ? Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 *
 */
class CheckPermuationSort  {
    public boolean permutation(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        return sort(s).equals(sort(t));
    }
    public static void main(String[] args){
    var s = new CheckPermuationSort();
    assert s.permutation("ASD", "DSA") : "Test 1 failed";
    assert !s.permutation("asd", "DSA") : "Test 2 failed";
    System.out.println("AC"); 
    }
    public static String sort(String s){
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }

}
