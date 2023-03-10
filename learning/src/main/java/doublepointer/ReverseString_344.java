package doublepointer;

/**
 * @author cwp
 * @date 2023-03-08 11:46
 */
public class ReverseString_344 {

    public static void main(String[] args) {
        ReverseString_344 reverseString_344 = new ReverseString_344();

        char[] s = {'h', 'e', 'l', 'l', 'o','g'};

        reverseString_344.reverseString(s);
        System.out.println(s);
    }


    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;


        while (left < (s.length / 2)) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }


    }
}
