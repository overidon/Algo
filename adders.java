import java.util.Stack;

public class Adders {
    
    
   /**
   * This method is used to add two numbers that are too large to be normal integers. 
   * Tyler Stansfield Jaggers - 2/19/2020 
   * 2/19/2020 -> The reason why I used the number 48 is because that will turn the ASCII value of the char 
   * into the appropriate integer value ::: the char 1 will have the ASCII value of 49 and so forth. 
   * Complexity (SPACE): 
   * 1. This algorithm requires a Stack with A + 1 or B + 1 total elements - N additional space
   * 2. The reason why I used stacks to back the algorithm is because I wanted to avoid concatentating the strings and using slower heap space
   * 2.continued... also since strings are immutable concatenation would have increased the memory requirement 2 * !n - I didn't find this acceptable. 
   * 3. I also used a char array to store the result. So this adds another point of A + 1 or B + 1 space. 
   * 3.continued... So at this point we're bascially at (O) 3*N
   * 4. Finally the returned result is string so that adds 1 more N -> (O) 4*N
   * 5. Since the space complexity has not changed in relative magnitude, the space complexity reduces to (O)N
   
   ** Complexity(TIME)
   * 1. This algorithm requires a for loop for each stack -> (O) 2 * N
   * 2. Then there is a while loop against the largest length stack adding another N 
   * 3. Inside the while loop are pops and and if / else which adds nominal time complexity
   * 4. Finnaly the conversion from char array to string is another N since it is backed by a linear array copy / search 
   * 5. Adding everything up we get (O) 4 * N 
   * 5. Since the time complexity has not changed in relative magnitude, the time complexity reduces to (O)N
    
   * @param a  - A String representing the first number
   * @param b  - A String representing the second number
   * @return String - The result of adding both strings values together
   */
    String stackAdd(String a, String b){

        Stack<Character> SA = new Stack<Character>();
        Stack<Character> SB = new Stack<Character>();

        for (int i = 0; i < a.length(); i++) { SA.add(  a.charAt(i)); }
        for (int i = 0; i < b.length(); i++) { SB.add(  b.charAt(i)); }

        int SAL = SA.size();
        int SBL = SB.size();

        int resultCap = Math.max(SAL, SBL) + 1;
        int carry = 0;

        char [] arr = new char[resultCap];

        int index = arr.length - 1;

        while ( !SA.empty() || !SB.empty()) {

            int ANUM = 0;
            int BNUM = 0;

            if (!SA.empty()) { ANUM = SA.pop() - 48; }
            if (!SB.empty()) { BNUM = SB.pop() - 48; }

            int sum = ANUM + BNUM + carry;

            if ( sum > 9) {
                carry = 1;
                arr[index] = (char) ((sum - 10 ) + 48);

            } else {
                carry = 0;
                arr[index] = (char) (sum + 48);
            }

            index--;

        }

 	return new String(arr);
    }

}
