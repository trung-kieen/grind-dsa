
/*
 * ? Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 */
class CheckPermuationCharTable {
  public boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    // Create hash table with custom length assumption
    byte chars[] = new byte[128]; // Assumption

    // Interate to set the refreq of first sequence
    for (char c: s.toCharArray()){ 
        // int value = (int) c; 
        chars[(byte) c]++; 
    }
    // Interate to reduce sequence of second sequence
    for (char c : t.toCharArray()) {
      byte value = (byte) c;
      chars[value]--; 
      if (chars[value] < 0) {
        return false;
      }
    }
    // for (int i = 0; i < t.length(); i++) {
    //   if (chars[i] != 0) {
    //     return false;
    //   }
    //   return true;
    // }

    return true;
    // Return true if blank of freq table
    // return sort(s).equals(sort(t));

  }

  public static void main(String[] args) {
    var s = new CheckPermuationCharTable();
    assert s.permutation("ASD", "DSA") : "Test 1 failed";
    assert !s.permutation("asd", "DSA") : "Test 2 failed";
    System.out.println("AC");
  }

}
