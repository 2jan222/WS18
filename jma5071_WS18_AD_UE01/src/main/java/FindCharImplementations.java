import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * @author Janik Mayr on 11.10.2018
 */
public class FindCharImplementations {
    /**
     * O(n), Ω(1), θ(1 bzw. Alphabet/2 -> Alphabet)
     * @param str input string
     * @param ch char to search for
     * @return first index, if not found -1
     */
    static int findCharLeft(String str, char ch) {
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) - ch) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * O(n), Ω(1), θ(n)
     * @param str input string
     * @param ch char to search for
     * @return first index, if not found -1
     */
    static int findCharRight(String str, char ch) {
        for (int i = str.length(); i > 0; i--) {
            if ((str.charAt(i-1) - ch) == 0) {
                return i-1;
            }
        }
        return -1;
    }

    /**
     * O(n), Ω(1), θ(K) K = |Alphabet|
     * @param str input string
     * @param ch char to search for
     * @return first index, if not found -1
     */
    static int findCharRandom(String str, char ch) {
        int len = str.length();
        Random random = new Random();
        int access;
        HashSet<Integer> set = new HashSet<>(len);
        while (len > 0) {
            access = Math.abs(random.nextInt())%str.length();
            if (str.charAt(access)-ch == 0) {
                return access;
            } else {
                if (!set.contains(access)) {
                    set.add(access);
                    len--;
                }
            }
        }
        return -1;
    }

}
