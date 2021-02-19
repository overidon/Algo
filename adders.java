import java.util.Stack;

public class Adders {

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
            if (!SB.empty())  { BNUM = SB.pop() - 48; }

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
