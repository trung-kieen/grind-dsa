class Solution { 

    public static boolean oneWay(String a, String b){ 
        // If 2 diffeerent each one must consider 
        int [] freq = new int[26]; 
        for (char c: a.toCharArray()){ 
            freq[c - 'a'] += 1; 
        }
        for (char c: b.toCharArray()){ 
            freq[c - 'a'] -= 1; 
        }

        int numDiff = 0; 
        for (int i = 0; i < freq.length; i++){ 
            if (Math.abs(freq[i]) > 1){ 
                return false; 
            }
            if (Math.abs(freq[i]) == 1){ 
                numDiff ++; 
            }
        }

        return numDiff <= 2; 
    }

    public static void main(String [] args){ 
        assert oneWay("pales", "pale") : "ERROR 1"; 
        assert oneWay("pale", "bale") : "ERROR 2"; 
        assert !oneWay("pale", "bake") : "ERROR 3"; 
        assert oneWay("ppale", "pbale") : "ERROR 4"; 
        assert oneWay("paless", "pales") : "ERROR 5"; 
        System.out.print("AC"); 

    }
}
