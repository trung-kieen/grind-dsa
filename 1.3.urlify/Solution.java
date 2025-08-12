/*
 * Example 
 * "Mr John Smith____          "
 *                  ^ (we find the position to perform backward)
 *  The result should be like below 
 *  Mr%20John%20Smith
 *                  
 * "Mr John Smith____          "
 *              ^   ^              
 *              i   j 
 *
 *
 * Move character from i to j 
 * - i start at the position of trueLength 
 * - j start at the position of trueLength + 2 * numberOfSpaceBeforeTrueLength 
 *
 *  What if the j position is out of bound => ignore if trueLength + 2 * numberOfSpaceBeforeTrueLength >= length 
 *
 *
 *  What if we catch the white space in i ? 
 *  In j we will convert ' ' to 3 character ['%', '2', '0' ]
 *
 *
 *
 *
 */
class Solution { 

    public static void main (String[] args){ 
        var s = new Solution(); 
        var str = "Mr John Smith                 ".toCharArray(); 
        s.replaceCharacters(str, 13); 
        System.out.println(str); 
        

    }
    public void replaceCharacters(char[] str, int trueLength){ 
        // Find the end index 
        int whiteSpaceAmount = 0; 
        for (int i = 0; i < trueLength; i++){ 
            if (str[i] == ' ') { 
                whiteSpaceAmount ++; 
            }
        }

        int newTrueLength = trueLength + 2 * whiteSpaceAmount; 
        if (newTrueLength >= str.length){ 
            // Out of bound 
            return ;
        }
        str[newTrueLength] = '\0'; 
        int j = newTrueLength  - 1; 
        for (int i = trueLength - 1; i >=0; i --){ 
            if (str[i] == ' '){ 
                str[j]  = '0'; 
                str[j-1]  = '2'; 
                str[j-2]  = '%'; 
                j-=3; 

            } else{ 
                str[j]=str[i]; 
                j-=1; 
            }
        }

        // From end index make in place change 

        // Go until i = - 1 

        // If not white space => copy character in i to character in j  and move j backward 1 unit 

        // Else copy 3 character then move j 3 unit 
    }
}
